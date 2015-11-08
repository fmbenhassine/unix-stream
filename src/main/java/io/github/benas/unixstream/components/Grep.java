package io.github.benas.unixstream.components;

import io.github.benas.unixstream.Stage;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * Keep elements containing a given pattern in a stream of Strings.
 *
 * @author Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 */
public class Grep implements Stage<String, String> {

    private String pattern;

    /**
     * Create a new {@link Grep} instance.
     *
     * @param pattern the pattern to look for in each input element
     */
    public Grep(final String pattern) {
        Objects.requireNonNull("pattern must not be null");
        this.pattern = pattern;
    }

    /**
     * Create a new {@link Grep} instance.
     *
     * @param pattern the pattern to look for in each input element
     * @return a new {@link Grep} instance.
     */
    public static Grep grep(final String pattern) {
        return new Grep(pattern);
    }

    @Override
    public Stream<String> apply(Stream<String> input) {
        return input.filter(s -> s.contains(pattern));
    }
    
}
