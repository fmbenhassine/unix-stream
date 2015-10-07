package io.github.benas.xstream.components;

import java.util.stream.Stream;

import io.github.benas.xstream.Stage;

public class UnExpand implements Stage<String, String> {

    public UnExpand() {
    }

    public static UnExpand unexpand() {
        return new UnExpand();
    }
    
    @Override
    public Stream<String> apply(Stream<String> input) {
        return input.map(s -> s.replaceAll(" ","\t"));
    }
    
}
