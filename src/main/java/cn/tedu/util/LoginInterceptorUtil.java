package cn.tedu.util;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LoginInterceptorUtil {
	
	public static List<String> paths() {
		
		ApplicationContext ac
			= new ClassPathXmlApplicationContext("util.xml");
		
		return ac.getBean("loginInterceptor", List.class);
	}
}
