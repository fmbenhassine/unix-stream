package io.github.benas.ustream.components;

import io.github.benas.ustream.Stage;

import java.util.stream.Stream;

/**
 * Keep the last X elements from a stream.
 * This is the opposite behavior of {@link Head}.
 *
 * @param <T> the type of elements in the stream
 * @author Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 */
public class Tail<T> implements Stage<T, T> {

    public static long DEFAULT_SIZE = 10;

    private long size;

    /**
     * Create a new {@link Tail} instance.
     */
    public Tail() {
        this(DEFAULT_SIZE);
    }

    /**
     * Create a new {@link Tail} instance.
     *
     * @param size the number of elements to keep
     */
    public Tail(final long size) {
        if (size < 1) {
            throw new IllegalArgumentException("Size must be >= 1");
        }
        this.size = size;
    }

    /**
     * Create a new {@link Tail} instance.
     *
     * @param <T> the type of elements in the stream
     * @return a new {@link Tail} instance.
     */
    public static <T> Tail<T> tail() {
        return new Tail<>();
    }

    /**
     * Create a new {@link Tail} instance.
     *
     * @param size the number of elements to keep
     * @param <T>  the type of elements in the stream
     * @return a new {@link Tail} instance.
     */
    public static <T> Tail<T> tail(final long size) {
        return new Tail<>(size);
    }

    @Override
    public Stream<T> apply(Stream<T> input) {
        Stream<T> reverseStream = new Reverse<T>().apply(input).limit(size);
        return new Reverse<T>().apply(reverseStream);
    }
}
