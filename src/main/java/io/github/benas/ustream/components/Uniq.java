package io.github.benas.ustream.components;

import io.github.benas.ustream.Stage;

import java.util.stream.Stream;

/**
 * Remove duplicates from the input stream.
 * This is an alias of {@link Stream#distinct()}.
 *
 * @param <T> the type of elements in the input stream
 * @author Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 */
public class Uniq<T> implements Stage<T, T> {

    /**
     * Create a new {@link Uniq} instance.
     */
    public Uniq() {
    }

    /**
     * Create a new {@link Uniq} instance.
     *
     * @param <T> the type of elements in the stream
     * @return a new {@link Uniq} instance.
     */
    public static <T> Uniq<T> uniq() {
        return new Uniq<>();
    }

    @Override
    public Stream<T> apply(Stream<T> input) {
        return input.distinct();
    }
}
