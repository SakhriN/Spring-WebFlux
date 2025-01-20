package org.example.exercices.exo2;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.*;

@RestController
@RequestMapping("api")
public class Exo2Controller {

    @GetMapping("processed-numbers")
    public Flux<String> getNumbers(){
        Flux<Integer> numbers = Flux.range(1, 10)
                .filter(number -> number % 2 == 0)
                .map(integer -> integer * 10);

        Flux<String> fluxString = numbers.map(integer -> "Processed : " + integer + "\n ");
        fluxString.subscribe(System.out::println);

        return fluxString;

    }
}
