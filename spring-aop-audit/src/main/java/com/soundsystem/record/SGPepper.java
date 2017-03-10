package com.soundsystem.record;

import java.util.ArrayList;
import java.util.List;

public class SGPepper implements CompactDisk {
	private String title;
	private String artist;
	private List<String> tracks = new ArrayList<String>();

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String getArtist() {
		return artist;
	}

	@Override
	public void setArtist(String artist) {
		this.artist = artist;
	}

	@Override
	public List<String> getTracks() {
		return tracks;
	}

	@Override
	public void setTracks(List<String> tracks) {
		this.tracks = tracks;
	}

}
