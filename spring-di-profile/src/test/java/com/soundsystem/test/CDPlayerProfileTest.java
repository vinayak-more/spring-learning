package com.soundsystem.test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.soundsystem.config.CDPlayerConfig;
import com.soundsystem.config.ThirdPartySoundSystemConfig;
import com.soundsystem.music.CompactDist;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { CDPlayerConfig.class,ThirdPartySoundSystemConfig.class })
@ActiveProfiles("dev")
public class CDPlayerProfileTest {
	
	@Autowired
	CompactDist disc;
	
	@Test
	public void shouldNotBeNull(){
		assertNotNull(disc);
	}

}
