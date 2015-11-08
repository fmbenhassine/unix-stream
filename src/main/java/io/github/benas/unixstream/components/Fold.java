package io.github.benas.unixstream.components;

import io.github.benas.unixstream.Stage;

import java.util.stream.Stream;

/**
 * Fold Strings with a given width in a stream of Strings.
 *
 * @author Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 */
public class Fold implements Stage<String, String> {

    public static String LINE_SEPARATOR = System.getProperty("line.separator");

    public static int DEFAULT_WIDTH = 80;

    private int width;

    /**
     * Create a new {@link Fold} instance.
     */
    public Fold() {
        this(DEFAULT_WIDTH);
    }

    /**
     * Create a new {@link Fold} instance.
     *
     * @param width the fold width
     */
    public Fold(final int width) {
        if (width < 1) {
            throw new IllegalArgumentException("Width must be >= 1");
        }
        this.width = width;
    }

    /**
     * Create a new {@link Fold} instance.
     *
     * @return a new {@link Fold} instance.
     */
    public static Fold fold() {
        return new Fold();
    }

    /**
     * Create a new {@link Fold} instance.
     *
     * @param width the fold width
     * @return a new {@link Fold} instance.
     */
    public static Fold fold(final int width) {
        return new Fold(width);
    }

    @Override
    public Stream<String> apply(Stream<String> input) {
        return input.map(this::doFold);
    }

    private String doFold(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        int length = s.length();
        while (i < length && !String.valueOf(s.charAt(i)).equals(LINE_SEPARATOR)) {
            stringBuilder.append(s.charAt(i));
            if (++i % width == 0) {
                stringBuilder.append(LINE_SEPARATOR);
            }
        }
        System.out.println("stringBuilder = " + stringBuilder.toString());
        return stringBuilder.toString();
    }

}
