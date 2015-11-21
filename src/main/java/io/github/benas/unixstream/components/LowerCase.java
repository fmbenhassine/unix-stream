package io.github.benas.unixstream.components;

import io.github.benas.unixstream.Functions;
import io.github.benas.unixstream.Stage;

import java.util.stream.Stream;

/**
 * Transform a String to lower case.
 *
 * @author Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 */
public class LowerCase implements Stage<String, String> {

    /**
     * Create a new {@link LowerCase} instance.
     */
    public LowerCase() {
    }

    /**
     * Create a new {@link LowerCase} instance.
     *
     * @return a new {@link LowerCase} instance.
     */
    public static LowerCase lowerCase() {
        return new LowerCase();
    }
    
    @Override
    public Stream<String> apply(Stream<String> input) {
        return input.map(Functions.lowercase());
    }
    
}
