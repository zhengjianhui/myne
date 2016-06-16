package cn.tedu.filter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.tedu.util.LoginInterceptorUtil;


/**
 * 用于权限的验证
 * @author zjh
 *
 */
public class Interceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// 获取请求的路径
		String servicePath = request.getServletPath();
		
		System.out.println(request.getSession().getAttribute("admin"));
		// 获取放行路径
		List<String> paths = LoginInterceptorUtil.paths();

		for(String x : paths) {
			if(servicePath.equals(x)) {
				return true;
			}
		}
		
		// 判断用户是否登入
		if(request.getSession().getAttribute("admin") == null) {
			System.out.println(request.getSession().getAttribute("admin"));
			// 跳转难道错误页面
			request.getRequestDispatcher("WEB-INF/main/error.jsp").forward(request, response);
			// 终止请求
			return false;
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
