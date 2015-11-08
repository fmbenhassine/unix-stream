package io.github.benas.unixstream.components;

import io.github.benas.unixstream.Stage;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * Concat two streams.
 *
 * @author Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 */
public class Concat<T> implements Stage<T, T> {

    private Stream<T> stream;

    /**
     * Create a new {@link Concat} instance.
     *
     * @param stream the stream to concat.
     */
    public Concat(final Stream<T> stream) {
        Objects.requireNonNull(stream, "The stream must not be null");
        this.stream = stream;
    }

    /**
     * Create a new {@link Concat} instance.
     *
     * @param stream the stream to concat
     * @param <T>    the type of elements in the stream
     * @return a new {@link Concat} instance
     */
    public static <T> Concat<T> concat(final Stream<T> stream) {
        Objects.requireNonNull(stream, "The stream must not be null");
        return new Concat<>(stream);
    }

    @Override
    public Stream<T> apply(Stream<T> stream) {
        return Stream.concat(stream, this.stream);
    }
}
