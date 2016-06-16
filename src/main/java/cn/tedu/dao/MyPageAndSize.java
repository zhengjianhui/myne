package cn.tedu.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import cn.tedu.entity.Cost;
import cn.tedu.entity.Page;

/**
 * 自定义pageDao
 * @author zjh
 *
 */
@Repository("myPage")
@Scope("prototype")
public class MyPageAndSize implements PageAndSize{
	// 自动注入 SqlSessionTemplate 对象
	@Resource(name="temp")
	private SqlSessionTemplate temp;
	
	/**
	 * 查询页数
	 * @return
	 */
	public Integer sumRow() {
		
		return temp.selectOne("sumRow");
	}
	
	/**
	 * 查询分页
	 */
	public List<Cost> find(Page page) {
		
		return temp.selectList("find", page);
	}
}
