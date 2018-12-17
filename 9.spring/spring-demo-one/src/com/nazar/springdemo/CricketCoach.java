package com.nazar.springdemo;

public class CricketCoach implements Coach {

	

	private FortuneService fortuneService;
	
	// add new fields for emailAddress and team
	private String emailAddress;
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside setEmailAddress");

		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	private String team;
	
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
