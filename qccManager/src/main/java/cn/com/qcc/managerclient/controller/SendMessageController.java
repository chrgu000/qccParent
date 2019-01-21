package cn.com.qcc.managerclient.controller;

import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.common.SendMessage;
import cn.com.qcc.pojo.User;
import cn.com.qcc.service.UserService;
import sun.misc.BASE64Decoder;

@SuppressWarnings("restriction")
@Controller
@RequestMapping("/companion")
public class SendMessageController {

	@Autowired
	UserService userService;

	/**
	 * 用户注册发送验证码
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/Message/register")
	@ResponseBody
	public ResultMap sendRegMessage(Long telephone, HttpServletRequest request) throws IOException {
		User user = userService.getUserByphone(telephone);
		if (user != null) {
			return ResultMap.build(102, "该手机号已被注册,即将跳转至登录界面", null);
		} else {
			String m = null;
			Map<String, String> map = SendMessage.getCodeByRegister(telephone, request); // 应用发送短信接口
			// 返回结果为‘0，20140009090990,1，提交成功’ 发送成功 具体见说明文档
			String result = map.get("returnStr");
			String[] strs = result.split(",");
			for (int i = 0, len = strs.length; i < len; i++) {
				m = strs[0];
			}

			if (m.equals("0")) { // 如果为0，表示成功发送
				String code1 = (String) request.getSession().getAttribute("code");
				String code = getBASE64(code1);
				userService.insertcheckcode(code,telephone,"3");
				return ResultMap.build(200, code, null);
			} else {
				return ResultMap.build(100, "短信发送失败");
			}
		}
	}

	/**
	 * 用户登录发送验证码
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/Message/login")
	@ResponseBody
	public ResultMap sendLoginMessage(HttpServletRequest request, Long telephone) throws IOException {
	
			Map<String, Object> map = SendMessage.getCodeByLogin(telephone, request); // 应用发送短信接口
			// 返回结果为‘0，20140009090990,1，提交成功’ 发送成功 具体见说明文档
			Integer result = (Integer)map.get("code");
			if (result == 200) { // 如果为0，表示成功发送
				// String code = m.get("code"); //获取发送的验证码内容
				// logger.info("发送的验证码:"+code); //打印日志
				String code1 =(String)map.get("obj");
				String code = getBASE64(code1);
				userService.insertcheckcode(code,telephone,"3");
				return ResultMap.build(200, code);
			} else {
				return ResultMap.build(100, "短信发送失败");
			}
		
	}

	/**
	 * 找回密码发送短信
	 * 
	 * @param request
	 * @param Response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/Message/findPwd")
	@ResponseBody
	public ResultMap findPwdMessage(HttpServletRequest request, Long telephone) throws IOException {
		User user = userService.getUserByphone(telephone);
		if (user == null) {
			return ResultMap.build(102, "该用户尚未注册,即将跳转至注册界面");
		} else {
			String m = null;
			Map<String, String> map = SendMessage.getCodeFindPwd(telephone, request); // 应用发送短信接口
			// 返回结果为‘0，20140009090990,1，提交成功’ 发送成功 具体见说明文档
			String result = map.get("returnStr");
			String[] strs = result.split(",");
			for (int i = 0, len = strs.length; i < len; i++) {
				m = strs[0];
			}
			if (m.equals("0")) { // 如果为0，表示成功发送
				// String code = m.get("code"); //获取发送的验证码内容
				// logger.info("发送的验证码:"+code); //打印日志
				String code1 = (String) request.getSession().getAttribute("code");
				//把验证码存入数
				String code = getBASE64(code1);
				userService.insertcheckcode(code,telephone,"3");
				return ResultMap.build(200, code, null);
			} else {
				return ResultMap.build(100, "短信发送失败");
			}
		}

	}
	
	
	/**
	 * 找回密码发送短信
	 * 
	 * @param request
	 * @param Response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/Message/updatephone")
	@ResponseBody
	public ResultMap updatephone(HttpServletRequest request, Long telephone) throws IOException {
		User user = userService.getUserByphone(telephone);
		if (user != null) {
			return ResultMap.build(102, "该手机号已被注册.", null);
		} else {
			String m = null;
			Map<String, String> map = SendMessage.getCodeByUpdateTel(telephone, request);
			// 返回结果为‘0，20140009090990,1，提交成功’ 发送成功 具体见说明文档
			String result = map.get("returnStr");
			String[] strs = result.split(",");
			for (int i = 0, len = strs.length; i < len; i++) {
				m = strs[0];
			}
			if (m.equals("0")) { // 如果为0，表示成功发送
				String code1 = (String) request.getSession().getAttribute("code"); //明文
				//把对应的验证码存入数据库
				String code = getBASE64(code1);//暗纹
				userService.insertcheckcode(code,telephone,"3");
				return ResultMap.build(200, code, null);
			} else {
				return ResultMap.build(100, "短信发送失败");
			}
		}

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
}
