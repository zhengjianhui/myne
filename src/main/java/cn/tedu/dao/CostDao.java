package cn.tedu.dao;

import java.util.List;

import cn.tedu.entity.Cost;
import cn.tedu.util.Mydao;


@Mydao
public interface CostDao {
	public List<Cost> findAll();
}
