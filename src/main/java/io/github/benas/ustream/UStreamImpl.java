package io.github.benas.ustream;

import io.github.benas.ustream.components.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Stream;

class UStreamImpl<T> extends AbstractUStream<T> implements UStream<T> {

    UStreamImpl(final Stream<T> stream) {
        super(stream);
    }

    @Override
    public UStream<String> compact() {
        return new UStreamImpl<>(Compact.compact().apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public UStream<T> concat(Stream<T> stream) {
        return new UStreamImpl<>(Stream.concat(this.stream, stream));
    }

    @Override
    public UStream<String> cut(final String delimiter, final int field) {
        return new UStreamImpl<>(Cut.cut(delimiter, field).apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public UStream<String> dos2unix() {
        return new UStreamImpl<>(Dos2Unix.dos2unix().apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public UStream<T> exclude(final Predicate<T> predicate) {
        return new UStreamImpl<>(Exclude.exclude(predicate).apply(stream));
    }

    @Override
    public UStream<String> expand() {
        return new UStreamImpl<>(Expand.expand().apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public UStream<String> fold(final int size) {
        return new UStreamImpl<>(Fold.fold(size).apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public Stream<T> get() {
        return stream;
    }

    @Override
    public UStream<String> grep(final String pattern) {
        return new UStreamImpl<>(Grep.grep(pattern).apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public UStream<T> head() {
        return head(Head.DEFAULT_SIZE);
    }

    @Override
    public UStream<T> head(final long size) {
        return new UStreamImpl<>(new Head<T>(size).apply(stream));
    }

    @Override
    public UStream<String> lowercase() {
        return new UStreamImpl<>(LowerCase.lowerCase().apply(new Stringify<T>().apply(stream)));
    }
    
    @Override
    public UStream<String> nl() {
        return new UStreamImpl<>(NumberLines.numberLines().apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public <R> UStream<R> pipe(final Stage<T, R> stage) {
        return new UStreamImpl<>(stage.apply(stream));
    }

    @Override
    public UStream<T> reverse() {
        return new UStreamImpl<>(new Reverse<T>().apply(stream));
    }

    @Override
    public UStream<T> sort() {
        return sorted();
    }

    @Override
    public UStream<T> sort(final Comparator<? super T> comparator) {
        return sorted(comparator);
    }

    @Override
    public UStream<String> str() {
        return new UStreamImpl<>(new Stringify<T>().apply(stream));
    }

    @Override
    public UStream<T> tail() {
        return tail(Tail.DEFAULT_SIZE);
    }

    @Override
    public UStream<T> tail(final long size) {
        return new UStreamImpl<>(new Tail<T>(size).apply(stream));
    }

    @Override
    public void to(final PrintWriter printWriter) throws IOException {
        new Stringify<T>().apply(stream).forEachOrdered(printWriter::println);
    }

    @Override
    public UStream<String> tr(final String regexp, final String replacement) {
        return new UStreamImpl<>(Translate.tr(regexp, replacement).apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public UStream<String> trim() {
        return new UStreamImpl<>(Trim.trim().apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public UStream<String> trunc(final int size) {
        return new UStreamImpl<>(Truncate.trunc(size).apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public UStream<String> unexpand() {
        return new UStreamImpl<>(UnExpand.unexpand().apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public UStream<T> uniq() {
        return new UStreamImpl<>(stream.distinct());
    }

    @Override
    public UStream<String> uppercase() {
        return new UStreamImpl<>(UpperCase.uppercase().apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public UStream<String> wc() {
        return wc(WordCount.Option.L);
    }

    @Override
    public UStream<String> wc(final WordCount.Option option) {
        return new UStreamImpl<>(WordCount.wc(option).apply(new Stringify<T>().apply(stream)));
    }

}
