package io.github.benas.xstream;

import io.github.benas.xstream.components.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Stream;

class XStreamImpl<T> extends AbstractXStream<T> implements XStream<T> {

    XStreamImpl(final Stream<T> stream) {
        super(stream);
    }

    @Override
    public XStream<String> compact() {
        return new XStreamImpl<>(Compact.compact().apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public XStream<T> concat(Stream<T> stream) {
        return new XStreamImpl<>(Stream.concat(this.stream, stream));
    }

    @Override
    public XStream<String> cut(final String delimiter, final int field) {
        return new XStreamImpl<>(Cut.cut(delimiter, field).apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public XStream<String> dos2unix() {
        return new XStreamImpl<>(Dos2Unix.dos2unix().apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public XStream<T> exclude(final Predicate<T> predicate) {
        return new XStreamImpl<>(Exclude.exclude(predicate).apply(stream));
    }

    @Override
    public XStream<String> expand() {
        return new XStreamImpl<>(Expand.expand().apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public XStream<String> fold(final int size) {
        return new XStreamImpl<>(Fold.fold(size).apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public Stream<T> get() {
        return stream;
    }

    @Override
    public XStream<String> grep(final String pattern) {
        return new XStreamImpl<>(Grep.grep(pattern).apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public XStream<T> head() {
        return head(Head.DEFAULT_SIZE);
    }

    @Override
    public XStream<T> head(final long size) {
        return new XStreamImpl<>(new Head<T>(size).apply(stream));
    }

    @Override
    public XStream<String> lowercase() {
        return new XStreamImpl<>(LowerCase.lowerCase().apply(new Stringify<T>().apply(stream)));
    }
    
    @Override
    public XStream<String> nl() {
        return new XStreamImpl<>(NumberLines.numberLines().apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public <R> XStream<R> pipe(final Stage<T, R> stage) {
        return new XStreamImpl<>(stage.apply(stream));
    }

    @Override
    public XStream<T> reverse() {
        return new XStreamImpl<>(new Reverse<T>().apply(stream));
    }

    @Override
    public XStream<T> sort() {
        return sorted();
    }

    @Override
    public XStream<T> sort(final Comparator<? super T> comparator) {
        return sorted(comparator);
    }

    @Override
    public XStream<String> str() {
        return new XStreamImpl<>(new Stringify<T>().apply(stream));
    }

    @Override
    public XStream<T> tail() {
        return tail(Tail.DEFAULT_SIZE);
    }

    @Override
    public XStream<T> tail(final long size) {
        return new XStreamImpl<>(new Tail<T>(size).apply(stream));
    }

    @Override
    public void to(final PrintWriter printWriter) throws IOException {
        new Stringify<T>().apply(stream).forEachOrdered(printWriter::println);
    }

    @Override
    public XStream<String> tr(final String regexp, final String replacement) {
        return new XStreamImpl<>(Translate.tr(regexp, replacement).apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public XStream<String> trim() {
        return new XStreamImpl<>(Trim.trim().apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public XStream<String> trunc(final int size) {
        return new XStreamImpl<>(Truncate.trunc(size).apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public XStream<String> unexpand() {
        return new XStreamImpl<>(UnExpand.unexpand().apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public XStream<T> uniq() {
        return new XStreamImpl<>(stream.distinct());
    }

    @Override
    public XStream<String> uppercase() {
        return new XStreamImpl<>(UpperCase.uppercase().apply(new Stringify<T>().apply(stream)));
    }

    @Override
    public XStream<String> wc() {
        return wc(WordCount.Option.L);
    }

    @Override
    public XStream<String> wc(final WordCount.Option option) {
        return new XStreamImpl<>(WordCount.wc(option).apply(new Stringify<T>().apply(stream)));
    }

}
