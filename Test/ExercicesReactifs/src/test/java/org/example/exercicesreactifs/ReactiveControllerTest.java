package org.example.exercicesreactifs;

import org.example.exercicesreactifs.exo13.controller.PlaylistController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest(PlaylistController.class)
public class ReactiveControllerTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    void testCreatePlaylist(){
        webClient.get().uri("/api/playlist/ajout")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("ok, c'est fait.");
    }

    @Test
    void testGetPlaylist(){
        webClient.get().uri("/api/playlist/verification/rock")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class).contains("Bohemian Rhapsody", "Hotel California", "Stairway to Heaven");
    }



}
