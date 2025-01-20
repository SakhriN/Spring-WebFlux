package org.example.exercices.exo3;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("api")
public class Exo3Controller {

    @GetMapping("error-resume")
    public Flux<String> getErrorResume() {
        Flux<String> lettres = Flux.just("A", "B", "C", "D", "E")
                .map(str -> {
                    if ("D".equals(str)) {
                        throw new RuntimeException("La volonté du D...");
                    }
                    return str;
                })
                .onErrorResume(e -> Flux.just("Default 1", "Default 2"));

        lettres.subscribe(System.out::println, error -> System.err.println("Erreur récupérée : " + error));

        Flux<String> error = Flux.just("Default1 : ");
        Flux<String> error2 = Flux.just("Default2 : ");
        return Flux.concat(error, error2);
    }

    @GetMapping("error-continue")
    public Flux<Integer> getErrorContinue() {
        Flux<Integer> numbers = Flux.range(1, 5).map(inte -> {
                    if (inte==2) {
                        throw new RuntimeException("2 est pas bien pour toi");
                    }
                    return inte;
                })
                .onErrorContinue((e, test) -> {
                            System.out.println("Erreur " + test + ", bloup " + e.getMessage());
                        }
                );
        return numbers;
    }
}
