package io.github.benas.unixstream.components;

import io.github.benas.unixstream.UnixStream;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ReverseTest {

    private Stream<String> stream;

    private Reverse<String> reverse;

    @Before
    public void setUp() {
        stream = Stream.of("a", "b", "c");
        reverse = Reverse.reverse();
    }

    @Test
    public void apply() {
        List<String> strings = reverse.apply(stream).collect(Collectors.toList());

        assertThat(strings).containsExactly("c", "b", "a");
    }

    @Test
    public void reverse() throws Exception {
        UnixStream<String> unixStream = UnixStream.unixify(stream).reverse();

        assertThat(unixStream).containsExactly("c", "b", "a");
    }
}
