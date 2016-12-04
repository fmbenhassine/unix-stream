package io.github.benas.unixstream.components;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.github.benas.unixstream.UnixStream;
import org.junit.Before;
import org.junit.Test;

public class FoldTest {

    private Stream<String> stream;
    
    private Fold fold;
    
    @Before
    public void setUp() {
        stream = Stream.of("abc", "def");
    }

    @Test
    public void apply() {
        fold = Fold.fold(2);

        List<String> strings = fold.apply(stream).collect(Collectors.toList());

        assertThat(strings).isNotEmpty().hasSize(2).containsExactly(
                "ab" + Fold.LINE_SEPARATOR + "c",
                "de" + Fold.LINE_SEPARATOR + "f"
        );
    }

    @Test
    public void apply_withDefaultSize() throws Exception {
        stream = Stream.of("We need a 80+ characters string for this test: ooooooooooooooooooooooooooooooook?");
        fold = Fold.fold();

        List<String> strings = fold.apply(stream).collect(Collectors.toList());

        assertThat(strings).isNotEmpty().hasSize(1)
                .containsExactly(
                "We need a 80+ characters string for this test: ooooooooooooooooooooooooooooooook"
                        + Fold.LINE_SEPARATOR + "?");
    }

    @Test
    public void fold() throws Exception {
        UnixStream<String> unixStream = UnixStream.from(stream).fold(2);

        assertThat(unixStream).containsExactly(
                "ab" + Fold.LINE_SEPARATOR + "c",
                "de" + Fold.LINE_SEPARATOR + "f"
        );
    }
}
