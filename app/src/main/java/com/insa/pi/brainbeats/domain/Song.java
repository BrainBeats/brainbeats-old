package com.insa.pi.brainbeats.domain;

import java.io.Serializable;

public class Song implements Serializable{
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
