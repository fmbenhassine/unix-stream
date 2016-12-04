package io.github.benas.unixstream.components;

import io.github.benas.unixstream.UnixStream;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Dos2UnixTest {

    private Stream<String> stream;

    private Dos2Unix dos2Unix;

    @Before
    public void setUp() {
        stream = Stream.of("a\r\n", "b\r\nc\r\n");
        dos2Unix = Dos2Unix.dos2unix();
    }

    @Test
    public void apply() {
        List<String> strings = dos2Unix.apply(stream).collect(Collectors.toList());

        assertThat(strings).containsExactly("a\n", "b\nc\n");
    }

    @Test
    public void dos2unix() throws Exception {
        UnixStream<String> unixStream = UnixStream.unixify(stream).dos2unix();

        assertThat(unixStream).containsExactly("a\n", "b\nc\n");
    }
}
