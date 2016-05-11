package com.insa.pi.brainbeats.domain;

public class Song {
    public String id;
    public String displayName;
    /*
    * Location of the song in the mobile.
    * */
    public String location;

    public Song(String id, String displayName, String location) {
        this.id = id;
        this.displayName = displayName;
        this.location = location;
    }
}
