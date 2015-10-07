package io.github.benas.xstream;

import static io.github.benas.xstream.XStream.file;
import static io.github.benas.xstream.components.Grep.grep;
import static io.github.benas.xstream.components.NumberLines.numberLines;
import static io.github.benas.xstream.components.Sort.sort;
import static io.github.benas.xstream.components.Uniq.uniq;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Before;
import org.junit.Test;

public class XStreamImplTest {

    private Stream<String> stream;

    @Before
    public void setUp() {
        stream = Stream.of("id,name", "1,foo", "2,bar");
    }

    @Test
    public void integrationTest1() throws IOException {
        List<String> strings = XStream.unixify(stream)
                .grep("bar")
                .cut(",", 2)
                .sort()
                .uniq()
                .nl()
                .collect(Collectors.toList());

        assertThat(strings).isNotEmpty().isEqualTo(singletonList("1 bar"));
    }

    @Test
    public void integrationTest2() throws IOException {
        // cat input.txt | grep a | sort | uniq | nl > output.txt
        XStream.cat("src/test/resources/input.txt")
                .pipe(grep("a"))
                .pipe(sort())
                .pipe(uniq())
                .pipe(numberLines())
                .to(file("target/output.txt"));

        assertThat(new File("target/output.txt")).exists().hasContent("1 2,bar");
    }


}