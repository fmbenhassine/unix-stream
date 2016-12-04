package io.github.benas.unixstream.components;

import io.github.benas.unixstream.UnixStream;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class LsTest {

    @Test
    public void ls() throws IOException {
        UnixStream<Path> stream = UnixStream.ls();

        assertThat(stream).contains(
                Paths.get(".gitignore"),
                Paths.get(".travis.yml"),
                Paths.get("LICENSE.txt"),
                Paths.get("pom.xml"),
                Paths.get("README.md"),
                Paths.get("src"),
                Paths.get("target"),
                Paths.get("unix-stream.jpeg")
        );
    }

    @Test
    public void ls_directory() throws IOException {
        UnixStream<Path> stream = UnixStream.ls("src/test/resources");

        assertThat(stream).contains(Paths.get("src/test/resources","input.txt"));
    }
}
