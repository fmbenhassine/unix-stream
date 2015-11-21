package io.github.benas.unixstream.components;

import io.github.benas.unixstream.Functions;
import io.github.benas.unixstream.Stage;

import java.util.stream.Stream;

/**
 * Trim a String by removing trailing white spaces.
 *
 * @author Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 */
public class Trim implements Stage<String, String> {

    /**
     * Create a new {@link Trim} instance.
     */
    public Trim() {
    }

    /**
     * Create a new {@link Trim} instance.
     *
     * @return a new {@link Trim} instance.
     */
    public static Trim trim() {
        return new Trim();
    }

    @Override
    public Stream<String> apply(Stream<String> input) {
        return input.map(Functions.trim());
    }

}
