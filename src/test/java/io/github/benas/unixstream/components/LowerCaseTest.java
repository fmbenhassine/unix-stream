package io.github.benas.unixstream.components;

import io.github.benas.unixstream.UnixStream;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LowerCaseTest {

    private Stream<String> stream;

    private LowerCase lowerCase;

    @Before
    public void setUp() {
        stream = Stream.of("A", "b");
        lowerCase = LowerCase.lowerCase();
    }

    @Test
    public void apply() {
        List<String> strings = lowerCase.apply(stream).collect(Collectors.toList());

        assertThat(strings).containsExactly("a", "b");
    }

    @Test
    public void lowercase() throws Exception {
        UnixStream<String> unixStream = UnixStream.unixify(stream).lowercase();

        assertThat(unixStream).containsExactly("a", "b");
    }
}
