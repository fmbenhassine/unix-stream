package io.github.benas.unixstream.components;

import io.github.benas.unixstream.Predicates;
import io.github.benas.unixstream.Stage;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Exclude elements matching a given predicate from a stream.
 * This is the opposite behavior of {@link Stream#filter(java.util.function.Predicate)}.
 *
 * @param <T> the type of elements in the input stream
 * @author Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 */
public class Exclude<T> implements Stage<T, T> {

    private Predicate<T> predicate;

    /**
     * Create a new {@link Exclude} instance.
     *
     * @param predicate the predicate to apply to each element of the input stream.
     */
    public Exclude(final Predicate<T> predicate) {
        Objects.requireNonNull(predicate);
        this.predicate = predicate;
    }

    /**
     * Create a new {@link Exclude} instance.
     *
     * @param predicate the predicate to apply to each element of the input stream.
     * @param <T>       the type of elements in the stream
     * @return a new {@link Exclude} instance.
     */
    public static <T> Exclude<T> exclude(final Predicate<T> predicate) {
        return new Exclude<>(predicate);
    }

    @Override
    public Stream<T> apply(Stream<T> input) {
        return input.filter(Predicates.exclude(predicate));
    }
}
