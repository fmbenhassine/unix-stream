package io.github.benas.unixstream.components;

import io.github.benas.unixstream.Functions;
import io.github.benas.unixstream.Stage;

import java.util.stream.Stream;

/**
 * Replace tabs with white spaces in a String.
 *
 * @author Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 */
public class Expand implements Stage<String, String> {

    /**
     * Create a new {@link Expand} instance.
     */
    public Expand() {
    }

    /**
     * Create a new {@link Expand} instance.
     *
     * @return a new {@link Expand} instance.
     */
    public static Expand expand() {
        return new Expand();
    }

    @Override
    public Stream<String> apply(Stream<String> input) {
        return input.map(Functions.expand());
    }

}
