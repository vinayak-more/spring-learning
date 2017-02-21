package com.music.genre;

import org.springframework.stereotype.Component;

import com.music.qualifiers.RockMusic;

@Component
@RockMusic
public class TheBeatlesRockBand implements Song{
	
	private String song="This is Beatles Rock Band";

	@Override
	public String play() {
		return song;
	}

}
