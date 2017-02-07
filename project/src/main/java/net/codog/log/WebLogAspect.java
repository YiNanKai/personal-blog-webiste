package net.codog.log;

import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@Order(-5)
public class WebLogAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	ThreadLocal<Long> startTime = new ThreadLocal<Long>();
	
	@Pointcut("execution(public * net.codog.web..*.*(..))")
	public void webLog() {
	}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) {
		startTime.set(System.currentTimeMillis());
		logger.info("doBefore()");
		logger.error("test");
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		logger.info("URL : " + request.getRequestURL().toString());
		logger.info("HTTP_METHOD : " + request.getMethod());
		logger.info("IP : " + request.getRemoteAddr());
		logger.info("CLASS_METHOD : "
				+ joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName());
		logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
		Enumeration<String> enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String paraName = (String) enu.nextElement();
			logger.info(paraName + ": " + request.getParameter(paraName));
		}
	}
	
	@AfterReturning("webLog()")
    public void  doAfterReturning(JoinPoint joinPoint){
       // 处理完请求，返回内容
        logger.info("WebLogAspect.doAfterReturning()");
        logger.info("耗时（毫秒） : " + (System.currentTimeMillis() - startTime.get()));
     }
	
}
