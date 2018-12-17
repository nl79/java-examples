package com.nazar.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach", Coach.class);

		boolean result = (theCoach == alphaCoach);
		
		System.out.println("\nPoiting to the the same object" + result);
		System.out.println("\n Memoery location of theCoach" + theCoach);
		System.out.println("\n Memoery location of alphaCoach" + alphaCoach);



		// close the context
		context.close();
	}

}
