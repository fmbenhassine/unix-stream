package io.github.benas.unixstream;

import io.github.benas.unixstream.components.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Stream;

class UnixStreamImpl<T> extends AbstractUnixStream<T> implements UnixStream<T> {

    UnixStreamImpl(final Stream<T> stream) {
        super(stream);
    }

    @Override
    public UnixStream<String> compact() {
        return new UnixStreamImpl<>(Compact.compact().apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public UnixStream<T> concat(Stream<T> stream) {
        return new UnixStreamImpl<>(Stream.concat(this.stream, stream));
    }

    @Override
    public UnixStream<String> cut(final String delimiter, final int field) {
        return new UnixStreamImpl<>(Cut.cut(delimiter, field).apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public UnixStream<String> dos2unix() {
        return new UnixStreamImpl<>(Dos2Unix.dos2unix().apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public UnixStream<T> exclude(final Predicate<T> predicate) {
        return new UnixStreamImpl<>(Exclude.exclude(predicate).apply(stream));
    }

    @Override
    public UnixStream<String> expand() {
        return new UnixStreamImpl<>(Expand.expand().apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public UnixStream<String> fold(final int size) {
        return new UnixStreamImpl<>(Fold.fold(size).apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public Stream<T> get() {
        return stream;
    }

    @Override
    public UnixStream<String> grep(final String pattern) {
        return new UnixStreamImpl<>(Grep.grep(pattern).apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public UnixStream<T> head() {
        return head(Head.DEFAULT_SIZE);
    }

    @Override
    public UnixStream<T> head(final long size) {
        return new UnixStreamImpl<>(new Head<T>(size).apply(stream));
    }

    @Override
    public UnixStream<String> lowercase() {
        return new UnixStreamImpl<>(LowerCase.lowerCase().apply(new Stringify<T>().apply(stream)));
    }
    
    @Override
    public UnixStream<String> nl() {
        return new UnixStreamImpl<>(NumberLines.nl().apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public <R> UnixStream<R> pipe(final Stage<T, R> stage) {
        return new UnixStreamImpl<>(stage.apply(stream));
    }

    @Override
    public UnixStream<T> reverse() {
        return new UnixStreamImpl<>(new Reverse<T>().apply(stream));
    }

    @Override
    public UnixStream<T> sort() {
        return sorted();
    }

    @Override
    public UnixStream<T> sort(final Comparator<? super T> comparator) {
        return sorted(comparator);
    }

    @Override
    public UnixStream<String> str() {
        return new UnixStreamImpl<>(new Stringify<T>().apply(stream));
    }

    @Override
    public UnixStream<T> tail() {
        return tail(Tail.DEFAULT_SIZE);
    }

    @Override
    public UnixStream<T> tail(final long size) {
        return new UnixStreamImpl<>(new Tail<T>(size).apply(stream));
    }

    @Override
    public void to(final PrintWriter printWriter) throws IOException {
        new Stringify<T>().apply(stream).forEachOrdered(printWriter::println);
    }

    @Override
    public UnixStream<String> tr(final String regexp, final String replacement) {
        return new UnixStreamImpl<>(Translate.tr(regexp, replacement).apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public UnixStream<String> trim() {
        return new UnixStreamImpl<>(Trim.trim().apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public UnixStream<String> trunc(final int size) {
        return new UnixStreamImpl<>(Truncate.trunc(size).apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public UnixStream<String> unexpand() {
        return new UnixStreamImpl<>(UnExpand.unexpand().apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public UnixStream<T> uniq() {
        return new UnixStreamImpl<>(stream.distinct());
    }

    @Override
    public UnixStream<String> uppercase() {
        return new UnixStreamImpl<>(UpperCase.uppercase().apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public UnixStream<String> wc() {
        return wc(WordCount.Option.L);
    }

    @Override
    public UnixStream<String> wc(final WordCount.Option option) {
        return new UnixStreamImpl<>(WordCount.wc(option).apply(new Stringify<T>().apply(stream)));
    }

}
