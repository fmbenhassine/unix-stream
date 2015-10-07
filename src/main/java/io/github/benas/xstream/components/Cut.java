package io.github.benas.xstream.components;

import java.util.function.Function;
import java.util.stream.Stream;

import io.github.benas.xstream.Stage;

public class Cut implements Stage<String, String> {
    
    private String delimiter;

    private int field;

    public Cut(String delimiter, int field) {
        if (field < 1) {
            throw new IllegalArgumentException("Field must be >= 1");
        }
        this.delimiter = delimiter;
        this.field = field - 1;
    }

    public static Cut cut(String delimiter, int field) {
        return new Cut(delimiter, field);
    }

    @Override
    public Stream<String> apply(Stream<String> input) {
        return input.map(new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.split(delimiter)[field];
            }
        });
    }
    
}
