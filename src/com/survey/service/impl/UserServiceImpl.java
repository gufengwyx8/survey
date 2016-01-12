/*
 * @(#)UserServiceImpl.java 2013-4-10 ÏÂÎç01:36:55 Order
 */
package com.survey.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.survey.dao.BaseDao;
import com.survey.dao.UserDao;
import com.survey.model.User;
import com.survey.service.UserService;

/**
 * UserServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Resource(name = "userDao")
    private UserDao userDao;

    @Override
    public User login(User user) {
        User u = userDao.login(user);
        return u;
    }

    @Override
    public void regUser(User user) {
        user.setRole(User.USER_ROLE);
        userDao.save(user);
    }

    @Override
    protected BaseDao<User> getBaseDao() {
        return userDao;
    }

}
