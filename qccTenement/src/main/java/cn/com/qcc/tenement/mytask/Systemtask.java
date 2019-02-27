package cn.com.qcc.tenement.mytask;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import WangYiUtil.WangYiUtil;
import cn.com.qcc.common.DateUtil;
import cn.com.qcc.common.PayCommonConfig;
import cn.com.qcc.common.RedisUtil;
import cn.com.qcc.common.SendMessage;
import cn.com.qcc.common.SystemTaskTime;
import cn.com.qcc.detailcommon.ExcelExportSXXSSF;
import cn.com.qcc.detailcommon.JedisClient;
import cn.com.qcc.mapper.BuildingMapper;
import cn.com.qcc.mapper.HouseMapper;
import cn.com.qcc.mapper.VillageMapper;
import cn.com.qcc.mapper.VipcountMapper;
import cn.com.qcc.pojo.Building;
import cn.com.qcc.pojo.BuildingExample;
import cn.com.qcc.pojo.Historyexcle;
import cn.com.qcc.pojo.House;
import cn.com.qcc.pojo.HouseExample;
import cn.com.qcc.pojo.Lucre;
import cn.com.qcc.pojo.Village;
import cn.com.qcc.pojo.VillageExample;
import cn.com.qcc.pojo.Vipcount;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.service.AccessService;
import cn.com.qcc.service.HouseService;
import cn.com.qcc.service.InteService;
import cn.com.qcc.service.UserService;
import cn.com.qcc.service.VillageService;
import weixin.util.XiaoChengXuCodeUtil;

@Component
public class Systemtask {
	
	@Autowired UserService userService; 
	@Autowired VillageService villageService;
	@Autowired HouseService houseService;
	@Autowired HttpServletRequest request;
	@Autowired HouseMapper houseMapper;
	@Autowired BuildingMapper buildingMapper;
	@Autowired VillageMapper villageMapper;
	@Autowired InteService inteService;
	@Autowired VipcountMapper vipcountMapper;
	@Autowired JedisClient jedisClient;
	@Autowired AccessService accessService;
	
	
	/*
	 * 如果房源长时间没有更新，每个周五晚上3点10分自动下架
	 * */
	@Scheduled(cron=SystemTaskTime.house_undercarriage) 
	public void house_undercarriage() {
		System.out.println("进入定时任务one");
		String [] houseids = houseService.search7daysnotupdate();
		List<UserCustomer> users = houseService.search7daysnotupdateuser();
		for (UserCustomer user :users) {
			String content = "尊敬的用户,系统检测到您的";
			content += user.getBcount() +"套房源长期没有更新,已经自动下架。如需上架请点击https://www.zzw777.com!";
			SendMessage.houseundercarriage(user.getTelephone(), content, request);
		}
		houseService.update7dayundercarriage (houseids);
	}
	
	
	/*
	 * 定时任务 每天晚上生成小程序二维码
	 * */
	@Scheduled(cron=SystemTaskTime.build_xpxpicture) 
	public void buildxpxPictures() {
		System.out.println("进入定时任务two");
		// 生成房源的二维码吗
		HouseExample example = new HouseExample();
		HouseExample.Criteria criteria = example.createCriteria();
		criteria.andXcxpictureEqualTo("");
		List<House> houseList  = houseMapper.selectByExample(example);
		if (!houseList.isEmpty() && houseList.size() > 0) {
			for (House house : houseList) {
				// 生成小程序二维码图片
				String xcxpicture_qcc = XiaoChengXuCodeUtil.make_qcc_xcxqcode(house.getHouseid(), "housedetail");
				String xcxpicture_gzf = XiaoChengXuCodeUtil.make_gzf_xcxqcode(house.getHouseid(), "housedetail");
				house.setXcxpicture(xcxpicture_qcc + "," + xcxpicture_gzf);
				houseMapper.updateByPrimaryKey(house);
				
				//置空缓存
				try {
					jedisClient.del(RedisUtil.HOUSE_FIRST_KEY+house.getHouseid());
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
		
		// 生成楼栋的二维码
		BuildingExample buildingExample = new BuildingExample();
		BuildingExample.Criteria builcri = buildingExample.createCriteria();
		builcri.andXcxpictureEqualTo("");
		List<Building> builList = buildingMapper.selectByExample(buildingExample);
		if (!builList.isEmpty() && builList.size() > 0) {
			for (Building building : builList) {
				String xcxpic_qcc = XiaoChengXuCodeUtil.make_qcc_xcxqcode(building.getBuildingid(), "buildingdetail");
				String xcxpic_gzf = XiaoChengXuCodeUtil.make_gzf_xcxqcode(building.getBuildingid(), "buildingdetail");
				building.setXcxpicture(xcxpic_qcc + "," +xcxpic_gzf);
				buildingMapper.updateByPrimaryKeySelective(building);
				
				//置空缓存
				try {
					jedisClient.del(RedisUtil.BUIL_FIRST_KEY+building.getBuildingid());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		// 生成小区的二维码
		VillageExample villageExample = new VillageExample();
		VillageExample.Criteria villcri = villageExample.createCriteria();
		villcri.andXcxpictureEqualTo("");
		List<Village> villList = villageMapper.selectByExample(villageExample);
		if (!villList.isEmpty() && villList.size() > 0) {
			for (Village village: villList) {
				//设置小区二维码图片
				String xcxpicture_qcc = XiaoChengXuCodeUtil.make_qcc_xcxqcode(village.getVillageid(), "villagedetail");
				String xcxpicture_gzf = XiaoChengXuCodeUtil.make_gzf_xcxqcode(village.getVillageid(), "villagedetail");
				village.setXcxpicture(xcxpicture_qcc + "," + xcxpicture_gzf);
				villageMapper.updateByPrimaryKeySelective(village);
			}
		}
	}
	
	
	/**
	 * 定时任务每天晚上 1点执行一次,
	 * 查询相隔 10天的金币收益做相加到总收益中
	 * **/
	@Scheduled(cron=SystemTaskTime.addlucre) 
	public void addlurce () {
		System.out.println("进入定时任务three");
		int daycount = PayCommonConfig.lurce_day_count;
		List<Lucre> lucreList =  inteService.searchNeedAddLurceByTime (daycount);
		// 如果数据存在
		if (! lucreList.isEmpty() && lucreList.size() > 0 ) {
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
				String content =updateaccount +","+totalaccount;
			}
		}
		
		//吧对应的数据更新为已经收益的状态
		inteService.updateLurceIsAddByTime(daycount);
	}
	
	
	
	// 每天11点执行一次
	@Scheduled(cron=SystemTaskTime.every_day_11) 
	public void every_day_11 () {
		System.out.println("进入定时任务three");
	}
	
	
	/**
	 * 每个月底执行一次楼栋统计数据
	 * @throws Exception 
	 * ***/ 
	public void tongjiloudong () throws Exception {
		String filePath = request.getSession().getServletContext().getRealPath("/")+"upload/hisexcle/";
		filePath = filePath.replace("/Tenement", "");
		String filePrefix = DateUtil.DateToStr("yyyy-MM-dd", new Date());
		filePrefix = filePrefix + "统计发布楼栋";
		int flushRows = 100;
		List<UserCustomer> buildingCustomers = villageService.censusbuilding("");
		for (UserCustomer user : buildingCustomers) {
			user.setNowlinknout(user.getBcount() - user.getNowlinkcount());
			user.setNowlandnout(user.getBcount() - user.getNowlandcount());
			user.setLinknout(user.getTcount() - user.getLinkcount());
			user.setLandnout(user.getTcount() - user.getLandcount());
		}
		List<String> fieldCodes = getbuildinguser_fieldCodes();
		List<String> fieldNames = getbuildinguser_fieldNames();
		ExcelExportSXXSSF excelExportSXXSSF = ExcelExportSXXSSF.start(filePath, "/", filePrefix, fieldNames,
				fieldCodes, flushRows);
		excelExportSXXSSF.writeDatasByObject(buildingCustomers);
		String webpath = excelExportSXXSSF.exportFile();
		String returnpath = "https://www.zzw777.com/upload/hisexcle"+webpath;
		
		Historyexcle historyexcle = new Historyexcle();
		historyexcle.setUserid(10000003L);
		historyexcle.setDescname(filePrefix);
		historyexcle.setHistoryexcleurl(returnpath);
		historyexcle.setUpdate_time(new Date());
		accessService.excleurladd(historyexcle);
	}
	
	
	
	
	
	private List<String> getbuildinguser_fieldCodes() {
		List<String> filedCodes = new ArrayList<String>();
		filedCodes.add("userid");
		filedCodes.add("user_name");
		filedCodes.add("telephone");
		filedCodes.add("bcount");
		filedCodes.add("nowlinkcount");
		filedCodes.add("nowlinknout");
		filedCodes.add("nowlandcount");
		filedCodes.add("nowlandnout");
		filedCodes.add("tcount");
		filedCodes.add("linkcount");
		filedCodes.add("linknout");
		filedCodes.add("landcount");
		filedCodes.add("landnout");
		return filedCodes;
	}

	private List<String> getbuildinguser_fieldNames() {
		List<String> fieldNames = new ArrayList<String>();
		fieldNames.add("用户ID");
		fieldNames.add("用户昵称");
		fieldNames.add("电话号码");
		fieldNames.add("本月总数");
		fieldNames.add("本月有联系电话");
		fieldNames.add("本月无联系电话");
		fieldNames.add("本月有房东电话");
		fieldNames.add("本月无房东电话");
		fieldNames.add("总计");
		fieldNames.add("总计有联系电话");
		fieldNames.add("总计无联系电话");
		fieldNames.add("总计有房东电话");
		fieldNames.add("总计无房东电话");
		return fieldNames;
	}
	
	
	

}
