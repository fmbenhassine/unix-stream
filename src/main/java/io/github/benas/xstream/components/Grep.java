package io.github.benas.xstream.components;

import java.util.stream.Stream;
import io.github.benas.xstream.Stage;

public class Grep implements Stage<String, String> {

    private String pattern;

    public Grep(String pattern) {
        this.pattern = pattern;
    }

    public static Grep grep(String pattern) {
        return new Grep(pattern);
    }

    @Override
    public Stream<String> apply(Stream<String> input) {
        return input.filter(s -> s.contains(pattern));
    }
    
}
