/*
 * @(#)PagerContainer.java 2013-2-6 下午02:57:30 bishe
 */
package com.survey.util;

import java.util.ArrayList;
import java.util.List;

/**
 * PagerContainer
 * @author wang
 * @version 1.0
 *
 */
public class PagerContainer<T> {
    private List<T> data;

    private Integer pageNo;

    private Integer pageSize;

    public int getMaxPage() {
        if (data.size() % pageSize == 0) {
            return data.size() / pageSize;
        }
        return data.size() / pageSize + 1;
    }

    public List<T> getPagerData() {
        if (data == null) {
            return null;
        }
        List<T> result = new ArrayList<T>();
        result.addAll(data.subList((pageNo - 1) * pageSize, Math.min(data
                .size(), pageNo * pageSize)));
        return result;
    }

    /**
     * 返回  data
     * @return data
     */
    public List<T> getData() {
        return data;
    }

    /**
     * 设置 data
     * @param data data
     */
    public void setData(List<T> data) {
        this.data = data;
    }

    /**
     * 返回  pageNo
     * @return pageNo
     */
    public Integer getPageNo() {
        return pageNo;
    }

    /**
     * 设置 pageNo
     * @param pageNo pageNo
     */
    public void setPageNo(Integer pageNo) {
        if (pageNo == null) {
            pageNo = 1;
        }
        this.pageNo = pageNo;
    }

    /**
     * 返回  pageSize
     * @return pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置 pageSize
     * @param pageSize pageSize
     */
    public void setPageSize(Integer pageSize) {
        if (pageSize == null) {
            pageSize = 10;
        }
        this.pageSize = pageSize;
    }

    /**
     * 返回  count
     * @return count
     */
    public int getCount() {
        return data.size();
    }

}