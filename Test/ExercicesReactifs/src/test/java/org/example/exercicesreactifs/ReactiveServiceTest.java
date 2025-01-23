package org.example.exercicesreactifs;

import org.example.exercicesreactifs.exo13.entity.Playlist;
import org.example.exercicesreactifs.exo13.service.PlaylistService;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.List;

public class ReactiveServiceTest {

    private final PlaylistService playlistService = new PlaylistService();

    @Test
    void testCreatePlaylist() {
        Playlist play = new Playlist("rock", List.of("rock", "rock", "rock"));
        StepVerifier.create(playlistService.createPlayList(play)).expectNext(play).verifyComplete();
    }

    @Test
    void testGetRockPlaylist() {
        Playlist play = new Playlist("rock", List.of("rock", "rock", "rock"));
        playlistService.createPlayList(play);
        StepVerifier.create(playlistService.getByGenre("rock")).expectNextCount(1).verifyComplete();
    }
}
