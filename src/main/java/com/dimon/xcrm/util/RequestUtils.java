package com.dimon.xcrm.util;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

/**
 * 获取前台传入数据，转换各种不同的类型值
 * @author dimon
 * @createTime 2015-10-17
 */
public class RequestUtils {
    public static Log log = LogFactory.getLog(RequestUtils.class);

    /**
     * 返回整形,如果不存在则返回0
     * 
     * @param request
     * @param key
     * @return
     */
    public static int getInt(HttpServletRequest request, String key) {

        try {
            String value = request.getParameter(key);
            if (StringUtils.isEmpty(value)) {
                return Integer.valueOf(StringUtils.trimWhitespace(value));
            }
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
        return 0;
    }

    /**
     * 返回整形
     * 
     * @param request
     * @param key
     * @return
     */
    public static int getInt(HttpServletRequest request, String key, int defaultValue) {

        try {
            String value = request.getParameter(key);
            if (StringUtils.isEmpty(value)) {
                return Integer.valueOf(StringUtils.trimWhitespace(value));
            }
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
        return defaultValue;
    }

    /**
     * 返回长整形,如果不存在则返回0
     * 
     * @param request
     * @param key
     * @return
     */
    public static long getLong(HttpServletRequest request, String key) {

        try {
            String value = request.getParameter(key);
            if (StringUtils.isEmpty(value)) {
                return Long.valueOf(StringUtils.trimWhitespace(value));
            }
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }

        return 0;
    }

    /**
     * 返回长整形
     * 
     * @param request
     * @param key
     * @return
     */
    public static long getLong(HttpServletRequest request, String key, Long defaultValue) {

        try {
            String value = request.getParameter(key);
            if (StringUtils.isEmpty(value)) {
                return Long.valueOf(StringUtils.trimWhitespace(value));
            }
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
        return defaultValue;
    }

    /**
     * 返回长整形
     * 
     * @param request
     * @param key
     * @return
     */
    public static long getLong(HttpServletRequest request, String key, int defaultValue) {

        try {
            String value = request.getParameter(key);
            if (StringUtils.isEmpty(value)) {
                return Long.valueOf(StringUtils.trimWhitespace(value));
            }
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
        return defaultValue;
    }

    /**
     * 返回货币类型
     * 
     * @param request
     * @param key
     * @return
     */
    public static BigDecimal getBigDecimal(HttpServletRequest request, String key) {

        try {
            String value = request.getParameter(key);
            if (StringUtils.isEmpty(value)) {
                return new BigDecimal(StringUtils.trimWhitespace(value));
            }
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
        return new BigDecimal(0);
    }

    /**
     * 返回货币类型,如果不存在则返回0
     * 
     * @param request
     * @param key
     * @param defaultValue
     * @return
     */
    public static BigDecimal getBigDecimal(HttpServletRequest request, String key, BigDecimal defaultValue) {

        try {
            String value = request.getParameter(key);
            if (StringUtils.isEmpty(value)) {
                return new BigDecimal(StringUtils.trimWhitespace(value));
            }
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
        return defaultValue;
    }

    /**
     * 返回字符串,删除了首尾空格,如果不存在则返回null
     * 
     * @param request
     * @param key
     * @return
     */
    public static String getString(HttpServletRequest request, String key) {

        String value = request.getParameter(key);
        if (StringUtils.isEmpty(value)) {
            return StringUtils.trimWhitespace(value);
        }

        return value;
    }

    /**
     * 返回字符串,删除了首尾空格
     * 
     * @param request
     * @param key
     * @return
     */
    public static String getString(HttpServletRequest request, String key, String defaultValue) {

        String value = request.getParameter(key);
        if (StringUtils.isEmpty(value)) {
            return StringUtils.trimWhitespace(value);
        }

        return defaultValue;
    }

    /**
     * 返回复选框值,删除了首尾空格,如果不存在则返回null
     * 
     * @param request
     * @param key
     * @return
     */
    public static List<String> getList(HttpServletRequest request, String key) {

        String[] values = request.getParameterValues(key);
        if (values != null) {
            List<String> relist = new ArrayList<String>(values.length);
            for (String value : values) {
                if (StringUtils.isEmpty(value)) {
                    relist.add(StringUtils.trimWhitespace(value));
                }
            }
            return relist;
        }

        return null;
    }

    /**
     * 返回复选框值,删除了首尾空格
     * 
     * @param request
     * @param key
     * @return
     */
    public static List<String> getList(HttpServletRequest request, String key, List<String> defaultValue) {

        String[] values = request.getParameterValues(key);
        if (values != null) {
            List<String> relist = new ArrayList<String>(values.length);
            for (String value : values) {
                if (StringUtils.isEmpty(value)) {
                    relist.add(StringUtils.trimWhitespace(value));
                }
            }
            return relist;
        }

        return defaultValue;
    }

    /**
     * 返回复选框值,删除了首尾空格,如果不存在则返回null
     * 
     * @param request
     * @param key
     * @return
     */
    public static String[] getArray(HttpServletRequest request, String key) {

        String[] values = request.getParameterValues(key);
        if (values != null && values.length > 0) {
            return values;
        }

        return null;
    }

    /**
     * 返回复选框值,删除了首尾空格
     * 
     * @param request
     * @param key
     * @return
     */
    public static String[] getArray(HttpServletRequest request, String key, String[] defaultValue) {

        String[] values = request.getParameterValues(key);
        if (values != null && values.length > 0) {
            return values;
        }

        return defaultValue;
    }

    /**
     * 获取国际化对象类型：zh_CN，en-US
     * 
     * @param request
     * @return
     */
    public static String getLocalStr(HttpServletRequest request) {

        return request.getLocale().getLanguage() + "_" + request.getLocale().getCountry();
    }
    
    
    //获得客户端真实IP地址的方法一：
    public String getRemortIP(HttpServletRequest request) {  
        if (request.getHeader("x-forwarded-for") == null) {  
            return request.getRemoteAddr();  
        }  
        return request.getHeader("x-forwarded-for");  
    }  
 
    /**
     * 获取客户端IP地址二
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
    	String ip = request.getHeader("x-forwarded-for");
    	if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
    		ip = request.getHeader("Proxy-Client-IP");
    	}
    	if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
    		ip = request.getHeader("WL-Proxy-Client-IP");
    	}
    	if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
    		ip = request.getRemoteAddr();
    	}
    		return ip;
    	}
}
