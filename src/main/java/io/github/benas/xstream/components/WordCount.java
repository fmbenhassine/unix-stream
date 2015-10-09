package io.github.benas.xstream.components;

import io.github.benas.xstream.Stage;

import java.util.stream.Stream;

import static java.lang.String.valueOf;

public class WordCount implements Stage<String, String> {

    private Option option;

    public WordCount() {
        this(Option.W);
    }

    public WordCount(final Option option) {
        this.option = option;
    }

    public static WordCount wc() {
        return new WordCount();
    }

    public static WordCount wc(final Option option) {
        return new WordCount(option);
    }

    @Override
    public Stream<String> apply(Stream<String> input) {
        if (option.equals(Option.L)) {
            return Stream.of(valueOf(input.count()));
        } else {
            Stream<String> stringStream = input.flatMap(s -> Stream.of(s.split(" ")));
            return Stream.of(valueOf(stringStream.count()));
        }
    }

    public enum Option {
        /**
         * Mimics wc -w
         */
        W,
        /**
         * Mimics wc -l
         */
        L
    }
}
