package org.example.exercicesreactifs.exo13.service;

import org.example.exercicesreactifs.exo13.entity.Playlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaylistService {

    List<Playlist> playlists;
    
    public PlaylistService() {
        playlists = new ArrayList<>();
    }

    public Flux<Playlist> getByGenre(String genre) {
        List<Playlist> playlisto= new ArrayList<>();
        if(!playlists.isEmpty()){
            playlisto = playlists.stream().filter(p -> p.getGenre().equals(genre)).collect(Collectors.toList());
        }
            return Flux.fromIterable(playlisto);
    }

    public Mono<Playlist> createPlayList(Playlist playlist) {
        playlists.add(playlist);
        return Mono.just(playlist);
    }
}
