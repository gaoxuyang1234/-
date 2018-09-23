package com.yxysoft.basic.model;

import java.util.List;

/**
 * @author Jesse
 * @date 2018/1/23
 */
public class PageBean<SysPunchIn> {
    /**
     * 当前页
     */
    private Integer currentPage = 1;
    /**
     * 每页显示的总条数
     */
    private Integer pageSize = 10;
   
    /**
     * 开始索引
     */
    private Integer startIndex;
    /**
     * 分页结果
     */
    private List<SysPunchIn> items;

    public PageBean() {
        super();
    }

    
    public PageBean(Integer currentPage, Integer pageSize,  List<SysPunchIn> items) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		
		this.items = items;
	}


	public PageBean(Integer currentPage, Integer pageSize) {
        super();
        this.currentPage = currentPage;
        this.pageSize = pageSize;
       
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

  

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public List<SysPunchIn> getItems() {
        return items;
    }

    public void setItems(List<SysPunchIn> items) {
        this.items = items;
    }
}
