package io.github.benas.unixstream.components;

import io.github.benas.unixstream.UnixStream;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

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

        assertThat(strings).containsExactly("a");
    }

    @Test
    public void grep() throws Exception {
        UnixStream<String> unixStream = UnixStream.unixify(stream).grep("a");

        assertThat(unixStream).containsExactly("a");
    }
}
