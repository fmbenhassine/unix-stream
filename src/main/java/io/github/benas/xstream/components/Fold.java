package io.github.benas.xstream.components;

import java.util.stream.Stream;

import io.github.benas.xstream.Stage;

public class Fold implements Stage<String, String> {

    public static String LINE_SEPARATOR = System.getProperty("line.separator");
    
    public static int DEFAULT_WIDTH = 80;

    private int width;

    public Fold() {
        this(DEFAULT_WIDTH);
    }

    public Fold(int width) {
        if (width < 1) {
            throw new IllegalArgumentException("Width must be >= 1");
        }
        this.width = width;
    }

    public static Fold fold() {
        return new Fold();
    }

    public static Fold fold(int width) {
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
