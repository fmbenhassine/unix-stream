package io.github.benas.unixstream.components;

import io.github.benas.unixstream.UnixStream;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.github.benas.unixstream.components.WordCount.Option.L;
import static org.assertj.core.api.Assertions.assertThat;

public class WordCountTest {

    private Stream<String> stream;

    private WordCount wc;

    @Before
    public void setUp() {
        stream = Stream.of("Hello World!", "How are you?");
    }

    @Test
    public void apply_whenCountWords() {
        wc = WordCount.wc();

        List<String> strings = wc.apply(stream).collect(Collectors.toList());

        assertThat(strings).containsExactly("5");
    }

    @Test
    public void apply_whenCountLines() {
        wc = WordCount.wc(L);

        List<String> strings = wc.apply(stream).collect(Collectors.toList());

        assertThat(strings).containsExactly("2");
    }

    @Test
    public void wc() throws Exception {
        UnixStream<String> unixStream = UnixStream.unixify(stream).wc();

        assertThat(unixStream).containsExactly("2");
    }
}
