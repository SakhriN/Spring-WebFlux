package org.example.exercicesreactifs.exo10.service;

import org.example.exercicesreactifs.exo10.entity.Room;
import org.example.exercicesreactifs.exo10.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;


    public Mono<Room> addRoom(Room room) {
        return roomRepository.save(room);
    }
    public Flux<Room> getAllRooms() {
        return roomRepository.findAll();
    }
    public Mono<Room> getRoomById(int id) {
        return roomRepository.findById(id);
    }
    public Mono<Room> updateRoom(int id, Room room) {
        room.setId(id);
        return roomRepository.save(room);
    }
    public Mono<Void> deleteRoomById(int id) {
        return roomRepository.deleteById(id);
    }






}

