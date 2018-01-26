package com.abc.template;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class EmailTemplateAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.abc.template.*.*(..))")
    public void callBefore(JoinPoint joinPoint) {
        logger.info("Method Invoked: " + joinPoint.getSignature().getName());
        logger.info("Value Passed: " + joinPoint.getArgs()[0]);
    }

}
