package io.github.benas.unixstream;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.*;
import java.util.stream.*;

class AbstractUnixStream<T> {

    protected Stream<T> stream;

    protected AbstractUnixStream(final Stream<T> stream) {
        this.stream = stream;
    }

    public UnixStream<T> filter(Predicate<? super T> predicate) {
        return new UnixStreamImpl<>(stream.filter(predicate));
    }

    public <R> UnixStream<R> map(Function<? super T, ? extends R> mapper) {
        return new UnixStreamImpl<>(stream.map(mapper));
    }

    public <R> UnixStream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) {
        return new UnixStreamImpl<>(stream.flatMap(mapper));
    }

    public UnixStream<T> distinct() {
        return new UnixStreamImpl<>(stream.distinct());
    }

    public UnixStream<T> sorted() {
        return new UnixStreamImpl<>(stream.sorted());
    }

    public UnixStream<T> sorted(Comparator<? super T> comparator) {
        return new UnixStreamImpl<>(stream.sorted(comparator));
    }

    public UnixStream<T> peek(Consumer<? super T> action) {
        return new UnixStreamImpl<>(stream.peek(action));
    }

    public UnixStream<T> limit(long maxSize) {
        return new UnixStreamImpl<>(stream.limit(maxSize));
    }

    public UnixStream<T> skip(long n) {
        return new UnixStreamImpl<>(stream.skip(n));
    }

    public IntStream mapToInt(ToIntFunction<? super T> mapper) {
        return stream.mapToInt(mapper);
    }

    public LongStream mapToLong(ToLongFunction<? super T> mapper) {
        return stream.mapToLong(mapper);
    }

    public DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper) {
        return stream.mapToDouble(mapper);
    }

    public IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper) {
        return stream.flatMapToInt(mapper);
    }

    public LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper) {
        return stream.flatMapToLong(mapper);
    }

    public DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper) {
        return stream.flatMapToDouble(mapper);
    }

    public void forEach(Consumer<? super T> action) {
        stream.forEach(action);
    }

    public void forEachOrdered(Consumer<? super T> action) {
        stream.forEachOrdered(action);
    }

    public Object[] toArray() {
        return stream.toArray();
    }

    public <A> A[] toArray(IntFunction<A[]> generator) {
        return stream.toArray(generator);
    }

    public T reduce(T identity, BinaryOperator<T> accumulator) {
        return stream.reduce(identity, accumulator);
    }

    public Optional<T> reduce(BinaryOperator<T> accumulator) {
        return stream.reduce(accumulator);
    }

    public <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner) {
        return stream.reduce(identity, accumulator, combiner);
    }

    public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner) {
        return stream.collect(supplier, accumulator, combiner);
    }

    public <R, A> R collect(Collector<? super T, A, R> collector) {
        return stream.collect(collector);
    }

    public Optional<T> min(Comparator<? super T> comparator) {
        return stream.min(comparator);
    }

    public Optional<T> max(Comparator<? super T> comparator) {
        return stream.max(comparator);
    }

    public long count() {
        return stream.count();
    }

    public boolean anyMatch(Predicate<? super T> predicate) {
        return stream.anyMatch(predicate);
    }

    public boolean allMatch(Predicate<? super T> predicate) {
        return stream.allMatch(predicate);
    }

    public boolean noneMatch(Predicate<? super T> predicate) {
        return stream.noneMatch(predicate);
    }

    public Optional<T> findFirst() {
        return stream.findFirst();
    }

    public Optional<T> findAny() {
        return stream.findAny();
    }

    public Iterator<T> iterator() {
        return stream.iterator();
    }

    public Spliterator<T> spliterator() {
        return stream.spliterator();
    }

    public boolean isParallel() {
        return stream.isParallel();
    }

    public UnixStream<T> sequential() {
        return new UnixStreamImpl<>(stream.sequential());
    }

    public UnixStream<T> parallel() {
        return new UnixStreamImpl<>(stream.parallel());
    }

    public UnixStream<T> unordered() {
        return new UnixStreamImpl<>(stream.unordered());
    }

    public UnixStream<T> onClose(Runnable closeHandler) {
        return new UnixStreamImpl<>(stream.onClose(closeHandler));
    }

    public void close() {
        stream.close();
    }
}
