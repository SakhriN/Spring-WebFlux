package org.example.exercices.exo1;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.*;

@RestController
@RequestMapping("/api")
public class Exo1Controller {

    @GetMapping("welcome")
  public Mono<String> welcome() {
      return Mono.just("Welcome");
  }

  @GetMapping("numbers")
    public Flux<Integer> numbers() {
        return Flux.just(1, 2, 3, 4, 5);
  }
}
