package com.exercicio.starwars.repositories;

import com.exercicio.starwars.models.Character;

import java.io.IOException;
import java.util.List;

public interface CharactersDAOInterface {

    Character save(Character character) throws IOException;
//    List<Character> list() throws IOException;

}
