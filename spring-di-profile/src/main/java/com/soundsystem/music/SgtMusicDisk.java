/**
 * @author Vinayak More
 *
 * @date 15-Feb-2017
 */
package com.soundsystem.music;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class SgtMusicDisk implements CompactDist {

    private String title = "Sgt. Pepper's Lonely Hearts club Band";
    private String artist = "The Beatles";

    public String play() {
		return "Playing Song +" + title + " by " + artist;
    }

}
