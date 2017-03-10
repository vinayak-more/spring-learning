package com.soundsystem.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.soundsystem.config.JavaConfig;
import com.soundsystem.counter.TrackCounter;
import com.soundsystem.player.CDPlayer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JavaConfig.class })
public class TrackCounterTest {

	@Autowired
	private CDPlayer player;

	@Autowired
	private TrackCounter counter;

	@Test
	public void shouldNotBeNull() {
		assertNotNull(player);
	}

	@Test
	public void play() {
		player.playTrack(1);
		player.playTrack(2);
		player.playTrack(3);
		player.playTrack(3);
		player.playTrack(3);
		player.playTrack(7);
		player.playTrack(7);
		assertEquals(1, counter.getCount(1));
		assertEquals(1, counter.getCount(2));
		assertEquals(3, counter.getCount(3));
		assertEquals(2, counter.getCount(7));
	}
}
