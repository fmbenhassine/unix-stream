package io.github.benas.unixstream.components;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

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

        Assertions.assertThat(strings).isNotEmpty().hasSize(2).containsExactly("a", "b");
    }
}
