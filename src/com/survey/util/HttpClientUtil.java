/*
 * @(#)HttpClientUtil.java 2013-10-22 ÏÂÎç10:17:26 Logistics
 */
package com.survey.util;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;

/**
 * HttpClientUtil
 * @author wang
 * @version 1.0
 *
 */
public class HttpClientUtil {

    private static HttpClient client = new HttpClient();

    static {
        client.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
    }

    private static String getResponseBodyAsString(GetMethod method) {
        try {
            client.executeMethod(method);
            return IOUtils.toString(method.getResponseBodyAsStream(), "utf-8");
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getResponseBodyAsString(URI uri) {
        GetMethod method = new GetMethod();
        try {
            method.setURI(uri);
        } catch (URIException e) {
            e.printStackTrace();
        }
        return getResponseBodyAsString(method);
    }

    public static String getResponseBodyAsString(String url) {
        GetMethod method = new GetMethod(url);
        try {
            method.setURI(new URI(url, false, "gbk"));
        } catch (URIException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return getResponseBodyAsString(method);
    }
}
