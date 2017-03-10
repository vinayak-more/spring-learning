package com.soundsystem.counter;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TrackCounter {
	
	private Map<Integer, Integer> trackCounts =
			new HashMap<Integer, Integer>();

	@Pointcut("execution(** com.soundsystem.player.CDPlayer.playTrack(int)) && args(trackNumber)")
	public void trackPlayed(int trackNumber){}
	
	@Before("trackPlayed(trackNumber)")
	public void countTracked(int trackNumber) {
		if (trackCounts.get(trackNumber) == null) {
			trackCounts.put(trackNumber, 1);
		} else {
			int count = trackCounts.get(trackNumber);
			trackCounts.put(trackNumber, count + 1);
		}
	}
	
	public int getCount(int trackNumber){
		return trackCounts.get(trackNumber);
	}
}
