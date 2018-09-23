package com.yxysoft.base;

import java.util.HashMap;
import java.util.Map;

public class AcceptToolBean {
	
	private int page;
	private int count;
	private int size;
	//总页数
	private int pageCount;
	//当前页
	private int currentPage;
    private Map<String,Object> mas;
	public AcceptToolBean() {
		super();
		this.currentPage = 1;
		this.size = 15;
		this.mas = new HashMap<String, Object>();
	}

	public Map<String, Object> getMas() {
		return mas;
	}

	public void setMas(Map<String, Object> mas) {
		this.mas = mas;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
    
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void current(){
		this.page=(this.currentPage-1)*this.size;
	}
	
	public void pageCount(){
		if(count>0){
			this.pageCount=(this.count%this.size)==0?this.count/this.size:(this.count/this.size)+1;
		   }
	}
     
}
