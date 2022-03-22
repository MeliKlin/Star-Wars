package com.exercicio.starwars.database;

import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class FilePersistence {

    private final BufferedWriter writer;

    public FilePersistence() throws IOException {
        writer = new BufferedWriter(new FileWriter("data.txt"));
    }

    public BufferedWriter getWriter() {
        return writer;
    }

}
