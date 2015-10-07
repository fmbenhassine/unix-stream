package io.github.benas.xstream.components;

import java.util.stream.Stream;
import io.github.benas.xstream.Stage;

public class Sort<T> implements Stage<T, T> {

    public Sort() {
    }

    public static <T> Sort<T> sort() {
        return new Sort<>();
    }
    
    @Override
    public Stream<T> apply(Stream<T> input) {
        return input.sorted();
    }
}
