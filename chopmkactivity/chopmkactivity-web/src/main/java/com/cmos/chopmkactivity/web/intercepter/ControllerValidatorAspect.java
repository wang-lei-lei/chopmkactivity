package com.cmos.chopmkactivity.web.intercepter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * Created by zhuzh on 2016/11/18.
 */
@Aspect
@Component
public class ControllerValidatorAspect {
    @Around("execution(* com.cmos.chopmkactivity.web.controller.*.*(..)) && args(..,bindingResult)")
    public Object doAround(ProceedingJoinPoint pjp, BindingResult bindingResult) throws Throwable {
        Object returnVal = null;
        if (bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                sb.append(fieldError.getDefaultMessage() + ",");
            }
            returnVal = sb.toString();
        } else {
            returnVal = pjp.proceed();
        }
        return returnVal;
    }
}