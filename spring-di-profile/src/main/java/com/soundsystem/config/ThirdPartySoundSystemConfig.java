package com.soundsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.audio.AudioFile;
import com.example.audio.MP3File;
import com.example.player.DigitalPlayer;
import com.example.player.MP3Player;

@Configuration
public class ThirdPartySoundSystemConfig {
	
	@Bean
	public AudioFile initAudioFile(){
		return new MP3File();
	}
	
	@Bean
	public DigitalPlayer initDigitalPlayer(AudioFile file){
		return new MP3Player(file);
	}

}
