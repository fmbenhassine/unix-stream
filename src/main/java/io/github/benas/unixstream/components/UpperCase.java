package io.github.benas.unixstream.components;

import io.github.benas.unixstream.Functions;
import io.github.benas.unixstream.Stage;

import java.util.stream.Stream;

/**
 * Transform a String to upper case.
 *
 * @author Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 */
public class UpperCase implements Stage<String, String> {

    /**
     * Create a new {@link UpperCase} instance.
     */
    public UpperCase() {
    }

    /**
     * Create a new {@link UpperCase} instance.
     *
     * @return a new {@link UpperCase} instance.
     */
    public static UpperCase uppercase() {
        return new UpperCase();
    }

    @Override
    public Stream<String> apply(Stream<String> input) {
        return input.map(Functions.uppercase());
    }

}
