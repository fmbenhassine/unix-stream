package io.github.benas.xstream.components;

import io.github.benas.xstream.Stage;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Exclude<T> implements Stage<T, T> {

    private Predicate<T> predicate;

    public Exclude(final Predicate<T> predicate) {
        Objects.requireNonNull(predicate);
        this.predicate = predicate;
    }

    public static <T> Exclude<T> exclude(final Predicate<T> predicate) {
        return new Exclude<>(predicate);
    }

    @Override
    public Stream<T> apply(Stream<T> input) {
        return input.filter(predicate.negate());
    }
}
