package cn.com.qcc.tenement.mytask;



import java.io.File;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.PayCommonConfig;
import cn.com.qcc.common.RedisUtil;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.common.SendMessage;
import cn.com.qcc.common.SimpleUpload;
import cn.com.qcc.common.SystemTaskTime;
import cn.com.qcc.detailcommon.JedisClient;
import cn.com.qcc.mapper.BrokerMapper;
import cn.com.qcc.mapper.BuildingMapper;
import cn.com.qcc.mapper.HouseMapper;
import cn.com.qcc.mapper.HouseorderMapper;
import cn.com.qcc.mapper.VillageMapper;
import cn.com.qcc.mapper.VipcountMapper;
import cn.com.qcc.mymapper.BackImageCustoermMapper;
import cn.com.qcc.mymapper.HouseCustomerMapper;
import cn.com.qcc.mymapper.UserCustomerMapper;
import cn.com.qcc.pojo.Broker;
import cn.com.qcc.pojo.Building;
import cn.com.qcc.pojo.House;
import cn.com.qcc.pojo.Houseorder;
import cn.com.qcc.pojo.Lucre;
import cn.com.qcc.pojo.Village;
import cn.com.qcc.pojo.Vipcount;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.service.AccessService;
import cn.com.qcc.service.BrowseService;
import cn.com.qcc.service.HouseService;
import cn.com.qcc.service.InteService;
import cn.com.qcc.service.PosterCreateService;
import cn.com.qcc.service.UserService;
import cn.com.qcc.service.VillageService;
import weixin.util.XiaoChengXuCodeUtil;

@Component
public class Systemtask {

	@Autowired
	UserService userService;
	@Autowired
	VillageService villageService;
	@Autowired
	HouseService houseService;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HouseMapper houseMapper;
	@Autowired
	BuildingMapper buildingMapper;
	@Autowired
	VillageMapper villageMapper;
	@Autowired
	InteService inteService;
	@Autowired
	VipcountMapper vipcountMapper;
	@Autowired
	JedisClient jedisClient;
	@Autowired
	AccessService accessService;
	@Autowired
	UserCustomerMapper userCustomerMapper;
	@Autowired
	BrowseService browseService;
	@Autowired
	BackImageCustoermMapper backImageCustoermMapper;
	@Autowired
	BrokerMapper brokerMapper;
	@Autowired
	PosterCreateService posterCreateService;
	@Autowired
	HouseCustomerMapper houseCustomerMapper;
	@Autowired
	HouseorderMapper houseorderMapper;


	/*
	 * 清空 7 天之前 没有支付的房源订单
	 */
	@Scheduled(cron = SystemTaskTime.delete_houseorder_notpay)
	public void deleteHosueNotPay() {
		List< Houseorder> list = houseCustomerMapper.houseOrerNotPay();
		if (CheckDataUtil.checkNotEmpty(list)) {
			for (Houseorder order : list) {
				houseorderMapper.deleteByPrimaryKey(order.getHouseorderid());
			}
		}
	}

	
	
	/*
	 * 如果房源长时间没有更新，每个周五晚上3点10分自动下架
	 */
	@Scheduled(cron = SystemTaskTime.house_undercarriage)
	public void house_undercarriage() {
		System.out.println("进入定时任务one");
		String[] houseids = houseService.search7daysnotupdate();
		List<UserCustomer> users = houseService.search7daysnotupdateuser();
		for (UserCustomer user : users) {
			String content = "尊敬的用户,系统检测到您的";
			content += user.getBcount() + "套房源长期没有更新,已经自动下架。如需上架请点击https://www.zzw777.com!";
			SendMessage.houseundercarriage(user.getTelephone(), content, request);
		}
		houseService.update7dayundercarriage(houseids);
	}

	/*
	 * 定时任务 每天晚上生成小程序二维码
	 */
	@Scheduled( cron = SystemTaskTime.build_xpxpicture)
	public void buildxpxPictures() {
		
		System.out.println("====================生成普通二维码执行任务===========================");
		// 经纪人生成普通二维码
		List<Broker> brokerList = backImageCustoermMapper.searchBrokerCreatePost();
		if (CheckDataUtil.checkNotEmpty(brokerList)) {
			for (Broker broker : brokerList) {
				// 生成小程序图片
				String xcxpicture = getCreateXPXpicture (broker.getUserid() , "brokerdetail") ;
				broker.setXcxpicture(xcxpicture);
				brokerMapper.updateByPrimaryKeySelective(broker);
			}
		}
		
		
		// 生成房源的二维码吗
		List<House> houseList = backImageCustoermMapper.searchHouseCommonCreate();
		if (CheckDataUtil.checkNotEmpty(houseList)) {
			for (House house : houseList) {
				// 生成小程序图片
				String detailName = "housedetail";
				if (house.getProperty_id() == 4 || house.getProperty_id() == 7 ) {
					detailName = "otherdetail";
				}
				String xcxpicture = getCreateXPXpicture (house.getHouseid() ,detailName) ;
				house.setXcxpicture(xcxpicture);
				houseMapper.updateByPrimaryKey(house);
				// 置空缓存
				try {
					jedisClient.expire(RedisUtil.HOUSE_FIRST_KEY + house.getHouseid() , 0);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}

		// 生成楼栋的二维码
		List<Building> builList = backImageCustoermMapper.searchbuilCommonCreate();
		if (CheckDataUtil.checkNotEmpty(builList)) {
			for (Building building : builList) {
				// 生成小程序图片
				String xcxpicture = getCreateXPXpicture (building.getBuildingid() , "buildingdetail") ;
				building.setXcxpicture(xcxpicture);
				buildingMapper.updateByPrimaryKeySelective(building);
				// 置空缓存
				try {
					jedisClient.expire(RedisUtil.BUIL_FIRST_KEY + building.getBuildingid(),0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		// 生成小区的二维码
		List<Village> villList = backImageCustoermMapper.searchvillCommonCreate();
		if (!villList.isEmpty() && villList.size() > 0) {
			for (Village village : villList) {
				// 设置小区二维码图片
				String xcxpicture = getCreateXPXpicture (village.getVillageid() , "villagedetail") ;
				village.setXcxpicture(xcxpicture);
				villageMapper.updateByPrimaryKeySelective(village);
			}
		}
		
		System.out.println("====================生成二维码完成===========================");
	}

	private String getCreateXPXpicture(Long id, String descName) {
		// 生成小程序二维码图片
		String uploadFilePath = PayCommonConfig.LOCAL_UPLOAD_PATH;
		String qccPostUrlName = XiaoChengXuCodeUtil.make_qcc_xcxqcode(id, descName);
		String gzfPostUrlName = XiaoChengXuCodeUtil.make_gzf_xcxqcode(id, descName);
		// 上传到七牛云
		SimpleUpload.upload(uploadFilePath +  qccPostUrlName, qccPostUrlName);
		SimpleUpload.upload(uploadFilePath +  gzfPostUrlName, gzfPostUrlName);
		String xcxpicture = PayCommonConfig.HADOOP_WEB_RETURN_PAHT + qccPostUrlName +","
				+PayCommonConfig.HADOOP_WEB_RETURN_PAHT + gzfPostUrlName;
		System.out.println(xcxpicture);
		return xcxpicture ;
	}

	/**
	 * 定时任务每天晚上 1点执行一次, 查询相隔 10天的金币收益做相加到总收益中
	 **/
	@SuppressWarnings("unused")
	@Scheduled(cron = SystemTaskTime.addlucre)
	public void addlurce() {
		System.out.println("进入定时任务three");
		int daycount = PayCommonConfig.lurce_day_count;
		
		// 在统计收益之前先把专职对应的房源佣金 前 N条的数据设置 已经收益的状态
		int n  = 6 ;
		userCustomerMapper.updateLurceSetIsLucredByBroker(n);
		// 这里是统计收益的
		List<Lucre> lucreList = inteService.searchNeedAddLurceByTime(daycount);
		// 如果数据存在
		if (!lucreList.isEmpty() && lucreList.size() > 0) {
			for (Lucre lurce : lucreList) {
				double updateaccount = lurce.getAccount();
				// 查询用户钱包做加法运算
				Vipcount updateuser = vipcountMapper.selectByPrimaryKey(lurce.getUserid());
				// 设置总收益
				double totalaccount = updateuser.getAccount() + lurce.getAccount();
				updateuser.setAccount(totalaccount);
				// 同步数据库
				vipcountMapper.updateByPrimaryKey(updateuser);
				// 发送短信提醒用户收益到账
				String telephone = lurce.getDescname();
				String content = updateaccount + "," + totalaccount;
			}
		}

		// 吧对应的数据更新为已经收益的状态
		inteService.updateLurceIsAddByTime(daycount);
	}

	// 每天11点执行一次
	@Scheduled(cron = SystemTaskTime.every_day_04)
	public void every_day_04() {
		List<Vipcount> vipList = userCustomerMapper.selectNotVip();
		if (CheckDataUtil.checkNotEmpty(vipList)) {
			for (Vipcount vip : vipList) {
				vip.setCount(100);
				vip.setIs_vip(0);
				vip.setCretime_time(new Date());
				vip.setBalance(0.0);
				vip.setHouseaccount(0.0);
				vip.setAccount(0.0);
				vip.setWeixinaccount("");
				vip.setPassword("");
				vipcountMapper.insertSelective(vip);
			}

		}
	}

	// 每个周六晚上 2点10分删除临时文件夹里面的数据
	@Scheduled(cron = SystemTaskTime.delete_uploadpic)
	public void deleteupload_picture() {
		System.out.println("进入删除文件方法");
		File file = new File(PayCommonConfig.LOCAL_UPLOAD_PATH);
		File[] tempList = file.listFiles();
		for (File f : tempList) { // 遍历File[]数组
			if (!f.isDirectory()) {
				System.out.println(f.getName());
				if (!f.getName().endsWith("txt")) {
					f.delete();
				}
			}
		}
	}

	/**
	 * 每个 周六 凌晨 5:10 同步求租的浏览量 1 ------>房源 2 ------>求租 3 ------>求购 4 ------>小区 5
	 * ------>楼栋 6 ------>部落找物品 7 ------>部落找人 8 ------>部落提问 9------>部落 10 ----签到
	 * 11-----留言
	 **/
	@Scheduled(cron = SystemTaskTime.sysc_qiuzu)
	public void sysc_qiuzu() {
		List<Long> qiuzuIds = browseService.searchIdnearTenDays(2);
		if (CheckDataUtil.checkNotEmpty(qiuzuIds)) {
			/// 只需要清空对应的缓存就可以
			for (Long id : qiuzuIds) {
				System.out.println(id);
				jedisClient.expire(RedisUtil.QIUZU_FIRST_KEY + id, 0);
			}
		}

	}

	@Scheduled(cron = SystemTaskTime.sysc_buil)
	public void sysc_buil() {
		List<Long> qiuzuIds = browseService.searchIdnearTenDays(5);
		if (CheckDataUtil.checkNotEmpty(qiuzuIds)) {
			/// 只需要清空对应的缓存就可以
			for (Long id : qiuzuIds) {
				System.out.println(id);
				jedisClient.expire(RedisUtil.BUIL_FIRST_KEY + id, 0);
			}
		}

	}

	@Scheduled(cron = SystemTaskTime.sysc_tribe)
	public void sysc_tribe() {
		List<Long> qiuzuIds = browseService.searchIdnearTenDays(9);
		if (CheckDataUtil.checkNotEmpty(qiuzuIds)) {
			/// 只需要清空对应的缓存就可以
			for (Long id : qiuzuIds) {
				System.out.println(id);
				jedisClient.expire(RedisUtil.TRIBE_FIRST_KEY + id, 0);
			}
		}

	}

	
	/**同步房源索引库***/
	@Scheduled(cron=SystemTaskTime.sysc_house)
	public void sysc_house() {
		int start = 0 ;
		int end = 0 ;
		String jsonData = jedisClient.get("house_sysc_start_end:");
		if (CheckDataUtil.checkNotEmpty(jsonData)) {
			String[] split = jsonData.split("-");
			try {
				start = Integer.valueOf( split[0] );
				end =   Integer.valueOf( split[1] );
			} catch (Exception e) {
				e.printStackTrace();
				end = 20000;
			}
		} else {
			end = 20000;
		}
		PageQuery pagequery = new PageQuery();
		pagequery.setPagestart(start);
		pagequery.setPageend(end);
		String value =( start+20000 ) +"-" + (end + 20000);
		ResultMap resultMap = houseService.searchAllHouseToSolr(pagequery);
		if (resultMap.getCode() == 400) {
			value = "0-20000";
		}
		jedisClient.set("house_sysc_start_end:", value);
	}
	
	/**同步楼栋索引库***/
	@Scheduled(cron=SystemTaskTime.sysc_building)
	public void sysc_building() {
		int start = 0 ;
		int end = 0 ;
		String jsonData = jedisClient.get("buil_sysc_start_end:");
		if (CheckDataUtil.checkNotEmpty(jsonData)) {
			String[] split = jsonData.split("-");
			try {
				start = Integer.valueOf( split[0] );
				end =   Integer.valueOf( split[1] );
			} catch (Exception e) {
				e.printStackTrace();
				end = 20000;
			}
		} else {
			end = 20000;
		}
		PageQuery pagequery = new PageQuery();
		pagequery.setPagestart(start);
		pagequery.setPageend(end);
		String value =( start+20000 ) +"-" + (end + 20000);
		ResultMap resultMap = villageService.addbuildngtosolr(null , pagequery);
		if (resultMap.getCode() !=200) {
			value = "0-20000";
		}
		jedisClient.set("buil_sysc_start_end:", value);
	}
	
	
	/**同步小区索引库***/
	@Scheduled(cron=SystemTaskTime.sysc_village)
	public void sysc_village() {
		int start = 0 ;
		int end = 0 ;
		String jsonData = jedisClient.get("vill_sysc_start_end:");
		if (CheckDataUtil.checkNotEmpty(jsonData)) {
			String[] split = jsonData.split("-");
			try {
				start = Integer.valueOf( split[0] );
				end =   Integer.valueOf( split[1] );
			} catch (Exception e) {
				e.printStackTrace();
				end = 20000;
			}
		} else {
			end = 20000;
		}
		PageQuery pagequery = new PageQuery();
		pagequery.setPagestart(start);
		pagequery.setPageend(end);
		String value =( start+20000 ) +"-" + (end + 20000);
		ResultMap resultMap =  villageService.addvillagetosolr(pagequery);
		if (resultMap.getCode() !=200) {
			value = "0-20000";
		}
		jedisClient.set("vill_sysc_start_end:", value);
	}
	
	
	
	/**同步房源海报**/
	@Scheduled(cron = SystemTaskTime.buil_PostImage)
	public void  sysc_haibao () {
		List<HouseCustomer> houselist = backImageCustoermMapper.searchHouseHaibaoCommonCreate();
		if (CheckDataUtil.checkNotEmpty(houselist)) {
			for (HouseCustomer house : houselist) {
				String prices = house.getPrices() + house.getPricetype();
				String apartmentname = house.getApartmentname();
				String onePicture = house.getPicture().split(",")[0];
				String detailName = "housedetail";
				if (house.getProperty_id() == 4 || house.getProperty_id() == 7 ) {
					detailName = "otherdetail";
				}
				posterCreateService.createHousePoster(prices, apartmentname, 
						onePicture, house.getHouseid() ,detailName);
				
				// 置空缓存
				try {
					jedisClient.expire(RedisUtil.HOUSE_FIRST_KEY + house.getHouseid() , 0);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
			
		}
		
	}
	
	
}
