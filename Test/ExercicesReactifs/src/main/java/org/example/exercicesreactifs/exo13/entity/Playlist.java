package org.example.exercicesreactifs.exo13.entity;

import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.*;

import java.util.*;

@Table("playlist")
public class Playlist {
    @Id
    private int id;
    List<String> musiques;
    String genre;
    private static int count = 0;


    public Playlist() {
        this.id = count++;
        this.musiques = new ArrayList<>();

    }

    public Playlist(String genre, List<String> musiques) {
        this.id = count++;
        this.genre = genre;
        this.musiques = musiques;
    }

    public List<String> getMusiques() {
        return musiques;
    }

    public void setMusiques(List<String> musiques) {
        this.musiques = musiques;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
