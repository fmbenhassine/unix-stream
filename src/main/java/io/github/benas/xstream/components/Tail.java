package io.github.benas.xstream.components;

import java.util.stream.Stream;

import io.github.benas.xstream.Stage;

public class Tail<T> implements Stage<T, T> {

    public static long DEFAULT_SIZE = 10;

    private long size;

    public Tail() {
        this(DEFAULT_SIZE);
    }

    public Tail(long size) {
        this.size = size;
    }
    
    public static <T> Tail<T> tail() {
        return new Tail<>();
    }

    public static <T> Tail<T> tail(long size) {
        return new Tail<>(size);
    }
    
    @Override
    public Stream<T> apply(Stream<T> input) {
        Stream<T> reverseStream = new Reverse<T>().apply(input).limit(size);
        return new Reverse<T>().apply(reverseStream);
    }
}
