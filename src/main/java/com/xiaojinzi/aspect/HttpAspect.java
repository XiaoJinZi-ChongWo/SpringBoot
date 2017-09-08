package com.xiaojinzi.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * AOP拦截
 * Created by JQ on 2017/9/6.
 */
@Aspect
@Component
public class HttpAspect {

    //logback 日志
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.xiaojinzi.controller.GirlController.*(..))")
    public void log(){
    }

    //before表示在所有的请求之前拦截
    //其中（..）表示其中的参数
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        //获取请求参数内容
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
            //        System.out.println(11111);
        logger.info("111111");
        //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class={}",joinPoint.getSignature().getDeclaringTypeName()+","+joinPoint.getSignature().getName());
        //参数
        logger.info("Args={}",joinPoint.getArgs());
    }

    //after是在所有的请求之后拦截
    @After("log()")
     public void doAfter(){
        logger.info("222222");
//        System.out.println(222222);
     }

    /**
     * url返回内容
     * @param object
     */
    @AfterReturning(returning = "object",pointcut = "log()")
    public void afterReturning(Object object){
        //返回对象
        logger.info("response={}",object.toString());
    }
}
