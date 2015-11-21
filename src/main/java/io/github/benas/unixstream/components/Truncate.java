package io.github.benas.unixstream.components;

import io.github.benas.unixstream.Functions;
import io.github.benas.unixstream.Stage;

import java.util.stream.Stream;

/**
 * Truncate a String to a limited size.
 *
 * @author Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 */
public class Truncate implements Stage<String, String> {

    private int size;

    /**
     * Create a new {@link Truncate} instance.
     *
     * @param size the size of the resulting String
     */
    public Truncate(final int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Size must be >= 1");
        }
        this.size = size;
    }

    /**
     * Create a new {@link Truncate} instance.
     *
     * @param size the size of the resulting String
     * @return a new {@link Truncate} instance.
     */
    public static Truncate trunc(final int size) {
        return new Truncate(size);
    }

    @Override
    public Stream<String> apply(Stream<String> input) {
        return input.map(Functions.trunc(size));
    }

}
