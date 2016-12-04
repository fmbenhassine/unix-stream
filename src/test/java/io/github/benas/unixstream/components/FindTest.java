package io.github.benas.unixstream.components;

import io.github.benas.unixstream.UnixStream;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class FindTest {

    private static final String TEST_RESOURCES_DIRECTORY = "src/test/resources";

    @Test
    public void find_whenFilesExist() throws Exception {
        UnixStream<Path> stream = UnixStream.find(Paths.get(TEST_RESOURCES_DIRECTORY), "*.txt");

        assertThat(stream).containsExactly(Paths.get(TEST_RESOURCES_DIRECTORY, "input.txt"));
    }

    @Test
    public void find_whenNoFileExist() throws Exception {
        UnixStream<Path> stream = UnixStream.find(Paths.get(TEST_RESOURCES_DIRECTORY), "*.blah");

        assertThat(stream).isEmpty();
    }

}
