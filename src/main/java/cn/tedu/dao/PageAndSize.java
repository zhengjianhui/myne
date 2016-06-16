package cn.tedu.dao;

import java.util.List;

import cn.tedu.entity.Cost;
import cn.tedu.entity.Page;
import cn.tedu.util.Mydao;


/**
 * 处理分页
 * @author zjh
 *
 */
@Mydao
public interface PageAndSize {
	
	public Integer sumRow();
	
	public List<Cost> find(Page page);
}
