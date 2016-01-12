/*
 * @(#)AnswerService.java 2014-1-10 ионГ10:15:21
 * Survey
 */
package com.survey.service;

import java.util.List;

import com.survey.model.Answer;
import com.survey.model.Survey;
import com.survey.model.User;

/**
 * AnswerService
 * @author wang
 * @version 1.0
 *
 */
public interface AnswerService extends BaseService<Answer> {
    List<Answer> getAnswerBySurvey(Survey survey, User user);
}
