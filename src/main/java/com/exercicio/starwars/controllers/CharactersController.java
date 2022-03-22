package com.exercicio.starwars.controllers;

import com.exercicio.starwars.dtos.CreateCharacterDTO;
import com.exercicio.starwars.models.Character;
import com.exercicio.starwars.repositories.CharactersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
public class CharactersController {

    @Autowired
    private CharactersDAO charactersDAO;

    @PostMapping("/characters/multiple")
    public ResponseEntity<Character> createMultipleCharacters(
            @RequestBody List<CreateCharacterDTO> charactersDTO
    ) throws IOException {
        for(CreateCharacterDTO characterDTO: charactersDTO) {
            charactersDAO.save(characterDTO.convert());
        }
        return ResponseEntity.ok().build();
    }

    @PostMapping("/characters")
    public ResponseEntity<Character> createCharacter(
            @RequestBody CreateCharacterDTO characterDTO
    ) throws IOException, URISyntaxException {
        Character character = characterDTO.convert();
        charactersDAO.save(character);
        URI uri = new URI("http://localhost:8080/characters/" + character.getId());
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/characters")
    public ResponseEntity<List<Character>> listAllCharacters(
    ) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(charactersDAO.list());
    }

    @GetMapping("/characters/names/{name}")
    public ResponseEntity<List<Character>> findCharacter(
            @PathVariable String name
    ) throws IOException {
        return ResponseEntity.ok(charactersDAO.findCharacter(name.toLowerCase(Locale.ROOT)));
    }

    @GetMapping("/characters/{id}")
    public ResponseEntity<Optional<Character>> findCharacterById(
            @PathVariable String id
    ) throws IOException {
        return ResponseEntity.ok(charactersDAO.findCharacterById(id));
    }
}
