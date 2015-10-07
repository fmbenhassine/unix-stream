package io.github.benas.xstream.components;

import java.util.stream.Stream;

import io.github.benas.xstream.Stage;

public class Stringify<T> implements Stage<T, String> {

    public Stringify() {
    }

    public static <T> Stringify<T> stringify() {
        return new Stringify<>();
    }
    
    @Override
    public Stream<String> apply(Stream<T> input) {
        return input.map(Object::toString);
    }
}
