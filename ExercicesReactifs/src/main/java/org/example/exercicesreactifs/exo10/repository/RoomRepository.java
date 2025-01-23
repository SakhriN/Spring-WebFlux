package org.example.exercicesreactifs.exo10.repository;

import org.example.exercicesreactifs.exo10.entity.Room;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends ReactiveCrudRepository<Room,Integer> {
}
