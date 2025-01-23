package org.example.exercicesreactifs.exo10.controller;

import org.example.exercicesreactifs.exo10.entity.Room;
import org.example.exercicesreactifs.exo10.service.RoomService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.*;

@RestController
@RequestMapping("api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public Mono<Room> addingRoom(Room room) {
        return roomService.addRoom(room);
    }

    @PostMapping
    public Flux<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("{id}")
    public Mono<Room> getRoom(int id) {
        return roomService.getRoomById(id);
    }

    @PutMapping("{id}")
    public Mono<Room> updateRoom(@PathVariable("id")int id, Room room) {
        return roomService.updateRoom(room);
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteRoom(int id) {
        return roomService.deleteRoomById(id);
    }


}
