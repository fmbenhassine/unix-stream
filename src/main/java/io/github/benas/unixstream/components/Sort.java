package io.github.benas.unixstream.components;

import io.github.benas.unixstream.Stage;

import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Sort elements of the input stream in their natural order or using a custom comparator.
 * This is an alias of {@link Stream#sorted()}.
 *
 * @param <T> the type of elements in the input stream
 * @author Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 */
public class Sort<T> implements Stage<T, T> {

    private Comparator<T> comparator;

    /**
     * Create a new {@link Sort} instance.
     */
    public Sort() {
    }

    /**
     * Create a new {@link Sort} instance.
     *
     * @param comparator the comparator of elements
     */
    public Sort(final Comparator<T> comparator) {
        Objects.requireNonNull(comparator, "The comparator must not be null");
        this.comparator = comparator;
    }

    /**
     * Create a new {@link Sort} instance.
     *
     * @param <T> the type of elements in the stream
     * @return a new {@link Sort} instance.
     */
    public static <T> Sort<T> sort() {
        return new Sort<>();
    }

    /**
     * Create a new {@link Sort} instance.
     *
     * @param comparator the comparator of elements
     * @param <T>        the type of elements in the stream
     * @return a new {@link Sort} instance.
     */
    public static <T> Sort<T> sort(Comparator<T> comparator) {
        return new Sort<>(comparator);
    }

    @Override
    public Stream<T> apply(Stream<T> input) {
        return comparator != null ? input.sorted(comparator) : input.sorted();
    }
}
