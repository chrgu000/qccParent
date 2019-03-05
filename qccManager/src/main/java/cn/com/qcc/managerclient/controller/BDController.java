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
		if (CheckDataUtil.checkisEmpty(maBdmanager)
				||maBdmanager.getState() == 0) 
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
		
		
		return ResultMap.build(200,"登录成功" , maBdmanager.getAcctoken());
	}
	
	
	@RequestMapping("/bdchangloginword")
	public ResultMap changePassword(Long telephone , String code , String BD_ACCTOKEN , String password) {
		
		// 通过ACCTION 获取BD id
		ResultMap resultMap = getBDID_BY_ACCTION(BD_ACCTOKEN );
		if (resultMap.getCode() != 200) 
			return resultMap;
		String bdid = resultMap.getObj().toString();
		// 先校验手机验证码
		resultMap = checkCodeService.DoCheckPhoneCode(code, telephone);
		if (resultMap.getCode() !=200) {
			return resultMap;
		}
		return bdService.changePassword (telephone ,bdid , password);
	}
	
	
	// 查询想要添加的用户
	@RequestMapping("/bdsearchUserToLand")
	public ResultMap searchUserToLand (String searchWhere) {
		List<UserRoomCustomer> landUserSearch = bdService.searchUserToLand(searchWhere);
		return ResultMap.IS_200(landUserSearch);
	}
	
	
	// BD添加房东
	@RequestMapping ("/bdaddLand")
	public ResultMap addLand (String BD_ACCTOKEN ,  Long userid , String address ,Long code ) {
		
		// 通过ACCTION 获取BD id
		ResultMap resultMap = getBDID_BY_ACCTION(BD_ACCTOKEN);
		if (resultMap.getCode() != 200) 
			return resultMap;
		String bdid = resultMap.getObj().toString();
		if (CheckDataUtil.checkisEmpty(bdid)
				|| CheckDataUtil.checkisEmpty(userid)) {
			return ResultMap.build(400,"操作失败");
		}
		
		return bdService.addLand(bdid , userid , address , code);
	}
	
	
	public ResultMap getBDID_BY_ACCTION (String BD_ACCTOKEN ) {
		
		return bdService.getBdidByToken(BD_ACCTOKEN);
		
	}
	
}
