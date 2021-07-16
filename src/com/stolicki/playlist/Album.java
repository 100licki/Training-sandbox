package com.stolicki.playlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration) {
        return this.songs.add(new Song(title, duration));
    }

    public boolean addToPlayList(int trackNumberInAlbum, LinkedList<Song> playlist) {
        if (this.songs.findSong(trackNumberInAlbum) != null) {
            playlist.add(this.songs.findSong(trackNumberInAlbum));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(String songTitle, LinkedList<Song> playlist) {
        if (this.songs.findSong(songTitle) != null) {
            playlist.add(this.songs.findSong(songTitle));
            return true;
        }
        return false;
    }

    public static class SongList {
        private ArrayList<Song> songs;

        private SongList() {
            this.songs = new ArrayList<Song>();
        }

        private boolean add(Song song) {
            if (!songs.contains(song)) {
                this.songs.add(song);
                return true;
            }
            return false;
        }

        private Song findSong(String songTitle) {
            for (int i = 0; i <= this.songs.size() - 1; i++) {
                if (this.songs.get(i).getTitle().equals(songTitle)) {
                    return this.songs.get(i);
                }
            }
            return null;
        }

        private Song findSong(int trackNumber) {
            int index = trackNumber - 1;
            if ((index > 0) && (index < songs.size())) {
                return songs.get(index);
            }
            return null;
        }
    }
}
