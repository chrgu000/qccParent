package cn.com.qcc.managerclient.controller;

import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import WangYiUtil.WangYiCommon;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.common.SendMessage;
import cn.com.qcc.pojo.User;
import cn.com.qcc.service.UserService;
import sun.misc.BASE64Decoder;

@SuppressWarnings("restriction")
@Controller
public class SendMessageController {

	@Autowired
	UserService userService;

	/**
	 * 用户注册发送验证码
	 */
	@RequestMapping(value = "/Message/register")
	@ResponseBody
	public ResultMap sendRegMessage(Long telephone) throws IOException {
		User user = userService.getUserByphone(telephone);
		if (CheckDataUtil.checkNotEmpty(user)) 
			return ResultMap.build(102, "该手机号已被注册,即将跳转至登录界面", null);
		String TEMPLATEID = WangYiCommon.CODE_PHONE_REGISTER;
		Map<String, Object> map = SendMessage.doCodeSendMess(TEMPLATEID, telephone);
		// 解析返回的数据
		return DoCodeMapPrease(map ,telephone);
	}

	

	/**
	 * 用户通过验证码登录
	 * @param telephone : 登录的用户手机号码
	 */
	@RequestMapping(value = "/Message/login")
	@ResponseBody
	public ResultMap sendLoginMessage( Long telephone) throws IOException  {
		// 发送模板消息
		String TEMPLATEID = WangYiCommon.CODE_PHONE_LOGIN;
		Map<String, Object> map = SendMessage.doCodeSendMess(TEMPLATEID, telephone);
		// 返回解析后的结果集
		return DoCodeMapPrease(map, telephone);
	}

	/**
	 * 找回密码发送短信
	 */
	@RequestMapping(value = "/Message/findPwd")
	@ResponseBody
	public ResultMap findPwdMessage(Long telephone) throws IOException {
		User user = userService.getUserByphone(telephone);
		if (CheckDataUtil.checkisEmpty(user)) 
			return ResultMap.build(102, "该用户尚未注册,即将跳转至注册界面");
		String TEMPLATEID = WangYiCommon.CODE_PHONE_PASSWORDCHANGE;
		Map<String, Object> map = SendMessage.doCodeSendMess(TEMPLATEID, telephone);
		// 返回解析后的结果集
		return DoCodeMapPrease(map, telephone);
		
	}
	
	
	/**
	 *修改绑定手机号码
	 */
	@RequestMapping(value = "/Message/updatephone")
	@ResponseBody
	public ResultMap updatephone( Long telephone) throws IOException {
		User user = userService.getUserByphone(telephone);
		if (CheckDataUtil.checkNotEmpty(user)) 
			return ResultMap.build(400, "该手机号已经被注册");
		String TEMPLATEID = WangYiCommon.CODE_PHONE_UPDATE;
		Map<String, Object> map = SendMessage.doCodeSendMess(TEMPLATEID, telephone);
		// 返回解析后的结果集
		return DoCodeMapPrease(map, telephone);

	}
	
	
	
	
	
	
	
	

	// 将 s 进行 BASE64 编码
	public static String getBASE64(String s) {
		if (s == null)
			return null;
		return (new sun.misc.BASE64Encoder()).encode(s.getBytes());
	}

	// 将 BASE64 编码的字符串 s 进行解码
	public static String getFromBASE64(String s) {
		if (s == null)
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(s);
			return new String(b);
		} catch (Exception e) {
			return null;
		}
	}
	
	
	/**
	 * 解析关于验证码回调的结果
	 * @param map : 返回的结果集
	 * @param telephone: 发送用户的电话号码
	 * **/
	private ResultMap DoCodeMapPrease(Map<String, Object> map , Long telephone) {
		Integer result = (Integer)map.get("code");
		if (result == 200) { // 如果为0，表示成功发送
			String code1 =(String)map.get("obj");
			String code = getBASE64(code1);
			userService.insertcheckcode(code,telephone,"3");
			return ResultMap.build(200, code);
		} else {
			return ResultMap.build(100, "短信发送失败");
		}
	}
	
	
	
	
}
