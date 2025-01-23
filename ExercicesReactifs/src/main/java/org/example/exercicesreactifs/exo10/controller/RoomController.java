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
    public Flux<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("{id}")
    public Mono<Room> getRoom(@PathVariable("id") int id) {
        return roomService.getRoomById(id);
    }

    @PostMapping
    public Mono<Room> addingRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }

    @PutMapping("{id}")
    public Mono<Room> updateRoom(@PathVariable("id") int id, @RequestBody Room room) {
        return roomService.updateRoom(id,room);
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteRoom(@PathVariable("id") int id) {
        return roomService.deleteRoomById(id);
    }


}
