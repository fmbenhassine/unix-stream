package io.github.benas.unixstream.components;

import io.github.benas.unixstream.Stage;

import java.util.stream.Stream;

import static java.lang.String.valueOf;

/**
 * Count words or lines in a stream.
 *
 * @author Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 */
public class WordCount implements Stage<String, String> {

    private Option option;

    public WordCount() {
        this(Option.W);
    }

    /**
     * Create a new {@link WordCount} instance.
     *
     * @param option the option to apply
     */
    public WordCount(final Option option) {
        this.option = option;
    }

    /**
     * Create a new {@link WordCount} instance.
     *
     * @return a new {@link WordCount} instance.
     */
    public static WordCount wc() {
        return new WordCount();
    }

    /**
     * Create a new {@link WordCount} instance.
     *
     * @param option the option to apply
     * @return a new {@link WordCount} instance.
     */
    public static WordCount wc(final Option option) {
        return new WordCount(option);
    }

    @Override
    public Stream<String> apply(Stream<String> input) {
        if (option.equals(Option.L)) {
            return Stream.of(valueOf(input.count()));
        } else {
            Stream<String> stringStream = input.flatMap(s -> Stream.of(s.split(" +")));
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
