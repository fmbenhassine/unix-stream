package io.github.benas.xstream.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Before;
import org.junit.Test;

public class HeadTest {

    private Stream<String> stream;
    
    private Head<String> head;
    
    @Before
    public void setUp() {
        stream = Stream.of("a", "b", "c");
        head = Head.head(2);
    }

    @Test
    public void apply() {
        List<String> strings = head.apply(stream).collect(Collectors.toList());

        assertThat(strings).isNotEmpty().hasSize(2).containsExactly("a", "b");
    }
}