package io.github.benas.ustream.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Before;

public class UnExpandTest {

    private Stream<String> stream;

    private UnExpand unExpand;

    @Before
    public void setUp() {
        stream = Stream.of("a b", "c  d");
        unExpand = UnExpand.unexpand();
        
    }

    @org.junit.Test
    public void apply() {
        List<String> strings = unExpand.apply(stream).collect(Collectors.toList());
        
        assertThat(strings).isNotEmpty().isEqualTo(Arrays.asList("a\tb", "c\t\td"));
    }
}
