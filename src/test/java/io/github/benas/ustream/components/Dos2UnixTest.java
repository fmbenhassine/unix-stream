package io.github.benas.ustream.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Before;
import org.junit.Test;

public class Dos2UnixTest {

    private Stream<String> stream;

    private Dos2Unix dos2Unix;

    @Before
    public void setUp() {
        stream = Stream.of("a\r\n", "b\r\nc\r\n");
        dos2Unix = Dos2Unix.dos2unix();
    }

    @Test
    public void apply() {
        List<String> strings = dos2Unix.apply(stream).collect(Collectors.toList());

        assertThat(strings).isNotEmpty().hasSize(2).containsExactly("a\n", "b\nc\n");
    }
}
