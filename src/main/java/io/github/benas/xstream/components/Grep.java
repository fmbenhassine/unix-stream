package io.github.benas.xstream.components;

import io.github.benas.xstream.Stage;

import java.util.Objects;
import java.util.stream.Stream;

public class Grep implements Stage<String, String> {

    private String pattern;

    public Grep(final String pattern) {
        Objects.requireNonNull("pattern must not be null");
        this.pattern = pattern;
    }

    public static Grep grep(final String pattern) {
        return new Grep(pattern);
    }

    @Override
    public Stream<String> apply(Stream<String> input) {
        return input.filter(s -> s.contains(pattern));
    }
    
}
