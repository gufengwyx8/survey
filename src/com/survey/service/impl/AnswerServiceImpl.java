/*
 * @(#)AnswerServiceImpl.java 2014-1-10 ÉÏÎç10:16:59 Survey
 */
package com.survey.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.survey.dao.AnswerDao;
import com.survey.dao.BaseDao;
import com.survey.model.Answer;
import com.survey.model.Survey;
import com.survey.model.User;
import com.survey.service.AnswerService;

/**
 * AnswerServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("answerService")
public class AnswerServiceImpl extends BaseServiceImpl<Answer> implements AnswerService {
    @Resource(name = "answerDao")
    private AnswerDao answerDao;

    @Override
    protected BaseDao<Answer> getBaseDao() {
        return answerDao;
    }

    @Override
    public List<Answer> getAnswerBySurvey(Survey survey, User user) {
        return answerDao.getAnswerBySurvey(survey, user);
    }
}
