package io.github.benas.unixstream.components;

import io.github.benas.unixstream.UnixStream;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class TruncateTest {

    private Stream<String> stream;

    private Truncate truncate;

    @Before
    public void setUp() {
        stream = Stream.of("abcd", "efgh");
        truncate = Truncate.trunc(2);
    }

    @Test
    public void apply() {
        List<String> strings = truncate.apply(stream).collect(Collectors.toList());

        assertThat(strings).containsExactly("ab", "ef");
    }

    @Test
    public void trunc() {
        UnixStream<String> unixStream = UnixStream.unixify(stream).trunc(2);

        assertThat(unixStream).containsExactly("ab", "ef");
    }
}
