package io.github.benas.xstream.components;

import java.util.stream.Stream;
import io.github.benas.xstream.Stage;

public class Uniq<T> implements Stage<T, T> {

    public Uniq() {
    }

    public static <T> Uniq<T> uniq() {
        return new Uniq<>();
    }
    
    @Override
    public Stream<T> apply(Stream<T> input) {
        return input.distinct();
    }
}
