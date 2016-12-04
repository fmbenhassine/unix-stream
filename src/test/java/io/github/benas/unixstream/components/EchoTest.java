package io.github.benas.unixstream.components;

import io.github.benas.unixstream.UnixStream;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class EchoTest {

    @Test
    public void echo() throws IOException {
        UnixStream<String> stream = UnixStream.echo("hello");

        assertThat(stream).containsExactly("hello");
    }
}
