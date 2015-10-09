package io.github.benas.xstream;

import io.github.benas.xstream.components.WordCount;

import java.io.*;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.nio.file.Files.lines;

public interface XStream<T> extends Stream<T> {

    /*
     * static factory methods to create xstreams
     */

    static XStream<String> cat() throws IOException {
        return new XStreamImpl<>(Stream.generate(new StandardInputSupplier()));
    }

    static XStream<String> cat(final String filePath) throws IOException {
        Objects.requireNonNull(filePath, "The file path must not be null");
        return new XStreamImpl<>(lines(Paths.get(filePath)));
    }

    static XStream<String> concat(final Stream<String> stream1, final Stream<String> stream2) throws IOException {
        Objects.requireNonNull(stream1, "The first stream must not be null");
        Objects.requireNonNull(stream2, "The second stream must not be null");
        return new XStreamImpl<>(Stream.concat(stream1, stream2));
    }

    static XStream<String> echo(final String input) {
        Objects.requireNonNull(input, "The input must not be null");
        return new XStreamImpl<>(Stream.of(input));
    }

    static <T> XStream<T> from(final Stream<T> stream) {
        Objects.requireNonNull(stream, "The input stream must not be null");
        return new XStreamImpl<>(stream);
    }

    static XStream<String> ls() throws IOException {
        return ls(Paths.get("").toFile().getAbsolutePath());
    }

    static XStream<String> ls(final String directory) throws IOException {
        Objects.requireNonNull(directory, "The directory must not be null");
        File[] files = new File(directory).listFiles();
        if (files != null) {
            return new XStreamImpl<>(Arrays.stream(files).map(File::getName));
        }
        return new XStreamImpl<>(Stream.empty());
    }

    static XStream<String> pwd() {
        return new XStreamImpl<>(Stream.of(Paths.get("").toFile().getAbsolutePath()));
    }

    static <T> XStream<T> unixify(final Stream<T> stream) {
        Objects.requireNonNull(stream, "The input stream must not be null");
        return new XStreamImpl<>(stream);
    }
    
    /*
     * Static factory methods to create print writers. 
     */
    
    static PrintWriter stdOut() {
        return new PrintWriter(new OutputStreamWriter(System.out), true);
    }

    static PrintWriter stdErr() {
        return new PrintWriter(new OutputStreamWriter(System.err), true);
    }

    static PrintWriter file(String filePath) throws IOException {
        return new PrintWriter(new FileWriter(filePath), true);
    }

    /*
     * XStream methods
     */
    
    XStream<String> compact();

    XStream<String> cut(final String delimiter, final int field);

    XStream<String> dos2unix();

    XStream<T> exclude(final Predicate<T> predicate);
    
    XStream<String> expand();

    XStream<String> fold(final int size);

    Stream<T> get();

    XStream<String> grep(final String pattern);
    
    XStream<T> head();

    XStream<T> head(final long size);
    
    XStream<String> lowercase();

    XStream<String> nl();

    <R> XStream<R> pipe(final Stage<T, R> stage);
    
    XStream<T> reverse();

    XStream<T> sort();

    XStream<T> sort(final Comparator<? super T> comparator);

    XStream<String> str();

    XStream<T> tail();

    XStream<T> tail(final long size);

    XStream<String> tr(final String regexp, final String replacement);
    
    XStream<String> trim();

    XStream<String> trunc(final int size);

    XStream<String> unexpand();

    XStream<T> uniq();

    XStream<String> uppercase();

    XStream<String> wc();

    XStream<String> wc(final WordCount.Option option);

    void to(final PrintWriter printWriter) throws IOException;

}
