package io.github.benas.unixstream.components;

import io.github.benas.unixstream.UnixStream;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class UpperCaseTest {

    private Stream<String> stream;

    private UpperCase upperCase;

    @Before
    public void setUp() {
        stream = Stream.of("a", "B");
        upperCase = UpperCase.uppercase();
    }

    @Test
    public void apply() {
        List<String> strings = upperCase.apply(stream).collect(Collectors.toList());

        assertThat(strings).containsExactly("A", "B");
    }

    @Test
    public void uppercase() {
        UnixStream<String> unixStream = UnixStream.unixify(stream).uppercase();

        assertThat(unixStream).containsExactly("A", "B");
    }
}
