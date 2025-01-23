package org.example.exercices.exo3;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class ErrorHandlingController {

    @GetMapping("/error-resume")
    public Flux<String> errorResume() {
        return Flux.just("A", "B", "C", "D", "E", "F")
                .map(value -> {
                    if (value.equals("C")) {
                        throw new RuntimeException("Erreur Simuler");
                    }
                    return value;
                })
                .onErrorResume(e -> Flux.just("Defaut 1", "Defaut 2"));
    }

    @GetMapping("/error-continue")
    public Flux<Integer> errorContinue() {
        return Flux.range(1, 5)
                .map(n -> {
                    if (n == 2) {
                        throw new RuntimeException("Erreur Simuler");
                    }
                    return n;
                })
                .onErrorContinue((e,value) -> {
                    System.err.println("Erreur : "+value+ " "+e.getMessage());
                });
    }
}
