package cn.com.qcc.managerclient.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.PayCommonConfig;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.common.SimpleUpload;
import cn.com.qcc.detailcommon.AccountMgr;
import cn.com.qcc.mapper.MycentMapper;
import cn.com.qcc.pojo.Mycent;

@SuppressWarnings({ "resource", "unchecked", "static-access"  ,"deprecation"})
@Controller
public class UpLoadController {
	
	@Autowired
	MycentMapper mycentMapper;
	@Autowired JmsTemplate jmsTemplate;
	private final static String qnweb_path = "http://www.hadoop.zzw777.com/";
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
	
	
	
	
	
	@ResponseBody
    @RequestMapping(value="/orcPictureUpload", method=RequestMethod.POST)
    public ResultMap orcPictureUpload(@RequestParam MultipartFile orcPicture) {
		try {
			if (orcPicture.isEmpty())
				return ResultMap.build(400, "选择文件");
			String returnPath = "";
			String originName = orcPicture.getOriginalFilename();
			File uploadFile = null;
			String key = "";
			if (originName.contains(".jpg") || originName.contains(".png")) {
				
				// ==================================       上传到七牛云       ===================================
				// 获取文件后缀
				String lastName = originName.substring(originName.lastIndexOf("."), originName.length());
				// 设置上传的key
				key = IDUtils.genItemId() + lastName;
				// 上传到远程服务器
				SimpleUpload.doUpload(orcPicture, key);
				// 设置返回的路径
				returnPath += qnweb_path + key;
				uploadFile = new File(PayCommonConfig.LOCAL_UPLOAD_PATH + key);
				orcPicture.transferTo(uploadFile);
				
				System.out.println("七牛云上传路径:" + returnPath);
				
				// ================================     上传到数据宝      =========================================
				String POST_URL = "https://file.chinadatapay.com/img/upload?appkey=ecc71e33d7d3fd770e3c29dfeaada770";
				HttpClient httpclient = new DefaultHttpClient();
				HttpPost post = new HttpPost(POST_URL);
				FileBody fileBody = new FileBody(uploadFile);
				MultipartEntity entity = new MultipartEntity();
				entity.addPart("data", fileBody);
				post.setEntity(entity);
				HttpResponse response = httpclient.execute(post);
				HttpEntity r_entity = response.getEntity();
				String result = EntityUtils.toString(r_entity);
				System.out.println("返回结果：" + result);
				// 你需要根据出错的原因判断错误信息，并修改
				httpclient.getConnectionManager().shutdown();
				net.sf.json.JSONObject jsonobj = new net.sf.json.JSONObject().fromObject(result);
				Map<String, Object> map = (Map<String, Object>) jsonobj;
				String code = (String) map.get("code");
				String data = (String) map.get("data");
				String message = (String) map.get("message");
				if (!"10000".equals(code)) {
					return ResultMap.build(400, message);
				}
				// 封装返回的参数
				Map<String, Object> resultMap = new HashMap<>();
				resultMap.put("returnPath", returnPath);
				resultMap.put("orcPath", data);
				return ResultMap.build(200, "上传成功" , resultMap);
			} else {
				return ResultMap.build(400, "文件格式错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.build(400, "上传失败");
		}
		
		
    }

}
