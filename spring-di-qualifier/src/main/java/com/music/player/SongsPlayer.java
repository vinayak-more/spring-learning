package com.music.player;

import org.springframework.stereotype.Component;

import com.music.genre.Song;

@Component
public class SongsPlayer implements MusicPlayer {

	@Override
	public String play(Song song) {
		return song.play();
	}

	
}
