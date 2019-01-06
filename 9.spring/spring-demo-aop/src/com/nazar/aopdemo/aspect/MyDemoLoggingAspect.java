package com.nazar.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	// this is where we add all of our related advices for loggin

	// let's start a @Before advice

	// @Before("execution(public void
	// com.nazar.aopdemo.dao.AccountDAO.addAccount())")
	// @Before("execution(public void add*())")
	// @Before("execution(* add*())") // Match any return type, and any method that
	// starts with 'add'
	// @Before("execution(* add*(com.nazar.aopdemo.Account, ..))")
	@Before("execution(* com.nazar.aopdemo.dao.*.*(..))") // match package and any class. any method. any params
	public void beforeAddAccountAdvice() {
		System.out.println("=========>>> Executing @Before advice on addAccount");
	}
}
