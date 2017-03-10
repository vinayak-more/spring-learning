package com.soundsystem.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.soundsystem.SoundSystem;
import com.soundsystem.counter.TrackCounter;
import com.soundsystem.record.CompactDisk;
import com.soundsystem.record.SGPepper;

@Configuration
@ComponentScan(basePackageClasses = { SoundSystem.class })
@EnableAspectJAutoProxy
public class JavaConfig {

	@Bean
	public CompactDisk getSgtPepper() {
		CompactDisk cd = new SGPepper();
		cd.setTitle("Sgt. Pepper's Lonely Hearts Club Band");
		cd.setArtist("The Beatles");
		List<String> tracks = new ArrayList<String>();
		tracks.add("Sgt. Pepper's Lonely Hearts Club Band");
		tracks.add("With a Little Help from My Friends");
		tracks.add("Lucy in the Sky with Diamonds");
		tracks.add("Getting Better");
		tracks.add("Fixing a Hole");
		tracks.add("She's leaving home");
		tracks.add("Being for the benefit of mr. kite!");
		tracks.add("Within you without you");
		cd.setTracks(tracks);
		return cd;
	}

	@Bean
	public TrackCounter trackCounter() {
		return new TrackCounter();
	}

}
