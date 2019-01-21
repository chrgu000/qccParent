package cn.com.qcc.managerclient.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.mapper.MycentMapper;
import cn.com.qcc.pojo.Mycent;

@Controller
public class UpLoadController {
	
	@Autowired
	MycentMapper mycentMapper;
	/*
	 * 上传身份证之内的审核
	 */
	@RequestMapping("/idpictureupload")
	@ResponseBody
	public ResultMap fileUpload2(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request)
			throws IOException {
		if (file.isEmpty()) {return ResultMap.build(400, "请选择文件");}
		String newName = IDUtils.genItemId();
		String oleName = file.getOriginalFilename();
		oleName = oleName.substring(oleName.lastIndexOf("."), oleName.length());
		newName = newName + oleName;
		String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/landlordpicture/" + newName;
		filePath = filePath.replace("/managerclient", "");
		File newFile = new File(filePath);
		// 通过CommonsMultipartFile的方法直接写文件（注意这个时候）
		file.transferTo(newFile);
		String returnstr = "https://www.zzw777.com/upload/landlordpicture/" + newName;
		return ResultMap.IS_200(returnstr);
	}
	
	/*上传合同模板 -- 我的合同-- */
	@RequestMapping("/uploadmycent")
	@ResponseBody
	public ResultMap agreement(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request
			,Long userid,String descname)
			throws IOException {
		if (descname == null || "".equals(descname)) {
			descname = "初建合同";
		}
		if (userid == null) {return ResultMap.build(400, "登录信息空!");}
		if (file.isEmpty()) {return ResultMap.build(400, "请选择文件!");}
		String newName = userid+ "_" + IDUtils.genItemId();
		String oleName = file.getOriginalFilename();
		oleName = oleName.substring(oleName.lastIndexOf("."), oleName.length());
		newName = newName + oleName;
		String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/mycent/" + newName;
		filePath = filePath.replace("/managerclient", "");
		File newFile = new File(filePath);
		// 通过CommonsMultipartFile的方法直接写文件（注意这个时候）
		file.transferTo(newFile);
		String returnstr = "https://www.zzw777.com/upload/mycent/" + newName;
		
		Mycent mycent = new Mycent();
		mycent.setCenturl(returnstr);
		mycent.setDescname(descname);
		mycent.setUserid(userid);
		mycent.setUpdate_time(new Date());
		mycentMapper.insertSelective(mycent);
		return ResultMap.build(200, "上传成功");
	}

}
