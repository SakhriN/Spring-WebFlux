package org.example.exercices.exo4;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.*;

@RestController
@RequestMapping("api/articles")
public class Exo4Controller {

    @GetMapping
    public Flux<String> ShowArticles() {
        Flux<String> articles = Flux.just(" Introduction to Spring WebFlux " ,
                " Reactive Programming with Project Reactor ",
                " Building APIs with Spring Boot ");


        return articles;
    }
}
