package com.example.test_ip.util.log;

import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Component
@Aspect
public class LogAspect {
    private static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /*
     * @Description: controller before
     * @Date: 2019/6/12 0:43
     * @Param: [joinPoint]
     * @Return: void
     **/
    @Before("within(com.example.test_ip.controller.*)")
    public void before(JoinPoint joinPoint) {
        try {
            RequestAttributes requestAttribute = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)requestAttribute;
            HttpServletRequest request = servletRequestAttributes.getRequest();
            String URL = request.getRequestURL().toString();
            Object args[] = joinPoint.getArgs();
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            Method method = methodSignature.getMethod();
            logger.info("URL: {}", URL);
            logger.info("{}.{}  param: [{}]", method.getDeclaringClass().getName(), method.getName(), StringUtils.join(args, " : "));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * @Description: controller after
     * @Date: 2019/6/12 0:44
     * @Param: [joinPoint, object]
     * @Return: void
     **/
    @AfterReturning(value = "within(com.example.test_ip.controller.*)", returning = "object")
    public void after(JoinPoint joinPoint, Object object) {
        try {
            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            Method method = methodSignature.getMethod();
            logger.info("{}.{}", method.getDeclaringClass().getName(), method.getName());
            logger.info("{}", new Gson().toJson(object));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
