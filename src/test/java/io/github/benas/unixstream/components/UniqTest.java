package io.github.benas.unixstream.components;

import io.github.benas.unixstream.UnixStream;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class UniqTest {

    private Stream<String> stream;

    private Uniq<String> uniq;

    @Before
    public void setUp() {
        stream = Stream.of("a", "a", "b", "b");
        uniq = Uniq.uniq();
    }

    @Test
    public void apply() {
        List<String> strings = uniq.apply(stream).collect(Collectors.toList());

        assertThat(strings).containsExactly("a", "b");
    }

    @Test
    public void uniq() throws Exception {
        UnixStream<String> unixStream = UnixStream.unixify(stream).uniq();

        assertThat(unixStream).containsExactly("a", "b");
    }
}
