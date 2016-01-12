/*
 * @(#)Answer.java 2014-1-10 ионГ10:14:21 Survey
 */
package com.survey.dao;

import java.util.List;

import com.survey.model.Answer;
import com.survey.model.Survey;
import com.survey.model.User;

/**
 * Answer
 * @author wang
 * @version 1.0
 *
 */
public interface AnswerDao extends BaseDao<Answer> {
    List<Answer> getAnswerBySurvey(Survey survey, User user);
}
