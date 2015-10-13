package io.github.benas.ustream.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Before;
import org.junit.Test;

public class SortTest {

    private Stream<String> stream;

    private Sort<String> sort;

    @Before
    public void setUp() {
        stream = Stream.of("b", "c", "d", "a");
        sort = Sort.sort();
    }

    @Test
    public void apply() {
        List<String> strings = sort.apply(stream).collect(Collectors.toList());

        assertThat(strings).isNotEmpty().hasSize(4).containsExactly("a", "b", "c", "d");
    }
}
