package com.cmos.chopmkactivity.web.config;

import com.cmos.chopmkactivity.web.intercepter.PrivateParamInterceptor;
import com.cmos.common.annotation.EnableFileUpload;
import com.cmos.common.exception.autoconfig.EnableGeneralException;
import com.cmos.common.web.config.DefaultWebMvcConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * Created by zhuzh on 2016/11/18.
 */

@Configuration
@EnableWebMvc
@EnableFileUpload
@ComponentScan(
        basePackages = {
                "com.cmos.chopmkactivity.web",
                "com.cmos.chopmkactivity.web.controller.**"
        },
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
@EnableGeneralException
public class WebConfig extends DefaultWebMvcConfig {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PrivateParamInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/login/**")
                .excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/v2/**")
                .excludePathPatterns("/error/**");
    }


}
