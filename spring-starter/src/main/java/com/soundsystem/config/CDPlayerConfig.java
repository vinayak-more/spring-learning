/**
 * @author Vinayak More
 *
 * @date 15-Feb-2017
 */
package com.soundsystem.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.soundsystem.SoundSystem;

@Configuration
@ComponentScan(basePackageClasses={SoundSystem.class})
public class CDPlayerConfig {

}
