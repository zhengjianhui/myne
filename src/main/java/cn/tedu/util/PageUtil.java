package cn.tedu.util;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.dao.MyPageAndSize;
import cn.tedu.entity.Page;


/**
 * 分页工具类
 * @author zjh
 *
 */
public class PageUtil {

	/**
	 * 总条数
	 * @return
	 */
	public static Integer sumRow() {
		MyPageAndSize m = DBAccess.getSession("myPage");
		return m.sumRow();
	}
	
	/**
	 * 分页
	 * 单前页数有页面传入
	 */
	public static Page find(Integer nowPage) {
		Page page = new Page();
		// 存入当前页数
		page.setNowPage(nowPage);
		
		ApplicationContext ac
			= new ClassPathXmlApplicationContext("util.xml");
		// 获取分页条数
		Integer size = ac.getBean("size", Integer.class);
		page.setSize(size);
		
		// 计算总页数
		if(sumRow() % size != 0) {
			page.setPage(sumRow() / size + 1);
		} else {
			page.setPage(sumRow() / size);
		}
		
		// 计算查询条数起始点
		page.setNow((nowPage - 1) * size); 
		
		
		return page;
	}
	
}
