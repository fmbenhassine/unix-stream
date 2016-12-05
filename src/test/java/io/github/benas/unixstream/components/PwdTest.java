package io.github.benas.unixstream.components;

import io.github.benas.unixstream.UnixStream;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class PwdTest {

    @Test
    public void pwd() throws IOException {
        UnixStream<Path> stream = UnixStream.pwd();

        List<Path> paths = stream.collect(Collectors.toList());

        assertThat(paths.get(0).toString()).contains("unix-stream");
    }

}
