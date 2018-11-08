package com.gg.aop;


import com.gg.utils.ResponseUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Aspect
@Component
public class AopDemo{
    private static Logger logger= LoggerFactory.getLogger(AopDemo.class);
    //监控各包下以“Controller”命名结尾的public类
    @Pointcut("execution(public * com.gg.*.*Controller.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("#####################请求开始####################");
        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String name = (String) enu.nextElement();
            logger.info("name:{" + name + "},value:{" + request.getParameter(name) + "}");
        }

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(ResponseUtil ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("RESPONSE : " + ret.toString());
        logger.info("#####################请求结束####################");
    }
    //后置异常通知
    @AfterThrowing("webLog()")
    public void afterThrowing(JoinPoint jp){

        System.out.println("@AfterThrowing异常时执行.....");
    }

    //相当于finally块
    @After("webLog()")
    public void doAfter(JoinPoint jp){
        System.out.println("@After方法执行.....");
    }

}
