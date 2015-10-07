package io.github.benas.xstream.components;

import java.util.stream.Stream;

import io.github.benas.xstream.Stage;

public class Trim implements Stage<String, String> {

    public Trim() {
    }

    public static Trim trim() {
        return new Trim();
    }
    
    @Override
    public Stream<String> apply(Stream<String> input) {
        return input.map(String::trim);
    }
    
}
