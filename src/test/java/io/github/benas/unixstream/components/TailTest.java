package io.github.benas.unixstream.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Before;
import org.junit.Test;

public class TailTest {

    private Stream<String> stream;

    private Tail<String> tail;

    @Before
    public void setUp() {
        stream = Stream.of("a", "b", "c", "d");
        tail = Tail.tail(2);
    }

    @Test
    public void apply() {
        List<String> strings = tail.apply(stream).collect(Collectors.toList());

        assertThat(strings).isNotEmpty().hasSize(2).containsExactly("c", "d");
    }
}
