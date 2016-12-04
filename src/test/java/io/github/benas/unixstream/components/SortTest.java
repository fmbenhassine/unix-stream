package io.github.benas.unixstream.components;

import io.github.benas.unixstream.UnixStream;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SortTest {

    private Stream<String> stream;

    private Sort<String> sort;

    @Before
    public void setUp() {
        stream = Stream.of("b", "c", "d", "a");
        sort = Sort.sort();
    }

    @Test
    public void apply() {
        List<String> strings = sort.apply(stream).collect(Collectors.toList());

        assertThat(strings).isNotEmpty().hasSize(4).containsExactly("a", "b", "c", "d");
    }

    @Test
    public void sort_withComparator() throws Exception {
        Stream<Integer> stream = Stream.of(1, 2, 3);

        UnixStream<Integer> unixStream = UnixStream.unixify(stream).sort(Comparator.reverseOrder());

        assertThat(unixStream).containsExactly(3, 2, 1);
    }
}
