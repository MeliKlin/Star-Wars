package com.exercicio.starwars.dtos;

import com.exercicio.starwars.models.Character;

import java.util.Objects;

public class CreateCharacterDTO {

    public String name;
    public String height;
    public String mass;
    public String hair_color;
    public String skin_color;
    public String eye_color;
    public String birth_year;
    public String gender;
    public String homeworld;
    public String species;

    public Character convert() {
        return new Character("", name, convertStringToInt(height), convertStringToInt(mass), hair_color, skin_color, eye_color, birth_year, gender, homeworld, species);
    }

    private Integer convertStringToInt(String height) {
        try {
            return Integer.parseInt(height);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
