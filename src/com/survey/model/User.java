/*
 * @(#)User.java 2013-4-10 下午12:51:27 Order
 */
package com.survey.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * User
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class User {

    public static final String USER_ROLE = "user";

    public static final String ADMIN_ROLE = "admin";

    private Integer id;

    private String name;

    private String password;

    private String role;

    /**
     * 返回  id
     * @return id
     */
    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    /**
     * 设置 id
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 返回  name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 返回  password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置 password
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 返回  role
     * @return role
     */
    public String getRole() {
        return role;
    }

    /**
     * 设置 role
     * @param role role
     */
    public void setRole(String role) {
        this.role = role;
    }


}
