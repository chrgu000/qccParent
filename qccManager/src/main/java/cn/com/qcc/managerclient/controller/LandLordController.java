package cn.com.qcc.managerclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.queryvo.LandlordCustomer;
import cn.com.qcc.service.LandLordService;

@Controller
@RequestMapping("/companion")
@ResponseBody
public class LandLordController {
	
	@Autowired
	LandLordService landLordService;
	
	/**添加管理员**/
	@RequestMapping("/addmanager")
	public ResultMap addmanager(Long userid , Long telephone) {
		
		if (CheckDataUtil.checkisEmpty(userid)
				|| CheckDataUtil.checkisEmpty(telephone)) {
			return ResultMap.build(400, "请输入添加的用户/检查登录状态");
		}
		
		// 1,校验房东的状态
	    LandlordCustomer landloadsearchdetail = landLordService.landloadsearchdetail(userid);
	    if (CheckDataUtil.checkisEmpty(landloadsearchdetail)
	    		|| CheckDataUtil.checkNotEqual(landloadsearchdetail.getLandstate(), 2)) {
	    	return ResultMap.build(400, "非房东用户");
	    }
		
	    // 2 , 通过电话号码校验用户信息 非房东-- 非管理 -- 存在该用户才可以添加
	    Long  managerUserid = landLordService.checkManagerByPhone(telephone);
	    if (CheckDataUtil.checkisEmpty(managerUserid)) {
	    	return ResultMap.build(400,"该电话已经有绑定管理信息不可添加");
	    }
	    
	    // 3- 建立房东和管理 的关系
	    landLordService.landAddManager(landloadsearchdetail.getUserid() , managerUserid );
		return ResultMap.build(200, "添加成功");
	}

}
