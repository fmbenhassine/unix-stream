package io.github.benas.xstream.components;

import java.util.stream.Stream;
import io.github.benas.xstream.Stage;

public class Head<T> implements Stage<T, T> {

    public static long DEFAULT_SIZE = 10;

    private long size;

    public Head() {
        this(DEFAULT_SIZE);
    }

    public Head(long size) {
        this.size = size;
    }
    
    public static <T> Head<T> head() {
        return new Head<>();
    }

    public static <T> Head<T> head(long size) {
        return new Head<>(size);
    }

    @Override
    public Stream<T> apply(Stream<T> input) {
        return input.limit(size);
    }
    
}
