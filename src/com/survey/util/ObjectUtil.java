/*
 * @(#)ObjectUtil.java 2013-2-6 обнГ02:31:57 bishe
 */
package com.survey.util;

/**
 * ObjectUtil
 * @author wang
 * @version 1.0
 *
 */
public class ObjectUtil {
    public static boolean equals(Object o1, Object o2) {
        if (o1 == o2) {
            return true;
        }
        if (o1 == null && o2 == null) {
            return true;
        }
        if (o1 != null) {
            return o1.equals(o2);
        }
        return o2.equals(o1);
    }
}
