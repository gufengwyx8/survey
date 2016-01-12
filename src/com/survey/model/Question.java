/*
 * @(#)Question.java 2014-1-10 上午09:46:58 Survey
 */
package com.survey.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

/**
 * Question
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class Question {
    private Integer id;

    private String content;

    private String choose1, choose2, choose3, choose4;

    private Type type;

    private Survey survey;

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
     * 返回  content
     * @return content
     */
    @Lob
    public String getContent() {
        return content;
    }

    /**
     * 设置 content
     * @param content content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 返回  choose1
     * @return choose1
     */
    public String getChoose1() {
        return choose1;
    }

    /**
     * 设置 choose1
     * @param choose1 choose1
     */
    public void setChoose1(String choose1) {
        this.choose1 = choose1;
    }

    /**
     * 返回  choose2
     * @return choose2
     */
    public String getChoose2() {
        return choose2;
    }

    /**
     * 设置 choose2
     * @param choose2 choose2
     */
    public void setChoose2(String choose2) {
        this.choose2 = choose2;
    }

    /**
     * 返回  choose3
     * @return choose3
     */
    public String getChoose3() {
        return choose3;
    }

    /**
     * 设置 choose3
     * @param choose3 choose3
     */
    public void setChoose3(String choose3) {
        this.choose3 = choose3;
    }

    /**
     * 返回  choose4
     * @return choose4
     */
    public String getChoose4() {
        return choose4;
    }

    /**
     * 设置 choose4
     * @param choose4 choose4
     */
    public void setChoose4(String choose4) {
        this.choose4 = choose4;
    }

    /**
     * 返回  type
     * @return type
     */
    @Enumerated(EnumType.STRING)
    public Type getType() {
        return type;
    }

    /**
     * 设置 type
     * @param type type
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * 返回  survey
     * @return survey
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id")
    public Survey getSurvey() {
        return survey;
    }

    /**
     * 设置 survey
     * @param survey survey
     */
    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

}
