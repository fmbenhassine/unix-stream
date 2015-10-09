package io.github.benas.xstream.components;

import io.github.benas.xstream.Stage;

import java.util.Objects;
import java.util.stream.Stream;

public class Translate implements Stage<String, String> {
    
    private String regexp;
    
    private String replacement;

    public Translate(final String regexp, final String replacement) {
        Objects.requireNonNull("regexp must not be null");
        Objects.requireNonNull("replacement must not be null");
        this.regexp = regexp;
        this.replacement = replacement;
    }

    public static Translate tr(final String regexp, final String replacement) {
        return new Translate(regexp, replacement);
    }

    @Override
    public Stream<String> apply(Stream<String> input) {
        return input.map(s -> s.replaceAll(regexp, replacement));
    }
}
