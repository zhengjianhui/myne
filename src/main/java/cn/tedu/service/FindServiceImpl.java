package cn.tedu.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.dao.MyPageAndSize;
import cn.tedu.entity.Cost;
import cn.tedu.entity.Page;
import cn.tedu.util.DBAccess;


@Service("Find")
@Transactional(isolation=Isolation.DEFAULT)
public class FindServiceImpl implements FindService {

	/**
	 * 处理分页显示
	 */
	@Override
	public List<Cost> page(Page page) {
		// 连接数据库
		MyPageAndSize ms = DBAccess.getSession("myPage");
		
		return ms.find(page);
	}

}
