package com.concert.performer;

import org.springframework.stereotype.Component;

@Component
public class Performer {
	private String performance="Performer is Performing";

	public String perform() throws Exception{
		System.out.println(performance);
		return performance;
	}
}
