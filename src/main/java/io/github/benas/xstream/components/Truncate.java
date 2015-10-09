package io.github.benas.xstream.components;

import io.github.benas.xstream.Stage;

import java.util.stream.Stream;

public class Truncate implements Stage<String, String> {
    
    private int size;

    public Truncate(final int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Size must be >= 1");
        }
        this.size = size;
    }

    public static Truncate trunc(final int size) {
        return new Truncate(size);
    }
    
    @Override
    public Stream<String> apply(Stream<String> input) {
        return input.map(s -> s.substring(0, size));
    }
    
}
