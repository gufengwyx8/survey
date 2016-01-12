/*
 * @(#)QuestionServiceImpl.java 2014-1-10 ÉÏÎç09:58:33 Survey
 */
package com.survey.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.survey.dao.BaseDao;
import com.survey.dao.QuestionDao;
import com.survey.model.Question;
import com.survey.service.QuestionService;

/**
 * QuestionServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("questionService")
public class QuestionServiceImpl extends BaseServiceImpl<Question> implements QuestionService {

    @Resource(name = "questionDao")
    private QuestionDao questionDao;

    @Override
    protected BaseDao<Question> getBaseDao() {
        return questionDao;
    }

}
