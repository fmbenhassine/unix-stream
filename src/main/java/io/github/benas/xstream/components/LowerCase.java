package io.github.benas.xstream.components;

import java.util.stream.Stream;

import io.github.benas.xstream.Stage;

public class LowerCase implements Stage<String, String> {

    public LowerCase() {
    }

    public static LowerCase lowerCase() {
        return new LowerCase();
    }
    
    @Override
    public Stream<String> apply(Stream<String> input) {
        return input.map(String::toLowerCase);
    }
    
}
