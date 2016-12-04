package io.github.benas.unixstream.components;

import io.github.benas.unixstream.UnixStream;
import org.junit.After;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class RmTest {

    private Path foo = Paths.get("target/foo.txt");

    @Test
    public void rm() throws IOException {
        Files.createFile(foo);
        assertThat(foo).exists();

        UnixStream.rm(foo);

        assertThat(foo).doesNotExist();
    }

    @After
    public void tearDown() throws IOException {
        Files.deleteIfExists(foo);
    }
}
