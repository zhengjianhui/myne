package cn.tedu.contorller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import cn.tedu.entity.Admin;
import cn.tedu.error.AppError;
import cn.tedu.service.LoginService;
import cn.tedu.service.LoginServiceImpl;
import cn.tedu.util.DBAccess;

/**
 * 处理登入相关
 * @author zjh
 *
 */
@Controller
public class Login {
	


	/**
	 * 转发登入页面
	 * @return
	 */
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		return "/main/login";
	}
	
	/**
	 * 处理登入
	 * @param admin
	 * @param servletRequest
	 * @param response
	 * @return
	 */
	@RequestMapping("/login.do")
	public ModelAndView login(HttpServletRequest request, HttpSession session, Admin admin) {
		LoginService log =  DBAccess.getSession("loginService");

		Admin a = null;
		ModelAndView mv = new ModelAndView();
		
		try {
			a = log.login(admin, request, session);
			
			// LoginService 验证时会抛出异常，程序走到这说明没错，重定向到主页
			RedirectView rv = new RedirectView("index.do");
			// 将重定向对象添加
			mv.setView(rv);
			// 将对象保存入session 用于后续操作（不添加拦截器不放行）
			session.setAttribute("admin", a);
			
		} catch (Exception e) {
			if(e instanceof AppError) {
				//  e.getMessage() 获取异常message （传入异常构造的参数）
				mv.addObject("error", e.getMessage());
				mv.setViewName("main/login");
				mv.addObject("admin", admin);
				// 没有实现自定异常则返回通用错误页面
			} else {
				mv.setViewName("main/login");
			}
		}
	
		return mv;
	}
	
	@RequestMapping("/img.do")
	public void img(HttpServletResponse response, HttpSession session) {
		
		LoginService log = new LoginServiceImpl();
		log.img(response, session);
	}
	
	
	/**
	 * 重定向到主页
	 */
	@RequestMapping("/index.do")
	public String index() {
		return "/main/index";
	}
	
	/**
	 * 处理退出
	 */
	@RequestMapping("/toLogout.do")
	public String toLogout(HttpSession session) {
		// 销毁Session对象
		session.invalidate();
		return "main/login";
	}
	
}
