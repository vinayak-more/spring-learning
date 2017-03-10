package com.soundsystem.record;

import java.util.List;

public interface CompactDisk {

	public abstract String getTitle();

	public abstract void setTitle(String title);

	public abstract String getArtist();

	public abstract void setArtist(String artist);

	public abstract List<String> getTracks();

	public abstract void setTracks(List<String> tracks);

}