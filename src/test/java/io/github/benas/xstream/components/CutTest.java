package io.github.benas.xstream.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Before;

public class CutTest {

    private Stream<String> stream;

    private Cut cut;

    @Before
    public void setUp() {
        stream = Stream.of("a;b", "c;d");
        cut = Cut.cut(";", 2);
    }

    @org.junit.Test
    public void apply() {
        List<String> strings = cut.apply(stream).collect(Collectors.toList());
        
        assertThat(strings).isNotEmpty().isEqualTo(Arrays.asList("b", "d"));
    }
}