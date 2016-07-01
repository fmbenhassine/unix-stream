package io.github.benas.unixstream;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * This class consists of {@code static} factory methods to create commons predicates.
 *
 * @author Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 */
public final class Predicates {

    private Predicates() throws InstantiationException {
        throw new InstantiationException("This class is not created for instantiation");
    }

    /**
     * Create a new predicate returning true when the input is not null.
     *
     * @param <T> the type of object on which the predicate will be applied.
     * @return an instance of the predicate
     */
    public static <T> Predicate<T> nonNull() {
        return Objects::nonNull;
    }

    /**
     * Create a new predicate returning true when the input is null.
     *
     * @param <T> the type of object on which the predicate will be applied.
     * @return an instance of the predicate
     */
    public static <T> Predicate<T> isNull() {
        return Objects::isNull;
    }

    /**
     * Create a new predicate returning true when the input String is empty.
     *
     * @return a new predicate returning true when the input String is empty.
     */
    public static Predicate<String> empty() {
        return String::isEmpty;
    }

    /**
     * Create a new predicate that excludes elements matching the given predicate from a stream.
     * This is the opposite behavior of {@link Stream#filter(java.util.function.Predicate)}.
     *
     * @param predicate the predicate to apply
     * @param <T>       the type of objects the predicate will be applied on
     * @return a new predicate excluding elements matching the given predicate from a stream.
     */
    public static <T> Predicate<T> exclude(final Predicate<T> predicate) {
        Objects.requireNonNull(predicate, "The predicate must not be null");
        return predicate.negate();
    }

    /**
     * Create a new predicate returning true when the input String contains the given pattern.
     *
     * @param pattern the pattern to look for in each element
     * @return a new predicate returning true when the input String contains the given pattern.
     */
    public static Predicate<String> contains(final String pattern) {
        Objects.requireNonNull(pattern, "The pattern must not be null");
        return s -> s.contains(pattern);
    }

    /**
     * Create a new predicate returning true when the input String contains the given pattern.
     *
     * @param pattern the pattern to look for in each element
     * @return a new predicate returning true when the input String contains the given pattern.
     */
    public static Predicate<String> grep(final String pattern) {
        Objects.requireNonNull(pattern, "The pattern must not be null");
        return contains(pattern);
    }

    /**
     * Create a new predicate returning true when the input String starts with the given pattern.
     *
     * @param pattern the pattern to look for in each element
     * @return a new predicate returning true when the input String starts with the given pattern.
     */
    public static Predicate<String> startsWith(final String pattern) {
        Objects.requireNonNull(pattern, "The pattern must not be null");
        return s -> s.startsWith(pattern);
    }

    /**
     * Create a new predicate returning true when the input String ends with the given pattern.
     *
     * @param pattern the pattern to look for in each element
     * @return a new predicate returning true when the input String ends with the given pattern.
     */
    public static Predicate<String> endsWith(final String pattern) {
        Objects.requireNonNull(pattern, "The pattern must not be null");
        return s -> s.endsWith(pattern);
    }

    /**
     * Create a new predicate returning true when the input String matches the given regexp.
     *
     * @param regexp the regular expression to match in each element
     * @return a new predicate returning true when the input String matches the given regexp.
     */
    public static Predicate<String> matches(final String regexp) {
        Objects.requireNonNull(regexp, "The regexp must not be null");
        return s -> s.matches(regexp);
    }

    /**
     * Create a new predicate returning true when the input number is even.
     *
     * @return a new predicate returning true when the input number is even.
     */
    public static Predicate<Number> even() {
        return s -> s.shortValue() % 2 == 0;
    }

    /**
     * Create a new predicate returning true when the input number is odd.
     *
     * @return a new predicate returning true when the input number is odd.
     */
    public static Predicate<Number> odd() {
        return even().negate();
    }

    /**
     * Create a new predicate returning true when the input number is equal to zero.
     *
     * @return a new predicate returning true when the input number is equal to zero.
     */
    public static Predicate<Number> isZero() {
        return s -> s.shortValue() == 0;
    }
}
