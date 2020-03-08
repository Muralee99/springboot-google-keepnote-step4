package com.stackroute.keepnote.aspect;

/* Annotate this class with @Aspect and @Component */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {
	protected final Logger LOG = LoggerFactory.getLogger(this.getClass());
	/*
	 * Write loggers for each of the methods of controller, any particular method
	 * will have all the four aspectJ annotation
	 * (@Before, @After, @AfterReturning, @AfterThrowing).
	 */
	
	//@Pointcut("execution(* com.doj.app.service.*.*(..))")
	@Before("execution(* com.stackroute.keepnote.controller.CategoryController.createCategory(..))")
	public void logBefore(JoinPoint joinPoint) {
		LOG.info("::::: LOGBEFORE :::::" + joinPoint.getSignature().getName());
	}

	@After("execution(* com.stackroute.keepnote.controller.*.*(..))")
	public void logAfter(JoinPoint joinPoint) {
		LOG.info("::::: LOGAFTER :::::" + joinPoint.getSignature().getName());
	}

	@AfterReturning(pointcut="execution(* com.stackroute.keepnote.controller.*.*(..))", returning="result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		LOG.info("::::: LOGAFTERRETURNING :::::" + joinPoint.getSignature().getName());
	}

	@AfterThrowing(pointcut="execution(* com.stackroute.keepnote.controller.*.*(..))",throwing= "error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
		LOG.info("::::: LOGAFTERTHROWING :::::" + joinPoint.getSignature().getName());
	}
}
