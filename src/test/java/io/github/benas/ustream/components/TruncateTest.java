package io.github.benas.ustream.components;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class TruncateTest {

    private Stream<String> stream;

    private Truncate truncate;

    @Before
    public void setUp() {
        stream = Stream.of("abcd", "efgh");
        truncate = Truncate.trunc(2);
    }

    @Test
    public void apply() {
        List<String> strings = truncate.apply(stream).collect(Collectors.toList());

        assertThat(strings).isNotEmpty().hasSize(2).containsExactly("ab", "ef");
    }
}
