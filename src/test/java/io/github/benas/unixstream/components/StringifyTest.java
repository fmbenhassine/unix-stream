package io.github.benas.unixstream.components;

import io.github.benas.unixstream.UnixStream;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StringifyTest {

    private Stream<Integer> stream;

    private Stringify<Integer> stringify;

    @Before
    public void setUp() {
        stream = Stream.of(1, 2, 3);
        stringify = Stringify.stringify();
    }

    @Test
    public void apply() {
        List<String> strings = stringify.apply(stream).collect(Collectors.toList());

        assertThat(strings).containsExactly("1", "2", "3");
    }

    @Test
    public void str() throws Exception {
        UnixStream<String> unixStream = UnixStream.unixify(stream).str();

        assertThat(unixStream).containsExactly("1", "2", "3");
    }
}
