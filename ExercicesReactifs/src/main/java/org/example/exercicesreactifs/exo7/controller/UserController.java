package org.example.exercicesreactifs.exo7.controller;

import org.example.exercicesreactifs.exo7.entity.User;
import org.example.exercicesreactifs.exo7.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.*;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public Mono<User> getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }

    @GetMapping
    public Flux<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public Mono<User> createUser(@RequestBody User user) {
        System.out.println(user);
        return userService.createUser(user);
    }

    @PutMapping("{id}")
    public String updateUser(@PathVariable("id") int id, @RequestBody User user) {
        Mono<Boolean> bloup = userService.putUser(id, user);
        bloup.map(booleanValue -> {
            System.out.println("La valeur du Boolean est : " + booleanValue);
            return booleanValue;
        }).subscribe();
        return "Modification effectuée.";
    }

    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable("id") int id) {

        Mono<Boolean> bloup = userService.deleteUser(id);
        bloup.map(booleanValue -> {
            System.out.println("La valeur du Boolean est : " + booleanValue);
            return booleanValue;
        }).subscribe();
        return "Suppression effectuée.";
    }
}
