package io.github.benas.xstream.components;

import io.github.benas.xstream.Stage;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Reverse elements in a stream.
 *
 * @param <T> the type of elements in the stream.
 * @author Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 */
public class Reverse<T> implements Stage<T, T> {

    /**
     * Create a new {@link Reverse} instance.
     */
    public Reverse() {
    }

    /**
     * Create a new {@link Reverse} instance.
     *
     * @param <T> the type of elements in the stream.
     * @return Create a new {@link Reverse} instance.
     */
    public static <T> Reverse<T> reverse() {
        return new Reverse<>();
    }

    @Override
    public Stream<T> apply(Stream<T> input) {
        Deque<T> deque = input.collect(Collectors.toCollection(ArrayDeque::new));
        return StreamSupport.stream(Spliterators.spliterator(deque.descendingIterator(), deque.size(), Spliterator.ORDERED), false);
    }
}
