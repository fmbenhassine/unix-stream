package io.github.benas.unixstream.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Before;
import org.junit.Test;

public class StringifyTest {

    private Stream<Integer> stream;

    private Stringify<Integer> stringify;

    @Before
    public void setUp() {
        stream = Stream.of(1, 2, 3);
        stringify = Stringify.stringify();
    }

    @Test
    public void apply() {
        List<String> strings = stringify.apply(stream).collect(Collectors.toList());

        assertThat(strings).isNotEmpty().hasSize(3).containsExactly("1", "2", "3");
    }
}
