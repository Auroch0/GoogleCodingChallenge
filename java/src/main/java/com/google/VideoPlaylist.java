package com.google;

import java.util.ArrayList;
import java.util.List;

/** A class used to represent a Playlist */
class VideoPlaylist {
	private String name = "";
	private List<Video> playlist = new ArrayList<Video>();
	
	public void setName(String newName) {
		name = newName;
	}
	
	public String getName() {
		return name;
	}
	
	public void addToPlaylist(Video toAdd) {
		playlist.add(toAdd);
	}
}
