package io.github.benas.unixstream.components;

import io.github.benas.unixstream.UnixStream;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CompactTest {

    private Stream<String> stream;

    private Compact compact;

    @Before
    public void setUp() {
        stream = Stream.of("a  b", "c\td");
        compact = Compact.compact();
    }

    @org.junit.Test
    public void apply() {
        List<String> strings = compact.apply(stream).collect(Collectors.toList());

        assertThat(strings).containsExactly("ab", "cd");
    }

    @Test
    public void compact() throws Exception {
        UnixStream<String> unixStream = UnixStream.from(Stream.of(" f o o ")).compact();

        assertThat(unixStream).containsExactly("foo");
    }
}
