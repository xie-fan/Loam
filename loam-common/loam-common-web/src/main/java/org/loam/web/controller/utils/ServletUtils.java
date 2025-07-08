package org.loam.web.controller.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class ServletUtils {

    public static String getStringParameter(String paramName){
        try {
            return getRequest().getParameter(paramName);
        }catch(Exception e){
            return null;
        }
    }

    public static String getStringParameter(String paramName, String defaultValue){
        try {
            String value = getStringParameter(paramName);
            if(value == null){
                return defaultValue;
            }
            return value;
        }catch(Exception e){
            return defaultValue;
        }
    }

    public static Integer getIntegerParameter(String paramName){
        try {
            String value = getStringParameter(paramName);
            if(value == null){
                return null;
            }
            return Integer.parseInt(value);
        }catch(Exception e){
            return null;
        }
    }

    public static Integer getIntegerParameter(String paramName, Integer defaultValue){
        try {
            String value = getStringParameter(paramName);
            if(value == null){
                return defaultValue;
            }
            return Integer.parseInt(value);
        }catch(Exception e){
            return defaultValue;
        }
    }


    public static HttpServletRequest getRequest() {
        try {
            return getRequestAttributes().getRequest();
        }catch (Exception e) {
            return null;
        }
    }

    public static ServletRequestAttributes getRequestAttributes(){
        try {
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            return (ServletRequestAttributes) requestAttributes;
        }catch (Exception e){
            return null;
        }
    }
}
