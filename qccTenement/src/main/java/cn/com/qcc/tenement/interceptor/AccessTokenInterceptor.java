package cn.com.qcc.tenement.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.com.qcc.common.Config;
import cn.com.qcc.common.ResourcesUtil;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.service.UserService;
import net.sf.json.JSONObject;

/**
 * ToKen 拦截器
 * **/ 
public class AccessTokenInterceptor implements HandlerInterceptor{
	
	@Autowired UserService userService;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 先获得需要拦截 的URL
		List<String> inteper_urls = ResourcesUtil.gekeyList(Config.Accestoken_url);
		// 用户访问的url
		String current_url = request.getRequestURI();
		System.out.println( "当前访问的地址=========" +  current_url);
		// 遍历拦截的url 如果是当前访问的url 需要进行拦截
		for (String inteper_url : inteper_urls) { 
			//说明这是需要拦截的url
			if (current_url.indexOf(inteper_url) >= 0) {
				// 判断是否能够获取到头部token
				String  token = (String)request.getHeader("Authorization");
				String userid  = userService.checkaccesstoken(token);
				//说明校验信息失败
				if (userid == null || "".equals(userid) ) {
					JSONObject json = JSONObject.fromObject(ResultMap.build(1000, "非法TOKEN")); // 转换为json
					response.setHeader("Content-type", "text/html;charset=UTF-8");
					response.getWriter().write(json.toString());
					response.getWriter().flush();
					response.getWriter().close();
					
					//这里在拦截之前需要向前台发出拦截失败的警告
					return false;
				} else {
					request.setAttribute("checkuserid", userid);
				}
			}
			
		}
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
