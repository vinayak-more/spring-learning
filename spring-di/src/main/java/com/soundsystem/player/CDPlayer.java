package com.soundsystem.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soundsystem.music.CompactDist;

@Component
public class CDPlayer implements MediaPlayer {

	private CompactDist cd;

	@Autowired
	public CDPlayer(CompactDist disc) {
		this.cd = disc;
	}

	@Override
	public String play() {
		return cd.play();
	}

}
