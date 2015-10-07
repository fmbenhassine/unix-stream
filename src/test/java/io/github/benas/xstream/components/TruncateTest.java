package io.github.benas.xstream.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Before;
import org.junit.Test;

public class TruncateTest {

    private Stream<String> stream;

    private Truncate truncate;

    @Before
    public void setUp() {
        stream = Stream.of("abcd", "efgh");
        truncate = Truncate.truncate(2);
    }

    @Test
    public void apply() {
        List<String> strings = truncate.apply(stream).collect(Collectors.toList());

        assertThat(strings).isNotEmpty().hasSize(2).containsExactly("ab", "ef");
    }
}