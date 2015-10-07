package io.github.benas.xstream;

import java.util.stream.Stream;

public interface Stage<I, O> {

    Stream<O> apply(Stream<I> input);

}
