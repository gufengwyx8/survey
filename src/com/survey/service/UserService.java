/*
 * @(#)UserService.java 2013-4-10 обнГ12:51:33 Order
 */
package com.survey.service;

import com.survey.model.User;

/**
 * UserService
 * @author wang
 * @version 1.0
 *
 */
public interface UserService extends BaseService<User> {
    User login(User user);

    void regUser(User user);

}
