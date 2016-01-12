/*
 * @(#)SurveyDaoImpl.java 2014-1-10 ионГ09:57:10
 * Survey
 */
package com.survey.dao.impl;

import org.springframework.stereotype.Component;

import com.survey.dao.SurveyDao;
import com.survey.model.Survey;

/**
 * SurveyDaoImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("surveyDao")
public class SurveyDaoImpl extends BaseDaoImpl<Survey> implements SurveyDao {

}
