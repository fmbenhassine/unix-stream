package io.github.benas.xstream.components;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class NumberLinesTest {

    private Stream<String> stream;

    private NumberLines numberLines;

    @Before
    public void setUp() {
        stream = Stream.of("a", "b");
        numberLines = NumberLines.numberLines();
    }

    @Test
    public void apply() {
        List<String> strings = numberLines.apply(stream).collect(Collectors.toList());

        Assertions.assertThat(strings).isNotEmpty().hasSize(2).containsExactly("1 a", "2 b");
    }
}