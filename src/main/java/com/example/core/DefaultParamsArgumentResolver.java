package com.example.core;

import com.example.common.file.DefaultParams;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Created by whydd on 2017-03-03.
 */
public class DefaultParamsArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return DefaultParams.class.isAssignableFrom(methodParameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        if(methodParameter.getParameterType().equals(DefaultParams.class)) {
            DefaultParams defaultParams = new DefaultParams();
            defaultParams.setMap(new LinkedHashMap());
            Iterator iterator = nativeWebRequest.getParameterNames();
            while(iterator.hasNext()) {
                String key = (String)iterator.next();
                String value = nativeWebRequest.getParameter(key);
                defaultParams.getMap().put(key, value);
            }

            if(nativeWebRequest.getNativeRequest() instanceof MultipartHttpServletRequest){
                MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)nativeWebRequest.getNativeRequest();
                defaultParams.getMap().put("multipartHttpServletRequest", multipartHttpServletRequest);
            }

            //계속 세팅되어야할 파라미터를 입력한다.
            defaultParams.getMap().put("init1", "a");
            defaultParams.getMap().put("init2", "b");
            defaultParams.getMap().put("init3", "c");
            return defaultParams;
        }
        return null;
    }
}
