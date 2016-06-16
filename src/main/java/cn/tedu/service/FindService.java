package cn.tedu.service;

import java.util.List;

import cn.tedu.entity.Cost;
import cn.tedu.entity.Page;


public interface FindService {

	public List<Cost> page(Page page);
}
