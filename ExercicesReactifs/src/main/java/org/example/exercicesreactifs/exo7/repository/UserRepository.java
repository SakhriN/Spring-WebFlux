package org.example.exercicesreactifs.exo7.repository;

import org.example.exercicesreactifs.exo7.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User,Integer> {
}
