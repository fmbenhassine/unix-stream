package io.github.benas.unixstream.components;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

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

        Assertions.assertThat(strings).isNotEmpty().hasSize(2).containsExactly("A", "B");
    }
}
