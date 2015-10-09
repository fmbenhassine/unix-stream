package io.github.benas.xstream.components;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.github.benas.xstream.Predicates.contains;
import static org.assertj.core.api.Assertions.assertThat;

public class ExcludeTest {

    private Stream<String> stream;

    private Exclude<String> exclude;

    @Before
    public void setUp() {
        stream = Stream.of("a", "ab", "bc");
        exclude = Exclude.exclude(contains("a"));
    }

    @Test
    public void apply() {
        List<String> strings = exclude.apply(stream).collect(Collectors.toList());

        assertThat(strings).isNotEmpty().hasSize(1).containsExactly("bc");
    }
}
