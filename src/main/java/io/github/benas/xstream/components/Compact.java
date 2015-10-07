package io.github.benas.xstream.components;

import java.util.stream.Stream;

import io.github.benas.xstream.Stage;

public class Compact implements Stage<String, String> {

    public Compact() {
    }

    public static Compact compact() {
        return new Compact();
    }
    
    @Override
    public Stream<String> apply(Stream<String> input) {
        return input.map(s -> s.replaceAll("\\s",""));
    }
    
}
