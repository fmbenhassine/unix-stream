package io.github.benas.unixstream.components;

import io.github.benas.unixstream.UnixStream;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class WeekTest {

    @Test
    public void week() throws IOException {
        UnixStream<String> stream = UnixStream.week();

        List<String> strings = stream.collect(Collectors.toList());
        assertThat(strings).hasSize(1);
        int week = Integer.parseInt(strings.get(0));

        assertThat(week).isBetween(1, 52);
    }
}
