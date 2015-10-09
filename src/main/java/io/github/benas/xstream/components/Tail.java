package io.github.benas.xstream.components;

import io.github.benas.xstream.Stage;

import java.util.stream.Stream;

public class Tail<T> implements Stage<T, T> {

    public static long DEFAULT_SIZE = 10;

    private long size;

    public Tail() {
        this(DEFAULT_SIZE);
    }

    public Tail(final long size) {
        if (size < 1) {
            throw new IllegalArgumentException("Size must be >= 1");
        }
        this.size = size;
    }
    
    public static <T> Tail<T> tail() {
        return new Tail<>();
    }

    public static <T> Tail<T> tail(final long size) {
        return new Tail<>(size);
    }
    
    @Override
    public Stream<T> apply(Stream<T> input) {
        Stream<T> reverseStream = new Reverse<T>().apply(input).limit(size);
        return new Reverse<T>().apply(reverseStream);
    }
}
