package org.example.exercicesreactifs.exo13.controller;

import org.example.exercicesreactifs.exo13.entity.Playlist;
import org.example.exercicesreactifs.exo13.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.*;

import java.util.List;


@RestController
@RequestMapping("api/playlist")
public class PlaylistController {

    @Autowired
    private PlaylistService service;

    @GetMapping("verification/{genre}")
    public Flux<Playlist> getPlaylists(@PathVariable("genre") String genre) {
        return service.getByGenre(genre);
    }

    @PostMapping("ajout")
    public Mono<String> ajoutPlayListPop(){
//        Mono<Playlist> vdev = service.createPlayList(new Playlist("rock", List.of("Bohemian Rhapsody", "Hotel California", "Stairway to Heaven")));
        Mono<Playlist> vdev2 = service.createPlayList(new Playlist("pop", List.of("Thriller", "Like a Virgin", "Billie Jean")));
        return Mono.just("ok, c'est fait.");
    }

    @PostMapping("ajout2")
    public Mono<String> ajoutPlayList2Rock(){
        Mono<Playlist> vdev = service.createPlayList(new Playlist("rock", List.of("Bohemian Rhapsody", "Hotel California", "Stairway to Heaven")));
//        Mono<Playlist> vdev2 = service.createPlayList(new Playlist("pop", List.of("Thriller", "Like a Virgin", "Billie Jean")));
        return Mono.just("ok, c'est fait.");
    }

}
