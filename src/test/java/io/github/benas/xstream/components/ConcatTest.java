package io.github.benas.xstream.components;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ConcatTest {

    private Stream<String> stream;

    private Concat<String> concat;

    @Before
    public void setUp() throws Exception {
        stream = Stream.of("a", "b");
        concat = Concat.concat(Stream.of("c", "d"));
    }

    @Test
    public void testApply() throws Exception {
        List<String> strings = concat.apply(stream).collect(Collectors.toList());

        assertThat(strings).isNotEmpty().hasSize(4).containsExactly("a", "b", "c", "d");
    }
}
