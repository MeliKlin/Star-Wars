package com.exercicio.starwars.database;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Component
public class ReadFromFile {

    public BufferedReader getReader() throws FileNotFoundException {
        return new BufferedReader(new FileReader("data.txt"));
    }

}
