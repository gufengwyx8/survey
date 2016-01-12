/*
 * @(#)BaseDao.java 2012-10-31 下午04:00:59 ShopService
 */
package com.survey.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.survey.dao.BaseDao;
import com.survey.util.PagerCallBack;

/**
 * BaseDao DAO顶层类
 * @author wang
 * @version 1.0
 * @param <E> DAO类型
 */
public class BaseDaoImpl<E> implements BaseDao<E> {

    /** HibernateTemplate */
    @Resource(name = "hibernateTemplate")
    protected HibernateTemplate hibernateTemplate;

    /**
     * 获取模糊查询字符串%%
     * @param str 查询字符串
     * @return 模糊查询字符串
     */
    public String getLikeString(String str) {
        return "%" + str + "%";
    }

    /**
     * 返回  hibernateTemplate
     * @return hibernateTemplate
     */
    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    /**
     * 设置 hibernateTemplate
     * @param hibernateTemplate hibernateTemplate
     */
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    /**
     * 根据查询HQL，返回特定对象集合
     * @param <T> 对象类型
     * @param cls 对象类型Class
     * @param hql 查询HQL
     * @return 特定对象集合
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> list(Class<T> cls, String hql) {
        List result = hibernateTemplate.find(hql);
        return (List<T>) result;
    }

    /**
     * 根据查询HQL，返回特定对象集合
     * @param <T> 对象类型
     * @param cls 对象类型Class
     * @param hql 查询HQL
     * @param params HQL参数 
     * @return 特定对象集合
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> list(Class<T> cls, String hql, Object[] params) {
        List result = hibernateTemplate.find(hql, params);
        return (List<T>) result;
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> list(Class<T> cls, String hql, Object[] params,
            int pageNo, int pageSize) {
        return (List<T>) hibernateTemplate.executeFind(new PagerCallBack(
                pageNo, pageSize, hql, params));
    }

    /**
     * 根据查询HQL，返回特定对象结果集中第一个结果，若无结果则返回null
     * @param <T> 对象类型
     * @param cls 对象类型Class
     * @param hql 查询HQL
     * @return 特定对象结果
     */
    @SuppressWarnings("unchecked")
    public <T> T find(Class<T> cls, String hql) {
        List result = hibernateTemplate.find(hql);
        if (result.size() > 0) {
            return (T) result.get(0);
        }
        return null;
    }

    /**
     * 根据查询HQL，返回特定对象结果集中第一个结果，若无结果则返回null
     * @param <T> 对象类型
     * @param cls 对象类型Class
     * @param hql 查询HQL
     * @param params HQL参数
     * @return 特定对象结果
     */
    @SuppressWarnings("unchecked")
    public <T> T find(Class<T> cls, String hql, Object[] params) {
        List result = hibernateTemplate.find(hql, params);
        if (result.size() > 0) {
            return (T) result.get(0);
        }
        return null;
    }

    /**
     * 根据主键删除实体
     * @param entity 实体对象
     */
    public void delete(E entity) {
        hibernateTemplate.clear();
        hibernateTemplate.delete(entity);
    }

    /**
     * 根据主键获取实体对象
     * @param id 主键
     * @return 实体对象
     */
    @SuppressWarnings("unchecked")
    public E getEntityById(Serializable id) {
        Class<E> entityClass = (Class<E>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        return (E) hibernateTemplate.get(entityClass, id);
    }

    /**
     * 保存实体到数据库中
     * @param entity 实体对象
     */
    public void save(E entity) {
        hibernateTemplate.save(entity);
    }

    /**
     * 保存或更新实体到数据库中
     * @param entity 实体对象
     */
    public void saveOrUpdate(E entity) {
        hibernateTemplate.saveOrUpdate(entity);
    }

    /**
     * 更新实体到数据库中
     * @param entity 实体对象
     */
    public void update(E entity) {
        hibernateTemplate.update(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<E> list() {
        Class<E> entityClass = (Class<E>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        return this.list(entityClass, "from " + entityClass.getSimpleName());
    }
}
