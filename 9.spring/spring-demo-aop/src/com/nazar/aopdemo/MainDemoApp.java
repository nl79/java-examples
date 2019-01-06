package com.nazar.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nazar.aopdemo.dao.AccountDAO;
import com.nazar.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// Read spring configuration java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// get membership bean from spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		// call the business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount, true);

		// call the method again
		theAccountDAO.addAccount();
		theAccountDAO.doWork();
		// call the membership business method
		theMembershipDAO.addAccount();
		theMembershipDAO.goToSleep();
		// close the context
		context.close();
	}

}
