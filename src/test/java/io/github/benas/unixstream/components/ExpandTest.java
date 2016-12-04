package io.github.benas.unixstream.components;

import io.github.benas.unixstream.UnixStream;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpandTest {

    private Stream<String> stream;

    private Expand expand;

    @Before
    public void setUp() {
        stream = Stream.of("a\tb", "c\t\td");
        expand = Expand.expand();
        
    }

    @Test
    public void apply() {
        List<String> strings = expand.apply(stream).collect(Collectors.toList());

        assertThat(strings).containsExactly("a b", "c  d");
    }

    @Test
    public void expand() throws Exception {
        UnixStream<String> unixStream = UnixStream.from(stream).expand();

        assertThat(unixStream).containsExactly("a b", "c  d");
    }
}
