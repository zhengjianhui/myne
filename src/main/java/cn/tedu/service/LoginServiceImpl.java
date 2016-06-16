package cn.tedu.service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.dao.MyAdminDao;
import cn.tedu.entity.Admin;
import cn.tedu.error.AppError;
import cn.tedu.util.DBAccess;
import cn.tedu.util.ImageUtil;

@Service("loginService")
public class LoginServiceImpl implements LoginService{
	
	@Resource(name="myAdmin")
	private MyAdminDao dao;
	
	
	public MyAdminDao get() {
		return dao;
	}
	
	public Admin login(Admin admin, HttpServletRequest request, HttpSession session) {
		
		// 获取用户输入的验证码
		String vi = request.getParameter("vi");
		// 获取系统生成的验证码
		String imgCode = (String) session.getAttribute("imgCode");
		
		// 判断验证码的正确性
		if(vi == null || "".equals(vi) || !imgCode.equalsIgnoreCase(vi)) {
			throw new AppError("验证码错误");
		}

		// 验证码正确则判断账号密码
		// 获取账号密码 
		List<Admin> ad = null;
		if(admin.getCode() != null && !"".equals(admin.getCode())) {
		    dao = DBAccess.getSession("myAdmin");
			ad = dao.adminFindAll(admin);
		} else {
			throw new AppError("请正确输入账号");
		}
		
		// 验证账号密码的正确性
		if(ad.size() > 0) {
			// 将账号对应的用户信息取出
			admin = ad.get(0);
			String psd = request.getParameter("password");
			if(psd == null || "".equals(psd) || !admin.getPassword().equals(psd)) {	
				throw new AppError("密码错误");
			}	
		} else {
			throw new AppError("账号不存在");
		}
		
		return admin;
	}
	
	/**
	 * 处理图片请求
	 */
	public void img(HttpServletResponse response, HttpSession session) {
		
		Object[] obj = ImageUtil.createImage();
		
		// 将验证码保存
		session.setAttribute("imgCode", obj[0]);
		
		// 通知浏览器我在画什么
		response.setCharacterEncoding("image/png");
		
		
		try {
			// 向浏览器输出图片
			OutputStream os = response.getOutputStream();
			// 获取图片
			BufferedImage bi = (BufferedImage) obj[1];
			
			// 图片输出流
			ImageIO.write(bi, "png", os);
			
			// 将流关闭
			os.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
