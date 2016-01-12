/*
 * @(#)UserDaoImpl.java 2013-4-10 обнГ01:35:11 Order
 */
package com.survey.dao.impl;

import org.springframework.stereotype.Component;

import com.survey.dao.UserDao;
import com.survey.model.User;

/**
 * UserDaoImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    @Override
    public User login(User user) {
        String hql = "from User u where u.name = ? and u.password = ?";
        Object[] param = new Object[] { user.getName(), user.getPassword() };
        return this.find(User.class, hql, param);
    }

}
