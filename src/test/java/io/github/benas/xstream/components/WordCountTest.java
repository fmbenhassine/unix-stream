package io.github.benas.xstream.components;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class WordCountTest {

    private Stream<String> stream;

    private WordCount wordCount;

    @Before
    public void setUp() {
        stream = Stream.of("Hello World!", "How are you?");
    }

    @Test
    public void apply_whenCountWords() {
        wordCount = WordCount.wordCount();
        
        List<String> strings = wordCount.apply(stream).collect(Collectors.toList());

        Assertions.assertThat(strings).isNotEmpty().hasSize(1).containsExactly("5");
    }

    @Test
    public void apply_whenCountLines() {
        wordCount = WordCount.wordCount(WordCount.WordCountOption.L);
        
        List<String> strings = wordCount.apply(stream).collect(Collectors.toList());

        Assertions.assertThat(strings).isNotEmpty().hasSize(1).containsExactly("2");
    }
}