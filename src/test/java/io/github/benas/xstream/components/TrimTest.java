package io.github.benas.xstream.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Before;
import org.junit.Test;

public class TrimTest {

    private Stream<String> stream;

    private Trim trim;

    @Before
    public void setUp() {
        stream = Stream.of("    a ", " b    ");
        trim = Trim.trim();
    }

    @Test
    public void apply() {
        List<String> strings = trim.apply(stream).collect(Collectors.toList());

        assertThat(strings).isNotEmpty().hasSize(2).containsExactly("a", "b");
    }
}