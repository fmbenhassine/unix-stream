package io.github.benas.xstream.components;

import java.util.stream.Stream;

import io.github.benas.xstream.Stage;

public class Expand implements Stage<String, String> {

    public Expand() {
    }

    public static Expand expand() {
        return new Expand();
    }
    
    @Override
    public Stream<String> apply(Stream<String> input) {
        return input.map(s -> s.replaceAll("\t"," "));
    }
    
}
