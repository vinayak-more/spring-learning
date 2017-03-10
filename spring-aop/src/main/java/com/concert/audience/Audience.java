package com.concert.audience;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {
	
	@Pointcut("execution(** com.concert.performer.Performer.perform(..))")
	public void performance(){}
	
	@Before("performance()")
	public void silnceCellPhone(){
		System.out.println("Silencing cell phones");
	}
	@Before("performance()")
	public void taleSeat(){
		System.out.println("Taking seat");
	}
	
	@AfterReturning("performance()")
	public void applause(){
		System.out.println("CLAP CLAP CLAP!!!");
	}
	
	@AfterThrowing("performance()")
	public void demandRefund(){
		System.out.println("Demanding a refund");
	}

}
