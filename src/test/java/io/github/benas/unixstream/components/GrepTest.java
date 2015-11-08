package io.github.benas.unixstream.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Before;
import org.junit.Test;

public class GrepTest {

    private Stream<String> stream;
    
    private Grep grep;
    
    @Before
    public void setUp() {
        stream = Stream.of("a", "b");
        grep = Grep.grep("a");
    }

    @Test
    public void apply() {
        List<String> strings = grep.apply(stream).collect(Collectors.toList());

        assertThat(strings).isNotEmpty().hasSize(1).containsExactly("a");
    }
}
