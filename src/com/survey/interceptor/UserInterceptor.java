/*
 * @(#)UserInterceptor.java 2013-4-10 ÏÂÎç02:26:57 Order
 */
package com.survey.interceptor;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.survey.action.BaseAction;
import com.survey.service.UserService;

/**
 * UserInterceptor
 * @author wang
 * @version 1.0
 *
 */
@Component("userInterceptor")
public class UserInterceptor implements Interceptor {

    public static final String USER_SESSION_KEY = "_user_";

    @Resource(name = "userService")
    private UserService userService;

    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        Map<String, Object> session = ai.getInvocationContext().getSession();
        Integer id = (Integer) session.get(UserInterceptor.USER_SESSION_KEY);
        BaseAction action = (BaseAction) ai.getAction();
        if (id != null) {
            action.setLoginUser(userService.getEntityById(id));
        }
        String ret = ai.invoke();
        if (id == null && action.getLoginUser() != null) {
            session.put(USER_SESSION_KEY, action.getLoginUser().getId());
        }
        if (id != null && action.getLoginUser() == null) {
            session.remove(USER_SESSION_KEY);
        }
        return ret;
    }
}
