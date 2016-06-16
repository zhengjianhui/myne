package cn.tedu.dao;

import java.util.List;

import cn.tedu.entity.Admin;
import cn.tedu.util.Mydao;


@Mydao
public interface AdminDao {

	public List<Admin> adminFindAll(Admin admin);
}
