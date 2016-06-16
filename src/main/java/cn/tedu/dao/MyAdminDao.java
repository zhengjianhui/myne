package cn.tedu.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import cn.tedu.entity.Admin;


/**
 * 编写dao接口实现并将其纳入bean容器管理
 * @author zjh
 *
 */
@Repository("myAdmin")
@Scope("prototype")
public class MyAdminDao {
	// 自动注入 SqlSessionTemplate 对象
	@Resource(name="temp")
	private SqlSessionTemplate temp;

	// 重写dao方法
	public List<Admin> adminFindAll(Admin admin) {
		// 需要手动编写sql 并将方法名传入
		return temp.selectList("adminFindAll",admin);
	}
	
	
	
	
}
