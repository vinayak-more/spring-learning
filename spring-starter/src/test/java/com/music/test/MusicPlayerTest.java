package com.music.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.music.config.MusicSystemConfig;
import com.music.genre.Song;
import com.music.player.MusicPlayer;
import com.music.qualifiers.JazzMusic;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MusicSystemConfig.class })
@ActiveProfiles("prod")
public class MusicPlayerTest {

	@Autowired
	@JazzMusic
	Song song;
	
	
	@Autowired
	MusicPlayer player;

	@Test
	public void shouldNotBeNull() {
		assertNotNull(song);
		assertNotNull(player);
	}
	
	@Test
	public void play(){
		System.out.println(player.play(song));
		assertEquals("This is Max Roach Jazz Band", player.play(song));
	}
	
}
