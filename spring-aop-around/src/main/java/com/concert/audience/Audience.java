package com.concert.audience;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {

	@Pointcut("execution(** com.concert.performer.Performer.perform(..))")
	public void performance() {
	}

	@Around("performance()")
	public Object watchperFormance(ProceedingJoinPoint jp) {
		try {
			System.out.println("Silencing cell phones");
			System.out.println("Taking seat");
			Object result = jp.proceed();
			System.out.println("CLAP CLAP CLAP!!!");
			return result;
		} catch (Exception e) {
			System.out.println("Demanding a refund");
		} catch (Throwable e) {
			System.out.println("Demanding a refund");
		}
		return "";
	}
}
