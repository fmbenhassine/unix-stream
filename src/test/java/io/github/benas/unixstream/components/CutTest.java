package io.github.benas.unixstream.components;

import io.github.benas.unixstream.UnixStream;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CutTest {

    private Stream<String> stream;

    private Cut cut;

    @Before
    public void setUp() {
        stream = Stream.of("a;b", "c;d");
        cut = Cut.cut(";", 2);
    }

    @Test(expected = NullPointerException.class)
    public void create_whenDelimiterIsNull() {
        Cut.cut(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void create_whenFiledIsLessThanOne() {
        Cut.cut(";", 0);
    }

    @Test
    public void apply() {
        List<String> strings = cut.apply(stream).collect(Collectors.toList());

        assertThat(strings).containsExactly("b", "d");
    }

    @Test
    public void apply_whenFieldIsOutOfRange() {
        cut = Cut.cut(";", 3);
        List<String> strings = cut.apply(stream).collect(Collectors.toList());

        assertThat(strings).containsExactly("", "");
    }

    @Test
    public void cut() throws Exception {
        UnixStream<String> unixStream = UnixStream.unixify(stream).cut(";", 2);
        
        assertThat(unixStream).containsExactly("b", "d");
    }
}
