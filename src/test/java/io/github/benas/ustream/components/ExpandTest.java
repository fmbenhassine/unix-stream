package io.github.benas.ustream.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Before;

public class ExpandTest {

    private Stream<String> stream;

    private Expand expand;

    @Before
    public void setUp() {
        stream = Stream.of("a\tb", "c\t\td");
        expand = Expand.expand();
        
    }

    @org.junit.Test
    public void apply() {
        List<String> strings = expand.apply(stream).collect(Collectors.toList());
        
        assertThat(strings).isNotEmpty().isEqualTo(Arrays.asList("a b", "c  d"));
    }
}
