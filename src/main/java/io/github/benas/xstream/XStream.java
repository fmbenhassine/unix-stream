package io.github.benas.xstream;

import io.github.benas.xstream.components.WordCount;

import java.io.*;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.nio.file.Files.lines;

/**
 * This interface is the main entry point to use XStream.
 * It provides static methods to read/write streams and to operate on them the unix way.
 *
 * @param <T> type of elements in the stream.
 * @author Mahmoud Ben Hassine (mahmoud@benhassine.fr)
 */
public interface XStream<T> extends Stream<T> {

    /*
     * static factory methods to create xstreams
     */

    /**
     * Create a new infinite XStream from the standard input.
     *
     * @return a new infinite XStream from the standard input.
     * @throws IOException thrown if an error occurs during reading the standard input
     */
    static XStream<String> cat() throws IOException {
        return new XStreamImpl<>(Stream.generate(new StandardInputSupplier()));
    }

    /**
     * Create a new XStream of lines of the given file.
     *
     * @param filePath the absolute file path
     * @return a new XStream of lines of the given file.
     * @throws IOException thrown if an error occurs during reading the file
     */
    static XStream<String> cat(final String filePath) throws IOException {
        Objects.requireNonNull(filePath, "The file path must not be null");
        return new XStreamImpl<>(lines(Paths.get(filePath)));
    }

    /**
     * Create a new XStream by concatenating two streams.
     *
     * @param stream1 the first stream
     * @param stream2 the second stream
     * @param <T>     the type of elements in the input streams
     * @return a new XStream instance
     */
    static <T> XStream<T> concat(final Stream<T> stream1, final Stream<T> stream2) {
        Objects.requireNonNull(stream1, "The first stream must not be null");
        Objects.requireNonNull(stream2, "The second stream must not be null");
        return new XStreamImpl<>(Stream.concat(stream1, stream2));
    }

    /**
     * Create a new XStream with the current date.
     *
     * @return a new XStream with the current date.
     */
    static XStream<String> date() {
        return new XStreamImpl<>(Stream.of(new Date().toString()));
    }

    /**
     * Create a new XStream with the given input.
     *
     * @param input the input from which create the stream
     * @return a new XStream with the given input.
     */
    static XStream<String> echo(final String input) {
        Objects.requireNonNull(input, "The input must not be null");
        return new XStreamImpl<>(Stream.of(input));
    }

    /**
     * Create an XStream from a given stream.
     *
     * @param stream the input stream
     * @param <T>    the type of elements in the stream
     * @return a new XStream instance
     */
    static <T> XStream<T> from(final Stream<T> stream) {
        Objects.requireNonNull(stream, "The input stream must not be null");
        return new XStreamImpl<>(stream);
    }

    /**
     * Create an XStream with file names of a the current directory.
     *
     * @return an XStream with file names of the current directory.
     * @throws IOException thrown if an error occurs during reading the current directory
     */
    static XStream<String> ls() throws IOException {
        return ls(Paths.get("").toFile().getAbsolutePath());
    }

    /**
     * Create an XStream with file names of the given directory.
     *
     * @param directory the directory from which to list files
     * @return an XStream with file names of the given directory.
     * @throws IOException thrown if an error occurs during reading the directory
     */
    static XStream<String> ls(final String directory) throws IOException {
        Objects.requireNonNull(directory, "The directory must not be null");
        File[] files = new File(directory).listFiles();
        if (files != null) {
            return new XStreamImpl<>(Arrays.stream(files).map(File::getName));
        }
        return new XStreamImpl<>(Stream.empty());
    }

    /**
     * Create a new XStream with the absolute path of the current directory.
     *
     * @return a new XStream with the absolute path of the current directory.
     */
    static XStream<String> pwd() {
        return new XStreamImpl<>(Stream.of(Paths.get("").toFile().getAbsolutePath()));
    }

    /**
     * Create a new XStream fro the given stream.
     *
     * @param stream the input stream
     * @param <T>    the type of elements in the stream
     * @return a new XStream from the given stream
     */
    static <T> XStream<T> unixify(final Stream<T> stream) {
        Objects.requireNonNull(stream, "The input stream must not be null");
        return new XStreamImpl<>(stream);
    }
    
    /*
     * Static factory methods to create print writers. 
     */

    /**
     * Create a {@link PrintWriter} to the standard output.
     *
     * @return a new {@link PrintWriter} to the standard output
     */
    static PrintWriter stdOut() {
        return new PrintWriter(new OutputStreamWriter(System.out), true);
    }

    /**
     * Create a {@link PrintWriter} to the standard error.
     *
     * @return a new {@link PrintWriter} to the standard error
     */
    static PrintWriter stdErr() {
        return new PrintWriter(new OutputStreamWriter(System.err), true);
    }

    /**
     * Create a {@link PrintWriter} to a file.
     *
     * @param filePath the file path
     * @return a new {@link PrintWriter} to a file.
     * @throws IOException if an error occurs during the creation of the print writer
     */
    static PrintWriter file(String filePath) throws IOException {
        return new PrintWriter(new FileWriter(filePath), true);
    }

    /*
     * XStream methods
     */

    /**
     * Remove all white spaces from a String.
     *
     * @return a new XStream
     */
    XStream<String> compact();

    /**
     * Concat the current stream with another stream.
     *
     * @param stream the stream to concat
     * @return a new XStream
     */
    XStream<T> concat(Stream<T> stream);

    /**
     * Split a String by a delimiter and extract fields.
     *
     * @param delimiter the field delimiter
     * @param field     the index of the field to extract (starting from 1)
     * @return a new XStream
     */
    XStream<String> cut(final String delimiter, final int field);

    /**
     * Replace Windows line separators (CRLF) by Unix line separators (LF).
     *
     * @return a new XStream
     */
    XStream<String> dos2unix();

    /**
     * Exclude elements matching a given predicate from the stream.
     * This is the opposite behavior of {@link Stream#filter(java.util.function.Predicate)}.
     *
     * @param predicate the predicate to apply to each element
     * @return a new XStream
     */
    XStream<T> exclude(final Predicate<T> predicate);

    /**
     * Replace tabs with spaces in a String.
     *
     * @return a new XStream
     */
    XStream<String> expand();

    /**
     * Fold Strings with a given width in a stream of Strings.
     *
     * @param size the folding size
     * @return a new XStream
     */
    XStream<String> fold(final int size);

    /**
     * Unwrap the current stream
     *
     * @return the current stream
     */
    Stream<T> get();

    /**
     * Keep elements containing a given pattern in a stream of Strings.
     *
     * @param pattern the pattern to look for
     * @return a new XStream with selected elements
     */
    XStream<String> grep(final String pattern);

    /**
     * Keep the first 10 elements form the stream.
     *
     * @return a new XStream
     */
    XStream<T> head();

    /**
     * Keep the first X elements from the stream
     *
     * @param size the number of elements to keep
     * @return a new XStream
     */
    XStream<T> head(final long size);

    /**
     * Transform a String to lower case.
     *
     * @return a new XStream
     */
    XStream<String> lowercase();

    /**
     * Number lines.
     *
     * @return a new XStream
     */
    XStream<String> nl();

    /**
     * Pipe the current stream as input to the given {@link Stage}.
     *
     * @param stage the next stage
     * @param <R>   the type of elements in the stream
     * @return a new XStream
     */
    <R> XStream<R> pipe(final Stage<T, R> stage);

    /**
     * Reverse elements in the current stream.
     *
     * @return a new XStream
     */
    XStream<T> reverse();

    /**
     * Sort elements of the input stream in their natural order.
     * This is an alias of {@link Stream#sorted()}.
     *
     * @return a new XStream
     */
    XStream<T> sort();

    /**
     * Sort elements of the input stream using a custom comparator.
     * This is an alias of {@link Stream#sorted(Comparator)}.
     *
     * @param comparator the comparator to use to compare elements
     * @return a new XStream
     */
    XStream<T> sort(final Comparator<? super T> comparator);

    /**
     * Transform a stream of objects into a stream of Strings by calling {@link Object#toString()} on each object.
     *
     * @return a new XStream
     */
    XStream<String> str();

    /**
     * Keep the last 10 elements from the stream.
     *
     * @return a new XStream
     */
    XStream<T> tail();

    /**
     * Keep the last X elements from the stream.
     *
     * @param size the number of elements to keep
     * @return a new XStream
     */
    XStream<T> tail(final long size);

    /**
     * Replace patterns with expressions in a stream of Strings.
     *
     * @param regexp      the regexp to look for
     * @param replacement the replacement to apply
     * @return a new XStream
     */
    XStream<String> tr(final String regexp, final String replacement);

    /**
     * Remove trailing white spaces from a String.
     *
     * @return a new XStream
     */
    XStream<String> trim();

    /**
     * Truncate a String to a given size
     *
     * @param size the new size of the String
     * @return a new XStream
     */
    XStream<String> trunc(final int size);

    /**
     * Replace spaces with tabs in a String.
     *
     * @return a new XStream
     */
    XStream<String> unexpand();

    /**
     * Remove duplicates from the input stream.
     * This is an alias of {@link Stream#distinct()}.
     *
     * @return a new XStream
     */
    XStream<T> uniq();

    /**
     * Transform a String to upper case.
     *
     * @return a new XStream
     */
    XStream<String> uppercase();

    /**
     * Count the number of words in the stream.
     *
     * @return a new XStream
     */
    XStream<String> wc();

    /**
     * Count words or lines in a stream.
     *
     * @param option the option to apply
     * @return a new XStream
     */
    XStream<String> wc(final WordCount.Option option);

    /**
     * Write elements of the stream to a {@link PrintWriter}.
     *
     * @param printWriter the print writer to write elements to
     * @throws IOException thrown if an error occurs when writing elements
     */
    void to(final PrintWriter printWriter) throws IOException;

}
