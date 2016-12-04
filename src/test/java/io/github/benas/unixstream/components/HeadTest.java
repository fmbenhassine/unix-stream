package io.github.benas.unixstream.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.github.benas.unixstream.UnixStream;
import org.junit.Test;

public class HeadTest {

    private Stream<String> stream;
    
    private Head<String> head;

    @Test
    public void apply() {
        stream = Stream.of("a", "b", "c");
        head = Head.head(2);

        List<String> strings = head.apply(stream).collect(Collectors.toList());

        assertThat(strings).containsExactly("a", "b");
    }

    @Test
    public void apply_withDefaultSize() {
        stream = Stream.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n");
        head = Head.head();

        List<String> strings = head.apply(stream).collect(Collectors.toList());

        assertThat(strings).containsExactly("a", "b", "c", "d", "e", "f", "g", "h", "i", "j");
    }

    @Test
    public void head() throws Exception {
        stream = Stream.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n");

        UnixStream<String> unixStream = UnixStream.unixify(stream).head();

        assertThat(unixStream).containsExactly("a", "b", "c", "d", "e", "f", "g", "h", "i", "j");
    }
}
