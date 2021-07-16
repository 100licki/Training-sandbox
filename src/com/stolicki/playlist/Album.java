package com.stolicki.playlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public static void main(String[] args) {
        ArrayList<Album> albums = new ArrayList<Album>();
        Album album = new Album("nazwa1", "artysta1");
        album.addSong("tytul1", 1.30);
        album.addSong("tytul2", 2.30);
        album.addSong("tytul3", 3.30);
        album.addSong("tytul4", 4.30);

        LinkedList<Song> playlist = new LinkedList<Song>();
        albums.get(0).addToPlayList("tytul1", playlist);


    }

    private Song findSong(String songTitle) {
        if (!songs.isEmpty()) {
            for (int i = 0; i <= this.songs.size() - 1; i++) {
                if (songs.get(i).getTitle().equals(songTitle)) {
                    return songs.get(i);
                }
            }
        }
        return null;
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(int trackNumberInAlbum, LinkedList<Song> playlist) {
        if (trackNumberInAlbum > 0) {
            if (findSong(songs.get(trackNumberInAlbum - 1).getTitle()) != null) {
                playlist.add(findSong(songs.get(trackNumberInAlbum - 1).getTitle()));
                return true;
            }
        }
        return false;
    }

    public boolean addToPlayList(String songTitle, LinkedList<Song> playlist) {
        if (findSong(songTitle) != null) {
            playlist.add(findSong(songTitle));
            return true;
        }
        return false;
    }
}
