package com.stolicki.jdbc.music;

import com.stolicki.jdbc.music.model.Artist;
import com.stolicki.jdbc.music.model.Datasource;
import com.stolicki.jdbc.music.model.SongArtist;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        if (!datasource.open()) {
            System.out.println("Can't open datasource");
            return;
        }
        List<Artist> artists = datasource.queryArtist(Datasource.ORDER_BY_NONE);
        if (artists == null) {
            System.out.println("No artists.");
            return;
        }
        for (Artist artist : artists) {
            System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());
        }

        List<String> albumsForArtist = datasource.queryAlbumsForArtist("Pink Floyd", Datasource.ORDER_BY_DESC);

        for (String album : albumsForArtist) {
            System.out.println(album);
        }

        List<SongArtist> songArtists = datasource.queryArtistsForSong("Go Your Own Way", Datasource.ORDER_BY_ASC);
        if (songArtists == null) {
            System.out.println("Couldn't find the artist for the song");
            return;
        }
        for (SongArtist songArtist : songArtists) {
            System.out.println(songArtist);
        }

        datasource.querySongsMetadata();

        int count = datasource.getCount(Datasource.TABLE_SONGS);
        System.out.println("Number of songs is: " + count);

        datasource.createViewForSongArtists();

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter a song title: ");
//        String title = scanner.nextLine();
//
//        songArtists = datasource.querySongInfoView(title);
//        if (songArtists.isEmpty()) {
//            System.out.println("Couldn't find the artist for the song");
//            return;
//        }
//        for (SongArtist songArtist : songArtists) {
//            System.out.println("FROM VIEW - Artist name = " + songArtist.getArtistName() +
//                    " Album name = " + songArtist.getAlbumName() +
//                    " Track number = " + songArtist.getTrack());
//        }

        datasource.insertSong("Touch Of Grey", "Grateful Dead", "In The Dark", 1);

        datasource.close();
    }
}