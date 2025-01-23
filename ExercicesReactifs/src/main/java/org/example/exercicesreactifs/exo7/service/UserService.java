package org.example.exercicesreactifs.exo7.service;

import org.example.exercicesreactifs.exo7.entity.User;
import org.example.exercicesreactifs.exo7.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public Mono<User> getUser(@PathVariable("id") int id) {
        return userRepository.findById(id);
    }

    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }


    public Mono<User> createUser(User user) {
        return userRepository.save(user);
    }

    public Mono<Boolean> putUser(@PathVariable("id") int id, User user) {
        Mono<Boolean> result = userRepository.existsById(id);
        if (result.equals(Mono.just(true))) {
            user.setId(id);
            userRepository.save(user);
        }
        return result;
    }

    public Mono<Boolean> deleteUser(@PathVariable("id") int id) {
        Mono<Boolean> result = userRepository.existsById(id);
        if (result.equals(Mono.just(true))) {
            userRepository.deleteById(id);
        }
        return result;
    }
}
