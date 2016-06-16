package cn.tedu.contorller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.entity.Cost;
import cn.tedu.entity.Page;
import cn.tedu.service.FindService;
import cn.tedu.service.FindServiceImpl;
import cn.tedu.util.PageUtil;


/**
 * 资费表
 * @author zjh
 *
 */
@Controller
public class Find {

	
	/**
	 * 处理资费表的分页显示
	 * @return
	 */
	@RequestMapping("/find.do")
	public String find(Integer page, HttpServletRequest request) {
		
		System.out.println(page);
		
		if(page == null) {
			page = 1;
		}
		// 获取分页信息
		Page pages = PageUtil.find(page);
		
		FindService find = new FindServiceImpl();
		List<Cost> cost = find.page(pages);
		// 想页面传递信息
		request.setAttribute("cost", cost);
		request.setAttribute("page", pages);
		return "cost/find";
	}

}
