/*
 * @(#)Type.java 2014-1-10 上午11:25:32 Survey
 */
package com.survey.model;

/**
 * Type
 * @author wang
 * @version 1.0
 *
 */
public enum Type {
    ONE, MANY, TEXT;

    public String toString() {
        switch (this) {
            case ONE:
                return "单选题";
            case MANY:
                return "多选题";
            case TEXT:
                return "问答题";
        }
        return null;
    }
}