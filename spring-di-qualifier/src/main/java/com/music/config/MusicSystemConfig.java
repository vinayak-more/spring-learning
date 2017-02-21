package com.music.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.music.MusicSystem;

@Configuration
@ComponentScan(basePackageClasses={MusicSystem.class})
public class MusicSystemConfig {

}
