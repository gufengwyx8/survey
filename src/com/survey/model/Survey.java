/*
 * @(#)Survey.java 2014-1-10 上午09:46:15 Survey
 */
package com.survey.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * Survey
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class Survey {
    private Integer id;

    private String title;

    private String description;

    private List<Question> questionList;

    private Date date;

    private List<User> answeredUser;

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
     * 返回  title
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置 title
     * @param title title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 返回  description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置 description
     * @param description description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 返回  questionList
     * @return questionList
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "survey")
    public List<Question> getQuestionList() {
        return questionList;
    }

    /**
     * 设置 questionList
     * @param questionList questionList
     */
    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    /**
     * 返回  date
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * 设置 date
     * @param date date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 返回  answeredUser
     * @return answeredUser
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "survey_user", joinColumns = @JoinColumn(name = "survey_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    public List<User> getAnsweredUser() {
        return answeredUser;
    }

    /**
     * 设置 answeredUser
     * @param answeredUser answeredUser
     */
    public void setAnsweredUser(List<User> answeredUser) {
        this.answeredUser = answeredUser;
    }
}
