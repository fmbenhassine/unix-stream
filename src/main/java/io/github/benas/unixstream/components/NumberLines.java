package io.github.benas.unixstream.components;

import io.github.benas.unixstream.Stage;

import java.util.stream.Stream;

/**
 * Print line numbers of a stream of Strings.
 *
 * @author Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 */
public class NumberLines implements Stage<String, String> {

    private long number = 1;

    /**
     * Create a new {@link NumberLines} instance.
     */
    public NumberLines() {
    }

    /**
     * Create a new {@link NumberLines} instance.
     *
     * @return a new {@link NumberLines} instance.
     */
    public static NumberLines numberLines() {
        return new NumberLines();
    }

    @Override
    public Stream<String> apply(Stream<String> input) {
        return input.map(s -> number++ + " " + s);
    }

}
