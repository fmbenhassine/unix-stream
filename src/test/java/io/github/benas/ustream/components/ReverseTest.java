package io.github.benas.ustream.components;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class ReverseTest {

    private Stream<String> stream;

    private Reverse<String> reverse;

    @Before
    public void setUp() {
        stream = Stream.of("a", "b", "c");
        reverse = Reverse.reverse();
    }

    @Test
    public void apply() {
        List<String> strings = reverse.apply(stream).collect(Collectors.toList());

        Assertions.assertThat(strings).isNotEmpty().hasSize(3).containsExactly("c", "b", "a");
    }
}
