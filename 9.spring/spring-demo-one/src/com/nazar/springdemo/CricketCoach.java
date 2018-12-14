package com.nazar.springdemo;

public class CricketCoach implements Coach {

	

	private FortuneService fortuneService;
	
	public FortuneService getFortuneService() {
		return fortuneService;
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setFortuneService");

		this.fortuneService = fortuneService;
	}
	
	public CricketCoach() {
		System.out.println("CricketCoach: inside no arg constructo");
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice bast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
