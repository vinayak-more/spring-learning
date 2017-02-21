/**
 * @author Vinayak More
 *
 * @date 15-Feb-2017
 */
package com.soundsystem.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.audio.AudioFile;
import com.example.player.DigitalPlayer;
import com.soundsystem.config.CDPlayerConfig;
import com.soundsystem.config.ThirdPartySoundSystemConfig;
import com.soundsystem.music.CompactDist;
import com.soundsystem.player.MediaPlayer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { CDPlayerConfig.class,ThirdPartySoundSystemConfig.class })
@ActiveProfiles("prod")
public class CDPlayerTest {

	@Autowired
	private CompactDist cd;

	@Autowired
	private MediaPlayer player;
	
	@Autowired
	private DigitalPlayer digitalPlayer;
	
	@Autowired
	private AudioFile audioFile;

	@Test
	public void cdShouldNotBeNull() {
		assertNotNull(cd);
	}

	@Test
	public void play() {
		String played = player.play();
		assertEquals(
				"Playing Song +Sgt. Pepper's Lonely Hearts club Band by The Beatles",
				played.trim());
	}
	
	@Test
	public void audioFileShouldNotBeNull(){
		assertNotNull(audioFile);
	}
	
	@Test
	public void thirdPartyClassesTest(){
		String played = digitalPlayer.play();
		assertEquals(
				"This is a mp3 Audio File",
				played.trim());
	}
}
