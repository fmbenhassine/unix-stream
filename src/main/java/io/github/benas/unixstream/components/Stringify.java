package io.github.benas.unixstream.components;

import io.github.benas.unixstream.Functions;
import io.github.benas.unixstream.Stage;

import java.util.stream.Stream;

/**
 * Transform a stream of objects into a stream of Strings by calling {@link Object#toString()} on each object.
 *
 * @param <T> the type of elements in the stream.
 * @author Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 */
public class Stringify<T> implements Stage<T, String> {

    /**
     * Create a new {@link Stringify} instance.
     */
    public Stringify() {
    }

    /**
     * Create a new {@link Stringify} instance.
     *
     * @param <T> the type of elements in the stream
     * @return a new {@link Stringify} instance.
     */
    public static <T> Stringify<T> stringify() {
        return new Stringify<>();
    }

    @Override
    public Stream<String> apply(Stream<T> input) {
        return input.map(Functions.str());
    }
}
