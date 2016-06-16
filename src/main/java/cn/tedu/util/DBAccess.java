package cn.tedu.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DBAccess {

	public static <T>T getSession(String name) {
		ApplicationContext ac
			= new ClassPathXmlApplicationContext("classpath:conf/spring-mybatis.xml");
		return (T) ac.getBean(name);
	}
}
