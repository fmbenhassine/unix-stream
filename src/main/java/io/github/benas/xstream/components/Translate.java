package io.github.benas.xstream.components;

import io.github.benas.xstream.Stage;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * Replace patterns with expressions in a stream of Strings.
 *
 * @author Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 */
public class Translate implements Stage<String, String> {

    private String regexp;

    private String replacement;

    /**
     * Create a new {@link Translate} instance.
     *
     * @param regexp      the regexp to look for
     * @param replacement the replacement to apply
     */
    public Translate(final String regexp, final String replacement) {
        Objects.requireNonNull("regexp must not be null");
        Objects.requireNonNull("replacement must not be null");
        this.regexp = regexp;
        this.replacement = replacement;
    }

    /**
     * Create a new {@link Translate} instance.
     *
     * @param regexp      the regexp to look for
     * @param replacement the replacement to apply
     * @return a new {@link Translate} instance.
     */
    public static Translate tr(final String regexp, final String replacement) {
        return new Translate(regexp, replacement);
    }

    @Override
    public Stream<String> apply(Stream<String> input) {
        return input.map(s -> s.replaceAll(regexp, replacement));
    }
}
