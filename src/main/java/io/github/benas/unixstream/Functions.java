package io.github.benas.unixstream;

import io.github.benas.unixstream.components.Fold;

import java.util.Objects;
import java.util.function.Function;

/**
 * This class consists of {@code static} factory methods to create commons functions.
 *
 * @author Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 */
public final class Functions {

    private Functions() throws InstantiationException {
        throw new InstantiationException("This class is not created for instantiation");
    }

    /**
     * Compact a string by removing all white spaces.
     *
     * @return a compact string
     */
    public static Function<String, String> compact() {
        return s -> s.replaceAll("\\s", "");
    }

    /**
     * Split a String by a delimiter and extract fields
     *
     * @param delimiter the delimiter
     * @param field     the index of the field to extract (starting from 1).
     * @return a cut function
     */
    public static Function<String, String> cut(final String delimiter, final int field) {
        Objects.requireNonNull(delimiter, "The delimiter must not be null");
        if (field < 1) {
            throw new IllegalArgumentException("Field must be >= 1");
        }
        return s -> {
            String[] strings = s.split(delimiter);
            return field <= strings.length ? strings[field - 1] : "";
        };
    }

    /**
     * Replace Windows line separators (CRLF) by Unix line separators (LF).
     *
     * @return a dos2unix function
     */
    public static Function<String, String> dos2unix() {
        return s -> s.replaceAll("\r\n", "\n"); // or s.replaceAll("\r", "");
    }

    /**
     * Replace tabs with white spaces in a String.
     *
     * @return a expand function
     */
    public static Function<String, String> expand() {
        return s -> s.replaceAll("\t", " ");
    }

    /**
     * Replace white spaces with tabs in a String.
     *
     * @return a unexpand function
     */
    public static Function<String, String> unexpand() {
        return s -> s.replaceAll(" ", "\t");
    }

    /**
     * Fold a String with a given width.
     *
     * @param width         the fold width
     * @param lineSeparator the line separator
     * @return a fold function
     */
    public static Function<String, String> fold(final int width, final String lineSeparator) {
        Objects.requireNonNull(lineSeparator, "The line separator must not be null");
        if (width < 1) {
            throw new IllegalArgumentException("Width must be >= 1");
        }
        return s -> {
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            int length = s.length();
            while (i < length && !String.valueOf(s.charAt(i)).equals(lineSeparator)) {
                stringBuilder.append(s.charAt(i));
                if (++i % width == 0) {
                    stringBuilder.append(lineSeparator);
                }
            }
            return stringBuilder.toString();
        };
    }

    /**
     * Fold a String with a given width.
     * Lines will be separated with the default System line separator
     *
     * @param width         the fold width
     * @return a fold function
     */
    public static Function<String, String> fold(final int width) {
        return fold(width, Fold.LINE_SEPARATOR);
    }

    /**
     * Transform a String to lower case.
     *
     * @return a lowercase function
     */
    public static Function<String, String> lowercase() {
        return String::toLowerCase;
    }

    /**
     * Transform a String to upper case.
     *
     * @return a uppercase function
     */
    public static Function<String, String> uppercase() {
        return String::toUpperCase;
    }

    /**
     * Transform an Object to a String by calling {@link Object#toString()}.
     *
     * @param <T> the type of objects in the stream
     * @return a stringify function
     */
    public static <T> Function<T, String> str() {
        return Object::toString;
    }

    /**
     * Replace patterns with expressions in a stream of Strings.
     *
     * @param regexp      the regexp to look for
     * @param replacement the replacement to apply
     * @return a translate function
     */
    public static Function<String, String> tr(final String regexp, final String replacement) {
        Objects.requireNonNull(regexp, "The regular expression must not be null");
        Objects.requireNonNull(replacement, "The replacement must not be null");
        return s -> s.replaceAll(regexp, replacement);
    }

    /**
     * Trim a String by removing trailing white spaces.
     *
     * @return a trim function
     */
    public static Function<String, String> trim() {
        return String::trim;
    }

    /**
     * Truncate a String to a limited size.
     *
     * @param size the new String size
     * @return a trunc function
     */
    public static Function<String, String> trunc(final int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Size must be >= 1");
        }
        return s -> s.substring(0, size);
    }

}
