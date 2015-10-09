package io.github.benas.xstream.components;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.github.benas.xstream.components.WordCount.Option.L;

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

        Assertions.assertThat(strings).isNotEmpty().hasSize(1).containsExactly("5");
    }

    @Test
    public void apply_whenCountLines() {
        wc = WordCount.wc(L);

        List<String> strings = wc.apply(stream).collect(Collectors.toList());

        Assertions.assertThat(strings).isNotEmpty().hasSize(1).containsExactly("2");
    }
}
