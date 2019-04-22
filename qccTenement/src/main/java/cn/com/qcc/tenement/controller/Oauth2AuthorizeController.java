package cn.com.qcc.tenement.controller;

import weixin.popular.api.SnsAPI;
import weixin.popular.bean.sns.SnsToken;
import weixin.popular.bean.user.User;
import weixin.util.PayConfigUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.qcc.common.ResultMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/oauth")
public class Oauth2AuthorizeController {

	@RequestMapping("/oauth2AuthorizeController")
	@ResponseBody
	public ResultMap authorize(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 用户同意授权后，能获取到code
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		String qrcodeId = request.getParameter("qrcodeId");
		System.out.println(" code : " + code + " state: " + state + " qrcodeId:" + qrcodeId);
		// 用户同意授权
		if (!"authdeny".equals(code)) {
			SnsToken accessToken = SnsAPI.oauth2AccessToken(PayConfigUtil.APP_ID.trim(),
					PayConfigUtil.APP_SECRET.trim(), code);
			if (null != SnsAPI.auth(accessToken.getAccess_token(), code).getErrcode()) {
				accessToken = SnsAPI.oauth2RefreshToken(PayConfigUtil.APP_ID.trim(), accessToken.getRefresh_token());
			}
			User user = SnsAPI.userinfo(accessToken.getAccess_token(), accessToken.getOpenid(), "zh_CN");
			// 设置要传递的参数
			model.addAttribute("user", user);
			request.getSession().setAttribute("user", user);
			model.addAttribute("state", state);
			model.addAttribute("qrcodeId", qrcodeId);
		}

		return ResultMap.IS_200(model);// 跳转的页面

	}

}