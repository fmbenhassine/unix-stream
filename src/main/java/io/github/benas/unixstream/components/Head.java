package io.github.benas.unixstream.components;

import io.github.benas.unixstream.Stage;

import java.util.stream.Stream;

/**
 * Keep the first X elements from a stream.
 * This is an alias for {@link Stream#limit(long)}.
 *
 * @param <T> the type of elements in the stream
 * @author Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 */
public class Head<T> implements Stage<T, T> {

    public static long DEFAULT_SIZE = 10;

    private long size;

    /**
     * Create a new {@link Head} instance.
     */
    public Head() {
        this(DEFAULT_SIZE);
    }

    /**
     * Create a new {@link Head} instance.
     *
     * @param size the number of elements to keep
     */
    public Head(final long size) {
        if (size < 1) {
            throw new IllegalArgumentException("Size must be >= 1");
        }
        this.size = size;
    }

    /**
     * Create a new {@link Head} instance.
     *
     * @param <T> the type of elements in the stream
     * @return a new {@link Head} instance.
     */
    public static <T> Head<T> head() {
        return new Head<>();
    }

    /**
     * Create a new {@link Head} instance.
     *
     * @param size the number of elements to keep
     * @param <T>  the type of elements in the stream
     * @return a new {@link Head} instance.
     */
    public static <T> Head<T> head(final long size) {
        return new Head<>(size);
    }

    @Override
    public Stream<T> apply(Stream<T> input) {
        return input.limit(size);
    }

}
