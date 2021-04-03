package com.pan.aspect;


import com.alibaba.fastjson.JSON;
import com.pan.utils.GlobalUtils;
import com.pan.vo.ResultEntity;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import static com.pan.constants.GlobalConstants.TOKEN_HEADER;

/**
 * AOP处理
 *
 * @author weiQiang
 */
@Slf4j
@Aspect
@Component
public class CommonAspect {

    /**
     * 开始时间,用于记录请求耗时
     */
    private static ThreadLocal<Long> BEGIN_TIME = new ThreadLocal<>();
    /**
     * 请求Url
     */
    private static ThreadLocal<String> REQUEST_URL = new ThreadLocal<>();
    /**
     * 请求IP
     */
    public static ThreadLocal<String> REQUEST_IP = new ThreadLocal<>();
    /**
     * authorization
     */
    public static ThreadLocal<String> AUTHORIZATION_INFO = new ThreadLocal<>();
    /**
     * authorization
     */
    public static ThreadLocal<Integer> REQUEST_PORT = new ThreadLocal<>();


    /**
     * 请求之后拦截
     */
    @After("doController()")
    public void doAfter() {

    }

    /**
     * 返回时拦截
     *
     * @param object
     */
    @AfterReturning(returning = "object", pointcut = "doController()")
    public void doAfterReturning(Object object) {
        long requestTime = System.currentTimeMillis() - BEGIN_TIME.get();
        try {
            if (null != object) {
                if (object instanceof ResultEntity) {
                    ((ResultEntity) object).setTotalTime(requestTime);
                    if (null != ((ResultEntity) object).getData() && (((ResultEntity) object).getData() instanceof ArrayList) && !((ResultEntity) object).isPageable()) {
                        ((ResultEntity) object).setTotal((long) ((ResultEntity) object).getData().size());
                    }
                    List<?> resultData = ((ResultEntity) object).getData();
                    if (null != resultData && resultData.size() > 0) {
                        //空值字段不返回
                        ((ResultEntity) object).setData(JSON.parseArray(JSON.toJSONString(resultData)));
                    }
                }
                log.debug("response:{}", object);
            } else {
                log.debug("response:{}", "无返回值");
            }
            log.info("请求ip:{},请求:{},耗时:{}ms", REQUEST_IP.get(), REQUEST_URL.get(), requestTime);
        } catch (Exception e) {
            log.error("请求结果转换发生错误:{}", e.getMessage());
        } finally {
            BEGIN_TIME.remove();
            REQUEST_URL.remove();
            REQUEST_IP.remove();
            AUTHORIZATION_INFO.remove();
            REQUEST_PORT.remove();
        }

    }

    /**
     * 请求之前拦截
     *
     * @param joinPoint
     */
    @Before("doController()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();
        StringBuffer requestURL = request.getRequestURL();
        BEGIN_TIME.set(System.currentTimeMillis());
        REQUEST_URL.set(requestURL.toString());
        REQUEST_IP.set(GlobalUtils.getIpAddress(request));
        log.debug("url:{},方法:{},请求ip:{},类和方法:{}(),参数:{}", requestURL, request.getMethod(), REQUEST_IP.get(), joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName(), joinPoint.getArgs());
        log.debug("浏览器名称:{},浏览器版本号:{},系统名称:{}", GlobalUtils.getBrowserName(request), GlobalUtils.getBrowserVersion(request), GlobalUtils.getOsName(request));
        response.setHeader("Access-Control-Expose-Headers", TOKEN_HEADER);
        response.setHeader("Content-Type", " application/json;charset=UTF-8");
    }

    /**
     * 切点
     */
    @Pointcut(value = "execution(* com.pan.controller.*.*(..))")
    public void doController() {
    }
}
