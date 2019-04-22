package cn.com.qcc.tenement.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.PayCommonConfig;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Sceneuser;
import cn.com.qcc.queryvo.WeiCustomer;
import cn.com.qcc.service.SceneuserService;
import weixin.util.HttpRequestUtil;
import weixin.util.MD5Util;
import weixin.util.WeiXinQRCode;

@Controller
public class WxTicketController {
	
	@Autowired
	SceneuserService sceneuserService;

	// 临时二维码  
	private final static String QR_SCENE = "QR_SCENE";  
	// 永久二维码  
	private final static String QR_LIMIT_SCENE = "QR_LIMIT_SCENE";  
	// 永久二维码(字符串)  
	private final static String QR_LIMIT_STR_SCENE = "QR_LIMIT_STR_SCENE";   
	// 创建二维码  
	private String create_ticket_path = "https://api.weixin.qq.com/cgi-bin/qrcode/create";  
	// 通过ticket换取二维码  
	private String showqrcode_path = "https://mp.weixin.qq.com/cgi-bin/showqrcode";  
	
	/** 
	 * 创建临时带参数二维码 
	 * @param accessToken 
	 * @expireSeconds 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒。 
	 * @param sceneId 场景Id 
	 * @return 
	 */  
	public ResultMap createTempTicket() {  
		
		String accessToken = MD5Util.getAccessToken(PayCommonConfig.qcc_gzhappid, PayCommonConfig.qcc_gzhsecret);
		String expireSeconds = "2592000";
		int sceneId = Integer.parseInt(IDUtils.genItemId().substring(0, 4));
	    WeiXinQRCode wxQRCode = new WeiXinQRCode();  
	      
	    TreeMap<String,String> params = new TreeMap<String,String>();  
	    params.put("access_token", accessToken);  
	    Map<String,Integer> intMap = new HashMap<String,Integer>();  
	    intMap.put("scene_id",sceneId);  
	    Map<String,Map<String,Integer>> mapMap = new HashMap<String,Map<String,Integer>>();  
	    mapMap.put("scene", intMap);  
	    
	    Map<String,Object> paramsMap = new HashMap<String,Object>();  
	    paramsMap.put("expire_seconds", expireSeconds);  
	    paramsMap.put("action_name", QR_SCENE);  
	    paramsMap.put("action_info", mapMap);  
	    String data = new Gson().toJson(paramsMap);  
	    data = HttpRequestUtil.HttpsDefaultExecute(HttpRequestUtil.POST_METHOD,create_ticket_path,params,data);  
	    try {  
	        wxQRCode = new Gson().fromJson(data, wxQRCode.getClass());
	    } catch (JsonSyntaxException e) {  
	        wxQRCode = null;  
	        e.printStackTrace();  
	    }  
	    
	    String ticket =  wxQRCode==null?null:wxQRCode.getTicket();  
	    String url =  showqrcode_path+"?ticket=" + ticket;
	    return ResultMap.IS_200(url);
	  
	}  
	  
	/** 
	 * 创建永久二维码(数字) 
	 * @param accessToken 
	 * @param sceneId 场景Id 
	 * @return 
	 */  
	@RequestMapping("/temporary")
	@ResponseBody
	public ResultMap createForeverTicket() {  
		WeiXinQRCode wxQRCode = new WeiXinQRCode();  
		String accessToken = MD5Util.getAccessToken(PayCommonConfig.qcc_gzhappid, PayCommonConfig.qcc_gzhsecret);
		Integer sceneId = sceneuserService.getMaxScenuserId();  
	    TreeMap<String,String> params = new TreeMap<String,String>();  
	    params.put("access_token", accessToken);  
	    //output data  
	    Map<String,Integer> intMap = new HashMap<String,Integer>();  
	    intMap.put("scene_id",sceneId);  
	    Map<String,Map<String,Integer>> mapMap = new HashMap<String,Map<String,Integer>>();  
	    mapMap.put("scene", intMap);  
	    //  
	    Map<String,Object> paramsMap = new HashMap<String,Object>();  
	    paramsMap.put("action_name", QR_LIMIT_SCENE);  
	    paramsMap.put("action_info", mapMap);  
	    String data = new Gson().toJson(paramsMap);  
	    data =  HttpRequestUtil.HttpsDefaultExecute(HttpRequestUtil.POST_METHOD,create_ticket_path,params,data);  
	    try {  
	        wxQRCode = new Gson().fromJson(data, wxQRCode.getClass());  
	    } catch (JsonSyntaxException e) {  
	        wxQRCode = null;  
	        e.printStackTrace();  
	    }  
	    String ticket =   wxQRCode==null?null:wxQRCode.getTicket();  
	    String url =  showqrcode_path+"?ticket=" + ticket;
	    Sceneuser sceneuser = new Sceneuser();
	    sceneuser.setSceneid(sceneId);
	    sceneuser.setUrl(url);
	    sceneuser.setUpdate_time(new Date());
	    sceneuser.setAllcount(0);
	    sceneuser.setNearcount(0);
	    sceneuser.setTicket(ticket);
	    sceneuserService.insersceneuser(sceneuser);
	    return ResultMap.IS_200();
	}  
	  
	/** 
	 * 创建永久二维码(字符串) 
	 *  
	 * @param accessToken 
	 * @param sceneStr 场景str 
	 * @return 
	 */  
	public String createForeverStrTicket(String accessToken, String sceneStr){        
	    TreeMap<String,String> params = new TreeMap<String,String>();  
	    params.put("access_token", accessToken);  
	    //output data  
	    Map<String,String> intMap = new HashMap<String,String>();  
	    intMap.put("scene_str",sceneStr);  
	    Map<String,Map<String,String>> mapMap = new HashMap<String,Map<String,String>>();  
	    mapMap.put("scene", intMap);  
	      
	    Map<String,Object> paramsMap = new HashMap<String,Object>();  
	    paramsMap.put("action_name", QR_LIMIT_STR_SCENE);  
	    paramsMap.put("action_info", mapMap);  
	    String data = new Gson().toJson(paramsMap);  
	    data =  HttpRequestUtil.HttpsDefaultExecute(HttpRequestUtil.POST_METHOD,create_ticket_path,params,data);  
	    WeiXinQRCode wxQRCode = null;  
	    try {  
	        wxQRCode = new Gson().fromJson(data, WeiXinQRCode.class);  
	    } catch (JsonSyntaxException e) {  
	        wxQRCode = null;  
	    }  
	    return wxQRCode==null?null:wxQRCode.getTicket();  
	}  
	
	
	
	
	
	
	
	@RequestMapping("/getallcode")
	@ResponseBody
	public ResultMap getAllForverCode(){
		List <WeiCustomer>  sceneuserlist = sceneuserService.getAllForverCode();
		setallcountcurrent(sceneuserlist);
		return ResultMap.IS_200(sceneuserlist);
	}
	
	
	private void setallcountcurrent(List<WeiCustomer> sceneuserlist) {
		for (WeiCustomer wei : sceneuserlist) {
			if ("".equals(wei.getAllcount()) || wei.getAllcount() == null ) {
				wei.setAllcount(0);
			}
			if("".equals(wei.getCurrentcount()) || wei.getCurrentcount() ==null){
				wei.setCurrentcount(0);
			}
			if ("".equals(wei.getComments()) || wei.getComments() == null) {
				wei.setComments("未定义描述");
			}
		}
	}

	@ResponseBody
	@RequestMapping("/editcode")
	public ResultMap getAllForverCode(Sceneuser sceneuser){
		sceneuserService.editCode(sceneuser);
		return ResultMap.IS_200();
	}
	
	@RequestMapping("/userlist")
	@ResponseBody
	public ResultMap getalluser(Integer sceneid){
		List <WeiCustomer> userlist = sceneuserService.getalluser(sceneid);
		return ResultMap.IS_200(userlist);
	}
}
