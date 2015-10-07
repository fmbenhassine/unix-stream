package io.github.benas.xstream.components;

import java.util.stream.Stream;

import io.github.benas.xstream.Stage;

public class Dos2Unix implements Stage<String, String> {

    public Dos2Unix() {
    }
    
    public static Dos2Unix dos2unix() {
        return new Dos2Unix();
    }

    @Override
    public Stream<String> apply(Stream<String> input) {
        return input.map(s -> s.replaceAll("\r\n", "\n")); // or s.replaceAll("\r", "")
    }
}
