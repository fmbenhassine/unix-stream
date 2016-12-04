package io.github.benas.unixstream.components;

import io.github.benas.unixstream.UnixStream;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class UnExpandTest {

    private Stream<String> stream;

    private UnExpand unExpand;

    @Before
    public void setUp() {
        stream = Stream.of("a b", "c  d");
        unExpand = UnExpand.unexpand();
    }

    @Test
    public void apply() {
        List<String> strings = unExpand.apply(stream).collect(Collectors.toList());

        assertThat(strings).isNotEmpty().isEqualTo(Arrays.asList("a\tb", "c\t\td"));
    }

    @Test
    public void unexpand() {
        UnixStream<String> unixStream = UnixStream.unixify(stream).unexpand();

        assertThat(unixStream).isEqualTo(Arrays.asList("a\tb", "c\t\td"));
    }
}
