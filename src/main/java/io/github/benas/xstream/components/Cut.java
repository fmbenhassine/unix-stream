package io.github.benas.xstream.components;

import io.github.benas.xstream.Stage;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * Split a String by a delimiter and extract fields.
 *
 * @author Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 */
public class Cut implements Stage<String, String> {

    private String delimiter;

    private int field;

    /**
     * Create a new {@link Cut} instance.
     *
     * @param delimiter the delimiter
     * @param field     the index of the field to extract (starting from 1).
     */
    public Cut(final String delimiter, final int field) {
        Objects.requireNonNull(delimiter, "The delimiter must not be null");
        if (field < 1) {
            throw new IllegalArgumentException("Field must be >= 1");
        }
        this.delimiter = delimiter;
        this.field = field - 1;
    }

    /**
     * Create a new {@link Cut} instance.
     *
     * @param delimiter the delimiter
     * @param field     the index of the field to extract (starting from 1).
     * @return a new {@link Cut} instance.
     */
    public static Cut cut(final String delimiter, final int field) {
        return new Cut(delimiter, field);
    }

    @Override
    public Stream<String> apply(Stream<String> input) {
        return input.map(s -> {
            String[] strings = s.split(delimiter);
            return field <= strings.length - 1 ? strings[field] : "";
        });
    }

}
