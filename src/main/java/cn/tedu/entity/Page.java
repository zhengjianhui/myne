package cn.tedu.entity;

public class Page {
	// 总页数
	private Integer page;
	// 条数
	private Integer size;
	
	// 当前页数
	private Integer nowPage;
	// 从第几条开始
	private Integer now;
	
	public Integer getNowPage() {
		return nowPage;
	}
	public void setNowPage(Integer nowPage) {
		this.nowPage = nowPage;
	}

	
	public Integer getNow() {
		return now;
	}
	public void setNow(Integer now) {
		this.now = now;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	
	

}
