package io.github.benas.xstream;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * This class consists of {@code static} factory methods to create commons predicates.
 *
 * @author Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 */
public class Predicates {

    public static <T> Predicate<T> nonNull() {
        return Objects::nonNull;
    }

    public static <T> Predicate<T> isNull() {
        return Objects::isNull;
    }

    public static Predicate<String> empty() {
        return String::isEmpty;
    }

    public static Predicate<String> contains(final String pattern) {
        Objects.requireNonNull(pattern, "The pattern should not be null");
        return s -> s.contains(pattern);
    }

    public static Predicate<String> startsWith(final String pattern) {
        Objects.requireNonNull(pattern, "The pattern should not be null");
        return s -> s.startsWith(pattern);
    }

    public static Predicate<String> endsWith(final String pattern) {
        Objects.requireNonNull(pattern, "The pattern should not be null");
        return s -> s.endsWith(pattern);
    }

    public static Predicate<String> matches(final String regexp) {
        Objects.requireNonNull(regexp, "The regexp should not be null");
        return s -> s.matches(regexp);
    }

    public static Predicate<Number> even() {
        return s -> s.shortValue() % 2 == 0;
    }

    public static Predicate<Number> odd() {
        return even().negate();
    }

    public static Predicate<Number> isZero() {
        return s -> s.shortValue() == 0;
    }
}
