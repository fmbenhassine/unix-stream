package io.github.benas.unixstream.components;

import io.github.benas.unixstream.UnixStream;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberLinesTest {

    private Stream<String> stream;

    private NumberLines numberLines;

    @Before
    public void setUp() {
        stream = Stream.of("a", "b");
        numberLines = NumberLines.nl();
    }

    @Test
    public void apply() {
        List<String> strings = numberLines.apply(stream).collect(Collectors.toList());

        assertThat(strings).containsExactly("1 a", "2 b");
    }

    @Test
    public void nl() throws Exception {
        UnixStream<String> unixStream = UnixStream.unixify(stream).nl();

        assertThat(unixStream).containsExactly("1 a", "2 b");
    }
}
