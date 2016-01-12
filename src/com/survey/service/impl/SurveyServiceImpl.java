/*
 * @(#)SurveyServiceImpl.java 2014-1-10 ионГ09:59:59 Survey
 */
package com.survey.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.survey.dao.BaseDao;
import com.survey.dao.SurveyDao;
import com.survey.model.Survey;
import com.survey.service.SurveyService;

/**
 * SurveyServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("surveyService")
public class SurveyServiceImpl extends BaseServiceImpl<Survey> implements SurveyService {
    @Resource(name = "surveyDao")
    private SurveyDao surveyDao;

    @Override
    protected BaseDao<Survey> getBaseDao() {
        return surveyDao;
    }
}
