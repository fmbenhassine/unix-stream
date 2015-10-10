package io.github.benas.xstream.components;

import io.github.benas.xstream.Stage;

import java.util.stream.Stream;

/**
 * Remove all white spaces from a String.
 *
 * @author Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 */
public class Compact implements Stage<String, String> {

    /**
     * Create a new {@link Compact} instance.
     */
    public Compact() {
    }

    /**
     * Create a new {@link Compact} instance.
     *
     * @return a new {@link Compact} instance.
     */
    public static Compact compact() {
        return new Compact();
    }

    @Override
    public Stream<String> apply(Stream<String> input) {
        return input.map(s -> s.replaceAll("\\s", ""));
    }

}
