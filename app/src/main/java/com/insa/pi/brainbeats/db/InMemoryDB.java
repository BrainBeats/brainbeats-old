package com.insa.pi.brainbeats.db;

import com.insa.pi.brainbeats.domain.Song;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InMemoryDB implements Serializable{
    private List<Song> songs;

    public InMemoryDB() {
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public List getSongs() {
        return songs;
    }
}
