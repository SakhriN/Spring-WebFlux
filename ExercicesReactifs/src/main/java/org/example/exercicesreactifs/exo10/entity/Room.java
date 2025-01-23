package org.example.exercicesreactifs.exo10.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("room")
public class Room {
    @Id
    private int id;
    private String nom;
    private String description;
    private static int count = 0;

public Room() {}

    public Room(String nom, String description) {
        this.id = count++;
        this.nom = nom;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Room.count = count;
    }
}
