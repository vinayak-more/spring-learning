package com.soundsystem.music;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class JustinMusicDisk implements CompactDist {

	private String title = "Sorry";
	private String artist = "Justin Bieber";

	@Override
	public String play() {
		return title + " by " + artist;
	}

}
