package io.github.benas.xstream.components;

import io.github.benas.xstream.Stage;

import java.util.stream.Stream;

public class Head<T> implements Stage<T, T> {

    public static long DEFAULT_SIZE = 10;

    private long size;

    public Head() {
        this(DEFAULT_SIZE);
    }

    public Head(final long size) {
        if (size < 1) {
            throw new IllegalArgumentException("Size must be >= 1");
        }
        this.size = size;
    }
    
    public static <T> Head<T> head() {
        return new Head<>();
    }

    public static <T> Head<T> head(final long size) {
        return new Head<>(size);
    }

    @Override
    public Stream<T> apply(Stream<T> input) {
        return input.limit(size);
    }
    
}
