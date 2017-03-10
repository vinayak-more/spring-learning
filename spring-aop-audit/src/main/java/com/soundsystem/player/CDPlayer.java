package com.soundsystem.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soundsystem.record.CompactDisk;

@Component
public class CDPlayer {

	@Autowired
	private CompactDisk disk;

	public String playTrack(int trackNumber) {
		return disk.getTracks().get(trackNumber);
	}
}
