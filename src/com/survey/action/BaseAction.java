package com.survey.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.survey.model.User;
import com.survey.service.AnswerService;
import com.survey.service.QuestionService;
import com.survey.service.SurveyService;
import com.survey.service.UserService;

public class BaseAction extends ActionSupport implements SessionAware {

    @Resource(name = "userService")
    protected UserService userService;

    @Resource(name = "surveyService")
    protected SurveyService surveyService;

    @Resource(name = "questionService")
    protected QuestionService questionService;

    @Resource(name = "answerService")
    protected AnswerService answerService;

    //常用的页面参数
    protected User user;

    protected User loginUser;

    protected String msg;

    protected Integer id;

    protected int pageNo;

    protected int pageSize = 12;

    protected Map<String, Object> session;

    protected ValueStack getValueStack() {
        return ActionContext.getContext().getValueStack();
    }

    /**
     * 返回  user
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * 设置 user
     * @param user user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 返回  msg
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置 msg
     * @param msg msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 返回  id
     * @return id
     */
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
     * 返回  pageNo
     * @return pageNo
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * 设置 pageNo
     * @param pageNo pageNo
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 返回  loginUser
     * @return loginUser
     */
    public User getLoginUser() {
        return loginUser;
    }

    /**
     * 设置 loginUser
     * @param loginUser loginUser
     */
    public void setLoginUser(User loginUser) {
        this.loginUser = loginUser;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
