package io.github.benas.xstream.components;

import java.util.stream.Stream;
import io.github.benas.xstream.Stage;

public class Translate implements Stage<String, String> {
    
    private String regexp;
    
    private String replacement;

    public Translate(String regexp, String replacement) {
        this.regexp = regexp;
        this.replacement = replacement;
    }

    public static Translate translate(String regexp, String replacement) {
        return new Translate(regexp, replacement);
    }

    @Override
    public Stream<String> apply(Stream<String> input) {
        return input.map(s -> s.replaceAll(regexp, replacement));
    }
}
