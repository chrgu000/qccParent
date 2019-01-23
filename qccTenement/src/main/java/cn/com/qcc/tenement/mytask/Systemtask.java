package cn.com.qcc.tenement.mytask;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.com.qcc.common.PayCommonConfig;
import cn.com.qcc.common.RedisUtil;
import cn.com.qcc.common.SendMessage;
import cn.com.qcc.common.SystemTaskTime;
import cn.com.qcc.detailcommon.JedisClient;
import cn.com.qcc.mapper.BuildingMapper;
import cn.com.qcc.mapper.HouseMapper;
import cn.com.qcc.mapper.VillageMapper;
import cn.com.qcc.mapper.VipcountMapper;
import cn.com.qcc.pojo.Building;
import cn.com.qcc.pojo.BuildingExample;
import cn.com.qcc.pojo.House;
import cn.com.qcc.pojo.HouseExample;
import cn.com.qcc.pojo.Lucre;
import cn.com.qcc.pojo.Village;
import cn.com.qcc.pojo.VillageExample;
import cn.com.qcc.pojo.Vipcount;
import cn.com.qcc.queryvo.UserCustomer;
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
				Long telephone = Long.valueOf(lurce.getDescname());
				String content = "尊敬的用户您好,您有新增收益:"  +
				updateaccount +"元,目前总收益余额为:"+totalaccount;
		        try {
					SendMessage.lurceAddSuccess(telephone , content );
				} catch (IOException e) {
					e.printStackTrace();
				}
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

}
