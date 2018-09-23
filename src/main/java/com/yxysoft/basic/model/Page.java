package com.yxysoft.basic.model;

import java.util.List;

/**
 * Created by 朱翰林 on 2018/7/24.
 */
public class Page<T> {
    private int pageSize;//每页显示的条数，在Servlet
    private int pageNum;//当前页码，该数据在Servlet中获取
    private int totalPage;//总页数，需要通过计算获得
    private int index;//分页开始的索引，通过计算获得
    private int totalRecord;//总记录，通过查询数据库获得
    private List<T> listDate;//分页的数据，通过数据库查询
    private String path;

    public Page(int totalRecord, int pageNumber, int pageSize) {
        super();
        this.totalRecord = totalRecord;
        this.pageNum = pageNumber;
        this.pageSize = pageSize;
    }
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getPageNum() {
        if(pageNum < 1){
            return 1;
        }else if(pageNum > getTotalPage()){
            return getTotalPage();
        }
        return pageNum;
    }
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    public int getTotalPage() {
        if(getTotalRecord()%getPageSize()==0){//判断总页数的计算方式
            return getTotalRecord()/getPageSize();
        }else{
            return getTotalRecord()/getPageSize()+1;
        }
    }
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getIndex() {
        return (getPageNum() - 1) * getPageSize();//获取索引的计算方式
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public int getTotalRecord() {
        return totalRecord;
    }
    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }
    public List<T> getListDate() {
        return listDate;
    }
    public void setListDate(List<T> listDate) {
        this.listDate = listDate;
    }

}
