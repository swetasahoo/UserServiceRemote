package com.stackroute.activitystream.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserLogger {

	private long start;
	private Object proceed;

	private long executionTime;

	@Before("execution( * com.stackroute.activitystream.restcontroller.*.*(..))")
	public void logStartTime() throws Throwable {
		start = System.currentTimeMillis();
		// proceed = joinPoint.proceed();
		System.out.println("Start time:" + start);
	}

	@After("execution( * com.stackroute.activitystream.restcontroller.*.*(..))")
	public Object logEndTime() throws Throwable {
		executionTime = System.currentTimeMillis() - start;
		System.out.println(" executed in " + executionTime + "ms");
		return proceed;

	}

}
