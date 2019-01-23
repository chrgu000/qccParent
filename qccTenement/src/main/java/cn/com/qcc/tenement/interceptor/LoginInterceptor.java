package cn.com.qcc.tenement.interceptor;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import cn.com.qcc.common.Config;
import cn.com.qcc.common.ResourcesUtil;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Access;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.service.UserService;
import net.sf.json.JSONObject;
/*
 * 登录拦截器，注明哪些方法需要登录以后才可以进行的操作要 [此拦截器主要作用用后台用户登录作拦截]
 * 注意@requestMapping()设置成比如@requestMapping("/userlogin/XXX")
 * 
 */
public class LoginInterceptor implements HandlerInterceptor {
	@Autowired
	UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws IOException {
		// 先获得需要拦截 的URL
		List<String> open_urls = ResourcesUtil.gekeyList(Config.Intercepted_url);
		// 用户访问的url
		String url = request.getRequestURI();
		String urlname = userService.getaccessurl_name(url);
		if ("/Tenement/userback/login".equals(url)) {
			return true;
		}
		for (String open_url : open_urls) {
			if (url.indexOf(open_url) >= 0) {
				// 校验用户身份是否合法
				HttpSession session = request.getSession();
				UserCustomer activeUser = (UserCustomer) session.getAttribute("userback");
				if (activeUser != null) {
					// 检查用户是否有权限
					List<Access> accesses = activeUser.getAccess();
					if (accesses.isEmpty() || accesses.size() == 0) {
						JSONObject json = JSONObject.fromObject(ResultMap.build(900, "not allow in！！")); // 转换为json
						response.getWriter().write(json.toString());
						response.getWriter().flush();
						response.getWriter().close();
						return false;
					}
					for (Access acc : accesses) {
						if (url.equals(acc.getAccessurl())) {
							//重置SESSION
							session.setAttribute("userback", activeUser);
							return true;
						}
					}
					//如果是登录按钮
					if ("/Tenement/index".equals(url)) {
						request.getSession().setAttribute("error", "你没有登录后台的权限" );
						response.sendRedirect("/Tenement/login");
						return false;
					}
					JSONObject json = JSONObject.fromObject(ResultMap.build(900, "222",urlname)); // 转换为json
					response.setHeader("Content-type", "text/html;charset=UTF-8");
					response.getWriter().write(json.toString());
					response.getWriter().flush();
					response.getWriter().close();
					return false;

				} else {
					if ("/Tenement/index".equals(url)) {
						request.getSession().setAttribute("error", "你没有登录后台的权限");
						response.sendRedirect("/Tenement/login");
					} else {

					}
					// 在判断用户是否已经成功登陆
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
