package com.google;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class VideoPlayer {

  private final VideoLibrary videoLibrary;
  private List<VideoPlaylist> playlistCollection = new ArrayList<VideoPlaylist>();
  private String currentlyPlaying = "";
  private Boolean currentlyPaused = false;

  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
  }

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }
  
  //Method prints all available videos to the cmd.
  public void showAllVideos() {
    System.out.println("Here's a list of all available videos:");
    List<Video> idList = videoLibrary.getVideos();
    ArrayList<String> organizer = new ArrayList<String>();
    for(int i = 0; i < idList.size(); i++) {
    	Video temp = idList.get(i);
    	String tempString = createVideoString(temp);
    	organizer.add(tempString);
    }
    Collections.sort(organizer);
    for(int i = 0; i < organizer.size(); i++) {
    	System.out.println(organizer.get(i));
    }
  }
  
  //Method plays a specified video.
  public void playVideo(String videoId) {
	try {
		String videoToPlay = videoLibrary.getVideo(videoId).getTitle();
		if(currentlyPlaying.equals("")) {
			System.out.println("Playing video: " + videoToPlay);
			currentlyPlaying = videoToPlay;
		} else {
			stopVideo();
			System.out.println("Playing video: " + videoToPlay);
		}
	} catch(NullPointerException e) {
		System.out.println("Cannot play video: Video does not exist");
	}
  }
  
  //Method stops any currently playing video.
  public void stopVideo() {
	  if(currentlyPlaying.equals("")) {
		  System.out.println("Cannot stop video: No video is currently playing");
	  } else {
		  System.out.println("Stopping video: " + currentlyPlaying);
		  currentlyPlaying = "";
		  currentlyPaused = false;
	  }
  }

  public void playRandomVideo() {
	  if(!currentlyPlaying.equals("")) {
		  stopVideo();
	  }
	  List<Video> idList = videoLibrary.getVideos();
	  if(idList.size() > 0) {
		  int rnd = new Random().nextInt(idList.size());
		  playVideo(idList.get(rnd).getVideoId());
	  } else {
		  System.out.println("No videos available");
	  }
  }

  public void pauseVideo() {
	  if(currentlyPlaying.equals("")) {
		  System.out.println("Cannot pause video: No video is currently playing");
	  } 
	  if(!currentlyPlaying.equals("") & currentlyPaused.equals(true)) {
		  System.out.println("Video already paused: " + currentlyPlaying);
	  } 
	  if(!currentlyPlaying.equals("") & currentlyPaused.equals(false)) {
		  System.out.println("Pausing video: " + currentlyPlaying);
		  currentlyPaused = true;
	  }
  }

  public void continueVideo() {
	  if(currentlyPlaying.equals("")) {
		  System.out.println("Cannot continue video: No video is currently playing");
	  }
	  if(!currentlyPlaying.equals("") & currentlyPaused.equals(false)) {
		  System.out.println("Cannot continue video: Video is not paused");
	  } 
	  if(!currentlyPlaying.equals("") & currentlyPaused.equals(true)) {
		  System.out.println("Continuing video: " + currentlyPlaying);
		  currentlyPaused = false;
	  } 
  }

  public void showPlaying() {
	  if(currentlyPlaying.equals("")) {
		  System.out.println("No video is currently playing");
	  } else {
		 List<Video> searchList = videoLibrary.getVideos();
		 for(int i = 0; i < searchList.size(); i++) {
			 if(searchList.get(i).getTitle().equals(currentlyPlaying)) {
				 Video temp = searchList.get(i);
				 String tempString = createVideoString(temp);
				 if(currentlyPaused.equals(true)) {
					 tempString = tempString + " - PAUSED";
				 }
			     System.out.println("Currently playing: " + tempString);
			     break;
			 }
		 }
	  }
  }

  public void createPlaylist(String playlistName) {
	  boolean contains = false;
	  for(int i = 0; i < playlistCollection.size(); i++) {
		  if(playlistCollection.get(i).getName().toLowerCase().equals(playlistName.toLowerCase())) {
			  contains = true;
			  System.out.println("Cannot create playlist: A playlist with the same name already exists");
			  break;
		  }
	  }
	  if(contains == false) {
		  VideoPlaylist newPlaylist = new VideoPlaylist();
		  newPlaylist.setName(playlistName);
		  playlistCollection.add(newPlaylist);
		  System.out.println("Successfully created new playlist: " + playlistName);
	  }
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
	  System.out.println("addVideoToPlaylist needs implementation");
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
  
  public String createVideoString(Video temp) {
	  String tempString = temp.getTitle() + " (" + temp.getVideoId() + ") [";
	  for(int a = 0; a < temp.getTags().size(); a++) {
	      tempString = tempString + temp.getTags().get(a) + " ";
	  }
	  if(tempString.charAt(tempString.length() - 1) != '[') {
	      tempString = tempString.substring(0,tempString.length()-1) + "]";
	  } else {
	      tempString = tempString + "]";
	  }
	  return tempString;
  }
}