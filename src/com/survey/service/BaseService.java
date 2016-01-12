/*
 * @(#)BaseDao.java 2012-11-3 下午05:12:13 Shop-common
 */
package com.survey.service;

import java.io.Serializable;
import java.util.List;

/**
 * BaseDao DAO顶层接口
 * @author wang
 * @version 1.0
 * @param <T> 对应实体类型
 */
public interface BaseService<T> {
    /**
     * 保存实体信息
     * @param entity 实体信息
     */
    void save(T entity);

    /**
     * 删除实体信息
     * @param entity 实体信息
     */
    void delete(T entity);

    /**
     * 保存或更新实体信息
     * @param entity 实体信息
     */
    void saveOrUpdate(T entity);

    /**
     * 更新实体信息
     * @param entity 实体信息
     */
    void update(T entity);

    /**
     * 根据主键获取实体信息
     * @param id 主键
     * @return 实体信息
     */
    T getEntityById(Serializable id);

    /**
     * 获取所有数据
     * @return 集合 
     */
    List<T> list();
}
