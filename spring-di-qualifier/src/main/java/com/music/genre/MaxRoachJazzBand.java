package com.music.genre;

import org.springframework.stereotype.Component;

import com.music.qualifiers.JazzMusic;

@Component
@JazzMusic
public class MaxRoachJazzBand implements Song {

	private String song = "This is Max Roach Jazz Band";

	@Override
	public String play() {
		return song;
	}

}
