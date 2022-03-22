package com.exercicio.starwars.repositories;

import com.exercicio.starwars.database.FilePersistence;
import com.exercicio.starwars.database.ReadFromFile;
import com.exercicio.starwars.models.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class CharactersDAO implements CharactersDAOInterface {

    @Autowired
    private FilePersistence filePersistence;
    @Autowired
    private ReadFromFile readFromFile;

    @Override
    public Character save(Character character) throws IOException {
        this.filePersistence.getWriter().append(character.toString()).append("\n").flush();
        return character;
    }

    public List<Character> list() throws IOException {
        ArrayList<Character> characters = new ArrayList<>();
        BufferedReader reader = this.readFromFile.getReader();

        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            String[] lines = line.split(", ");
            characters.add(new Character(lines[0], lines[1], Integer.parseInt(lines[2]), Integer.parseInt(lines[3]), lines[4],lines[5], lines[6], lines[7], lines[8], lines[9], lines[10]));
        }

        return characters;
    }

    public List<Character> findCharacter(String nameInLowerCase) throws IOException {
        List<Character> characters = list();
        return characters.stream().filter(c -> c.name.toLowerCase(Locale.ROOT).contains(nameInLowerCase)).collect(Collectors.toList());
    }

    public Optional<Character> findCharacterById(String id) throws IOException {
        List<Character> characters = list();
        UUID validUUID = validadeUUID(id);
        if (validUUID == null) {
            return Optional.empty();
        }
        return characters.stream().filter(c -> c.getId().equals(validUUID)).findFirst();
    }

    private UUID validadeUUID(String id) {
        try {
            return UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
