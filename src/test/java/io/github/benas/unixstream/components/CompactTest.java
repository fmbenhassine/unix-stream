package io.github.benas.unixstream.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Before;

public class CompactTest {

    private Stream<String> stream;

    private Compact compact;

    @Before
    public void setUp() {
        stream = Stream.of("a  b", "c\td");
        compact = Compact.compact();
    }

    @org.junit.Test
    public void apply() {
        List<String> strings = compact.apply(stream).collect(Collectors.toList());
        
        assertThat(strings).isNotEmpty().isEqualTo(Arrays.asList("ab", "cd"));
    }
}
