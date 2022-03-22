package com.exercicio.starwars.models;

import java.util.UUID;

public class Character {

    private UUID id;
    public String name;
    public int height;
    public int mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    public String gender;
    public String homeWorld;
    public String species;

    public Character(String id, String name, int height, int mass, String hairColor, String skinColor, String eyeColor, String birthYear, String gender, String homeWorld, String species) {
        this.id = getOrValidadeUUID(id);
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hairColor = hairColor;
        this.skinColor = skinColor;
        this.eyeColor = eyeColor;
        this.birthYear = birthYear;
        this.gender = gender;
        this.homeWorld = homeWorld;
        this.species = species;
    }

    public UUID getId() {
        return id;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getBirthYear() {
        return birthYear;
    }

    private UUID getOrValidadeUUID(String id) {
        try{
            return UUID.fromString(id);
        } catch (IllegalArgumentException exception){
            return UUID.randomUUID();
        }
    }

    @Override
    public String toString() {
        return id + ", " + name + ", " + height + ", " + mass + ", " + hairColor + ", " + skinColor + ", " + eyeColor + ", " + birthYear +
                ", " + gender + ", " + homeWorld + ", " + species;
    }
}
