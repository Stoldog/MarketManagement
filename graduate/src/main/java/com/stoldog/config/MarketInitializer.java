package com.stoldog.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by RL on 2017/4/4.
 */
public class MarketInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
    //配置spring
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }
    //拦截请求
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
