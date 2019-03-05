package cn.com.qcc.managerclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Bdmanager;
import cn.com.qcc.service.BDService;
import cn.com.qcc.service.CheckCodeService;

@Controller
@RequestMapping("/companion")
public class BDController {
	
	@Autowired
	BDService bdService;
	@Autowired
	CheckCodeService checkCodeService;
	
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
			if (CheckDataUtil.checkisEqual(orgPassword, passWord)) {
				return ResultMap.build(400, "密码错误");
			}
			
		} else {
			return ResultMap.build(400,"请求错误");
		}
		maBdmanager.setPassword("");
		return ResultMap.build(200,"登录成功" , maBdmanager);
		
	}

}
