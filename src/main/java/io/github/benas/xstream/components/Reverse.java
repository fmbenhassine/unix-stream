package io.github.benas.xstream.components;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import io.github.benas.xstream.Stage;

public class Reverse<T> implements Stage<T, T> {

    public Reverse() {
    }
    
    public static <T> Reverse<T> reverse() {
        return new Reverse<>();
    }
    
    @Override
    public Stream<T> apply(Stream<T> input) {
        Deque<T> deque = input.collect(Collectors.toCollection(ArrayDeque::new));
        return StreamSupport.stream(Spliterators.spliterator(deque.descendingIterator(), deque.size(), Spliterator.ORDERED), false);
    }
}
