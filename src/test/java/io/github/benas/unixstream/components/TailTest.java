package io.github.benas.unixstream.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.github.benas.unixstream.UnixStream;
import org.junit.Test;

public class TailTest {

    private Stream<String> stream;

    private Tail<String> tail;

    @Test
    public void apply() {
        stream = Stream.of("a", "b", "c", "d");
        tail = Tail.tail(2);

        List<String> strings = tail.apply(stream).collect(Collectors.toList());

        assertThat(strings).containsExactly("c", "d");
    }

    @Test
    public void apply_withDefaultSize() {
        stream = Stream.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l");
        tail = Tail.tail();

        List<String> strings = tail.apply(stream).collect(Collectors.toList());

        assertThat(strings).containsExactly("c", "d", "e", "f", "g", "h", "i", "j", "k", "l");
    }

    @Test
    public void tail() throws Exception {
        stream = Stream.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l");

        UnixStream<String> unixStream = UnixStream.unixify(stream).tail();

        assertThat(unixStream).containsExactly("c", "d", "e", "f", "g", "h", "i", "j", "k", "l");
    }
}
