package io.github.benas.unixstream.components;

import io.github.benas.unixstream.UnixStream;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class CatTest {

    private static final String TEST_RESOURCES_DIRECTORY = "src/test/resources";

    @Test
    public void cat() throws IOException {
        UnixStream<String> unixStream = UnixStream.cat(Paths.get(TEST_RESOURCES_DIRECTORY, "input.txt"));

        assertThat(unixStream).containsExactly("1,foo", "2,bar");
    }
}
