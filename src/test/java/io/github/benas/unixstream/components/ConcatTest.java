package io.github.benas.unixstream.components;

import io.github.benas.unixstream.UnixStream;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ConcatTest {

    private Stream<String> stream;

    private Concat<String> concat;

    @Before
    public void setUp() throws Exception {
        stream = Stream.of("a", "b");
        concat = Concat.concat(Stream.of("c", "d"));
    }

    @Test
    public void apply() throws Exception {
        List<String> strings = concat.apply(stream).collect(Collectors.toList());

        assertThat(strings).containsExactly("a", "b", "c", "d");
    }

    @Test
    public void concatWithAnotherStream() throws Exception {
        Stream<String> stream1 = Stream.of("foo");
        Stream<String> stream2 = Stream.of("bar");

        UnixStream<String> stream = UnixStream.unixify(stream1).concat(stream2);

        assertThat(stream).containsExactly("foo", "bar");
    }

    @Test
    public void concatTwoStreams() throws Exception {
        Stream<String> stream1 = Stream.of("foo");
        Stream<String> stream2 = Stream.of("bar");

        UnixStream<String> stream = UnixStream.concat(stream1, stream2);

        assertThat(stream).containsExactly("foo", "bar");
    }
}
