package com.example.player;

import com.example.audio.AudioFile;

public class MP3Player implements DigitalPlayer {

	private AudioFile mp3;

	public MP3Player(AudioFile mp3) {
		this.mp3 = mp3;

	}

	public String play() {
		return mp3.play();
	}

}
