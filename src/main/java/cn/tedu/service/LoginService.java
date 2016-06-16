package cn.tedu.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.tedu.entity.Admin;




/**
 * 
 * @author zjh
 *
 */

public interface LoginService {
	
	
	public Admin login(Admin admin,HttpServletRequest request, HttpSession session);
	
	public void img(HttpServletResponse response, HttpSession session);
}
