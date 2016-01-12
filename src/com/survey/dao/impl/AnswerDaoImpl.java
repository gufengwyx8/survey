/*
 * @(#)AnswerDaoImpl.java 2014-1-10 ÉÏÎç10:14:47 Survey
 */
package com.survey.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.survey.dao.AnswerDao;
import com.survey.model.Answer;
import com.survey.model.Survey;
import com.survey.model.User;

/**
 * AnswerDaoImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("answerDao")
public class AnswerDaoImpl extends BaseDaoImpl<Answer> implements AnswerDao {

    @Override
    public List<Answer> getAnswerBySurvey(Survey survey, User user) {
        String hql = "select a from Answer a where a.question.survey = ? and a.user = ?";
        Object[] param = new Object[] { survey, user };
        return this.list(Answer.class, hql, param);
    }

}
