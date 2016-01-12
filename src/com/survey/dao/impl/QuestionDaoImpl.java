/*
 * @(#)QuestionDaoImpl.java 2014-1-10 ионГ09:56:33
 * Survey
 */
package com.survey.dao.impl;

import org.springframework.stereotype.Component;

import com.survey.dao.QuestionDao;
import com.survey.model.Question;

/**
 * QuestionDaoImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("questionDao")
public class QuestionDaoImpl extends BaseDaoImpl<Question> implements QuestionDao {

}
