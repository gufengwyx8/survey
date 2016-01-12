/*
 * @(#)UserDao.java 2013-4-10 обнГ12:51:22
 * Order
 */
package com.survey.dao;

import com.survey.model.User;

/**
 * UserDao
 * @author wang
 * @version 1.0
 *
 */
public interface UserDao extends BaseDao<User> {
    User login(User user);
    
}
