package io.github.benas.xstream.components;

import java.util.stream.Stream;

import io.github.benas.xstream.Stage;

public class UpperCase implements Stage<String, String> {

    public UpperCase() {
    }

    public static UpperCase uppercase() {
        return new UpperCase();
    }
    
    @Override
    public Stream<String> apply(Stream<String> input) {
        return input.map(String::toUpperCase);
    }
    
}
