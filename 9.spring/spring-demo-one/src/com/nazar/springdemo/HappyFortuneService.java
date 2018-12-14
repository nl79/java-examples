package com.nazar.springdemo;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "totay is your lucky day!";
	}

}
