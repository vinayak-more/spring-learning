package com.example.test;

import static org.junit.Assert.*;
import org.junit.Test;

import com.example.audio.AudioFile;
import com.example.audio.MP3File;
import com.example.player.DigitalPlayer;
import com.example.player.MP3Player;

public class DigitalPlayerTestClass {
	
	AudioFile file;
	DigitalPlayer player;
	
	@Test
	public void testPlayer(){
		file=new MP3File();
		player=new MP3Player(file);
		assertEquals("This is a mp3 Audio File", player.play());
	}

}
