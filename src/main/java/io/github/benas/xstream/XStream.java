package io.github.benas.xstream;

import io.github.benas.xstream.components.WordCount;

import java.io.*;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.nio.file.Files.lines;

public interface XStream<T> extends Stream<T> {

    /*
     * Input stream methods
     */
    static <T> XStream<T> unixify(Stream<T> stream) {
        return new XStreamImpl<>(stream);
    }

    static <T> XStream<T> from(Stream<T> stream) {
        return new XStreamImpl<>(stream);
    }

    static XStream<String> ls() throws IOException {
        return ls(Paths.get("").toFile().getAbsolutePath());
    }

    static XStream<String> ls(String directory) throws IOException {
        File[] files = new File(directory).listFiles();
        if (files != null) {
            return new XStreamImpl<>(Arrays.stream(files).map(File::getName));
        }
        return new XStreamImpl<>(Stream.empty());
    }

    static XStream<String> cat() throws IOException {
        return new XStreamImpl<>(Stream.generate(new StandardInputSupplier()));
    }
    
    static XStream<String> cat(String filePath) throws IOException {
        return new XStreamImpl<>(lines(Paths.get(filePath)));
    }

    static XStream<String> concat(Stream<String> stream1, Stream<String> stream2) throws IOException {
        return new XStreamImpl<>(Stream.concat(stream1, stream2));
    }

    static XStream<String> echo(String input) {
        return new XStreamImpl<>(Stream.of(input));
    }

    static XStream<String> pwd(String input) {
        return new XStreamImpl<>(Stream.of(Paths.get("").toFile().getAbsolutePath()));
    }
    
    /*
     * Output stream methods 
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

    void to(PrintWriter printWriter) throws IOException;

    /*
     * Additional commands
     */
    
    <R> XStream<R> pipe(Stage<T, R> stage);
    
    XStream<String> compact();
    
    XStream<String> cut(String delimiter, int field);

    XStream<String> dos2unix();

    XStream<T> exclude(Predicate<T> predicate);
    
    XStream<String> expand();
    
    XStream<String> fold(int size);

    XStream<String> grep(String pattern);
    
    XStream<T> head();

    XStream<T> head(long size);
    
    XStream<String> lowercase();

    XStream<String> nl();
    
    XStream<T> reverse();

    XStream<T> sort();

    XStream<T> sort(Comparator<? super T> comparator);

    XStream<String> str();

    XStream<T> tail();

    XStream<T> tail(long size);

    XStream<String> tr(String regexp, String replacement);
    
    XStream<String> trim();
    
    XStream<String> trunc(int size);

    XStream<String> unexpand();

    XStream<T> uniq();

    XStream<String> uppercase();

    XStream<String> wc();

    XStream<String> wc(WordCount.Option option);

    Stream<T> get();

    /*
     * Inherited methods
     */
    
    @Override
    XStream<T> sorted();
    
    @Override
    XStream<T> sorted(Comparator<? super T> comparator);

    @Override
    XStream<T> distinct();

    @Override
    XStream<T> filter(Predicate<? super T> predicate);

    @Override
    <R> XStream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper);

    @Override
    XStream<T> limit(long maxSize);

    @Override
    <R> XStream<R> map(Function<? super T, ? extends R> mapper);

    @Override
    XStream<T> peek(Consumer<? super T> action);

    @Override
    XStream<T> skip(long n);

    @Override
    XStream<T> parallel();

    @Override
    XStream<T> sequential();

}
