package cn.com.qcc.managerclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.detailcommon.JedisClient;
import cn.com.qcc.pojo.Bdmanager;
import cn.com.qcc.pojo.Landlord;
import cn.com.qcc.queryvo.BuildingCustomer;
import cn.com.qcc.queryvo.UserRoomCustomer;
import cn.com.qcc.service.BDService;
import cn.com.qcc.service.CheckCodeService;

@Controller
@RequestMapping("/companion")
@ResponseBody
public class BDController {
	
	@Autowired
	BDService bdService;
	@Autowired
	CheckCodeService checkCodeService;
	@Autowired
	JedisClient jedisClient;
	
	@RequestMapping("/bdlogin/{type}")
	public ResultMap login (String account , String word ,@PathVariable int type ) {
		
		// 通过手机号或者账号查询
		Bdmanager maBdmanager = bdService.searchBDByPhoneOrId(account);
		System.out.println( maBdmanager.getState()  );
		if (CheckDataUtil.checkisEmpty(maBdmanager)
				||maBdmanager.getState().intValue() != 1) 
			return ResultMap.build(400, "账号禁用");
		
		// 通过验证码校验
		if (type == 1) {
			ResultMap resultMap = checkCodeService.DoCheckPhoneCode(word, Long.valueOf(account) );
			if (resultMap.getCode() !=200) 
				return resultMap;
		}
		// 通过密码校验
		else if (type ==2 ){
			//原始密码
			String orgPassword = maBdmanager.getPassword();
			// 现在密码
			String passWord = IDUtils.getprivatePassword(word);
			//String passWord  = word;
			if (CheckDataUtil.checkNotEqual(orgPassword, passWord)) {
				return ResultMap.build(400, "密码错误");
			}
		} else {
			return ResultMap.build(400,"请求错误");
		}
		
		maBdmanager.setPassword("");
		return ResultMap.build(200,"登录成功" , maBdmanager);
	}
	
	
	@RequestMapping("/bdchangloginword")
	public ResultMap changePassword(Long telephone , String code , String BD_ACCTOKEN , String password) {
		// 先校验手机验证码
		ResultMap resultMap = checkCodeService.DoCheckPhoneCode(code, telephone);
		if (resultMap.getCode() !=200) {
			return resultMap;
		}
		return bdService.changePassword (telephone ,BD_ACCTOKEN , password);
	}
	
	
	// 查询想要添加的用户
	@RequestMapping("/bdsearchUserToLand")
	public ResultMap searchUserToLand (String searchWhere) {
		List<UserRoomCustomer> landUserSearch = bdService.searchUserToLand(searchWhere);
		return ResultMap.IS_200(landUserSearch);
	}
	
	
	// BD添加房东
	@RequestMapping ("/bdaddLand")
	public ResultMap addLand (String BD_ACCTOKEN ,Landlord landlord , Long userid 
			) {
		return bdService.addLand(BD_ACCTOKEN ,landlord , userid);
	}
	
	
	// 我管理的房东
	@RequestMapping ("/bdmyLand")
	public ResultMap bdmyLand (String BD_ACCTOKEN  ,Long code ) {
		
		Bdmanager bdmanager = bdService.getBdidByToken(BD_ACCTOKEN);
		if (CheckDataUtil.checkisEmpty(bdmanager)
				|| bdmanager.getState().intValue() != 1 ) {
			return ResultMap.build(400, "你已被移除BD管理");
		}
		List<UserRoomCustomer> myLand = bdService.myLand(BD_ACCTOKEN , code);	
		return ResultMap.IS_200(myLand);			
	}
	
	
	// 查询想要添加的楼栋
	@RequestMapping("/searchAddBuildingToland")
	public ResultMap searchAddBuildingToland (String searchWhere) {
		List<BuildingCustomer> builList = bdService.searchAddBuildingToland(searchWhere);
		return ResultMap.IS_200(builList);
	}
	
	
	
	// 根据房东id查询楼栋列表
	@RequestMapping("/searchBuildingBylandId")
	public ResultMap searchBuildingBylandId (Long userid) {
		List<BuildingCustomer> builList = bdService.searchBuildingBylandId(userid);
		return ResultMap.IS_200(builList);
	}
	
	
	// 添加楼栋
	@RequestMapping("/addBuildingToland")
	public ResultMap addBuildingToland (  Long userid , Long buildingid) { 
		return bdService.addBuildingToland(userid , buildingid);
	}
	
	
	// 删除房东绑定的楼栋
	@RequestMapping("/deleteBuildingland")
	public ResultMap deleteBuildingland ( Long userid , Long buildingid) {
		return bdService.deleteBuildingland(userid , buildingid);
	}
	
	
	// 编辑的查询
	@RequestMapping("/bdlandeditsearch")
	public ResultMap bdlandeditsearch (Long userid ) {
		UserRoomCustomer bdlandeditsearch = bdService.bdlandeditsearch(userid);
		return ResultMap.IS_200(bdlandeditsearch);
	}
	
	
	// 移除房源
	@RequestMapping("/removeland")
	public ResultMap removeland (Long userid) {
		
		return bdService.removeland(userid);
	}
	
	
}
