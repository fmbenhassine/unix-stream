package io.github.benas.unixstream.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Before;
import org.junit.Test;

public class UniqTest {

    private Stream<String> stream;

    private Uniq<String> uniq;

    @Before
    public void setUp() {
        stream = Stream.of("a", "a", "b", "b");
        uniq = Uniq.uniq();
    }

    @Test
    public void apply() {
        List<String> strings = uniq.apply(stream).collect(Collectors.toList());

        assertThat(strings).isNotEmpty().hasSize(2).containsExactly("a", "b");
    }
}
