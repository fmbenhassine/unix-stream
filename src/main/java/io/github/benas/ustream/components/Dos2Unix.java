package io.github.benas.ustream.components;

import io.github.benas.ustream.Stage;

import java.util.stream.Stream;

/**
 * Replace Windows line separators (CRLF) by Unix line separators (LF).
 *
 * @author Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 */
public class Dos2Unix implements Stage<String, String> {

    /**
     * Create a new {@link Dos2Unix} instance.
     */
    public Dos2Unix() {
    }

    /**
     * Create a new {@link Dos2Unix} instance.
     *
     * @return a new {@link Dos2Unix} instance.
     */
    public static Dos2Unix dos2unix() {
        return new Dos2Unix();
    }

    @Override
    public Stream<String> apply(Stream<String> input) {
        return input.map(s -> s.replaceAll("\r\n", "\n")); // or s.replaceAll("\r", "")
    }
}
