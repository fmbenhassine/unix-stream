package io.github.benas.xstream.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Before;
import org.junit.Test;

public class FoldTest {

    private Stream<String> stream;
    
    private Fold fold;
    
    @Before
    public void setUp() {
        stream = Stream.of("abc", "def");
        fold = Fold.fold(2);
    }

    @Test
    public void apply() {
        List<String> strings = fold.apply(stream).collect(Collectors.toList());

        assertThat(strings).isNotEmpty().hasSize(2).containsExactly(
                "ab" + Fold.LINE_SEPARATOR + "c",
                "de" + Fold.LINE_SEPARATOR + "f"
        );
    }
}