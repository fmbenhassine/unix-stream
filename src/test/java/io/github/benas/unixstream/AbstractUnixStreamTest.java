package io.github.benas.unixstream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Comparator;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Stream;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AbstractUnixStreamTest {

    @Mock
    private Stream<Object> stream;
    @Mock
    private Predicate<Object> predicate;
    @Mock
    private Function<Object, Object> function;
    @Mock
    private Comparator<Object> comparator;
    @Mock
    private Consumer<Object> consumer;
    @Mock
    private Collector collector;
    @Mock
    private Runnable runnable;
    @Mock
    private BinaryOperator<Object> binaryOperator;
    @Mock
    private ToIntFunction<Object> toIntFunction;
    @Mock
    private ToLongFunction<Object> toLongFunction;
    @Mock
    private ToDoubleFunction<Object> toDoubleFunction;
    @Mock
    private Function flatMapToIntFunction;
    @Mock
    private Function flatMapToLongFunction;
    @Mock
    private Function flatMapToDoubleFunction;
    @Mock
    private Function flatMapFunction;

    private AbstractUnixStream<Object> abstractUnixStream;

    @Before
    public void setUp() throws Exception {
        abstractUnixStream = new AbstractUnixStream<>(stream);
    }

    @Test
    public void filter() throws Exception {
        abstractUnixStream.filter(predicate);

        verify(stream).filter(predicate);
    }

    @Test
    public void map() throws Exception {
        abstractUnixStream.map(function);

        verify(stream).map(function);
    }

    @Test
    public void flatMap() throws Exception {
        abstractUnixStream.flatMap(flatMapFunction);

        verify(stream).flatMap(flatMapFunction);
    }

    @Test
    public void distinct() throws Exception {
        abstractUnixStream.distinct();

        verify(stream).distinct();
    }

    @Test
    public void sorted() throws Exception {
        abstractUnixStream.sorted();

        verify(stream).sorted();
    }

    @Test
    public void sortedWithComparator() throws Exception {
        abstractUnixStream.sorted(comparator);

        verify(stream).sorted(comparator);
    }

    @Test
    public void peek() throws Exception {
        abstractUnixStream.peek(consumer);

        verify(stream).peek(consumer);
    }

    @Test
    public void limit() throws Exception {
        abstractUnixStream.limit(10);

        verify(stream).limit(10);
    }

    @Test
    public void skip() throws Exception {
        abstractUnixStream.skip(10);

        verify(stream).skip(10);
    }

    @Test
    public void mapToInt() throws Exception {
        abstractUnixStream.mapToInt(toIntFunction);

        verify(stream).mapToInt(toIntFunction);
    }

    @Test
    public void mapToLong() throws Exception {
        abstractUnixStream.mapToLong(toLongFunction);

        verify(stream).mapToLong(toLongFunction);
    }

    @Test
    public void mapToDouble() throws Exception {
        abstractUnixStream.mapToDouble(toDoubleFunction);

        verify(stream).mapToDouble(toDoubleFunction);
    }

    @Test
    public void flatMapToInt() throws Exception {
        abstractUnixStream.flatMapToInt(flatMapToIntFunction);

        verify(stream).flatMapToInt(flatMapToIntFunction);
    }

    @Test
    public void flatMapToLong() throws Exception {
        abstractUnixStream.flatMapToLong(flatMapToLongFunction);

        verify(stream).flatMapToLong(flatMapToLongFunction);
    }

    @Test
    public void flatMapToDouble() throws Exception {
        abstractUnixStream.flatMapToDouble(flatMapToDoubleFunction);

        verify(stream).flatMapToDouble(flatMapToDoubleFunction);
    }

    @Test
    public void forEach() throws Exception {
        abstractUnixStream.forEach(consumer);

        verify(stream).forEach(consumer);
    }

    @Test
    public void forEachOrdered() throws Exception {
        abstractUnixStream.forEachOrdered(consumer);

        verify(stream).forEachOrdered(consumer);
    }

    @Test
    public void toArray() throws Exception {
        abstractUnixStream.toArray();

        verify(stream).toArray();
    }

    @Test
    public void reduce() throws Exception {
        abstractUnixStream.reduce(binaryOperator);

        verify(stream).reduce(binaryOperator);
    }

    @Test
    public void collect() throws Exception {
        abstractUnixStream.collect(collector);

        verify(stream).collect(collector);
    }

    @Test
    public void min() throws Exception {
        abstractUnixStream.min(comparator);

        verify(stream).min(comparator);
    }

    @Test
    public void max() throws Exception {
        abstractUnixStream.max(comparator);

        verify(stream).max(comparator);
    }

    @Test
    public void count() throws Exception {
        abstractUnixStream.count();

        verify(stream).count();
    }

    @Test
    public void anyMatch() throws Exception {
        abstractUnixStream.anyMatch(predicate);

        verify(stream).anyMatch(predicate);
    }

    @Test
    public void allMatch() throws Exception {
        abstractUnixStream.allMatch(predicate);

        verify(stream).allMatch(predicate);
    }

    @Test
    public void noneMatch() throws Exception {
        abstractUnixStream.noneMatch(predicate);

        verify(stream).noneMatch(predicate);
    }

    @Test
    public void findFirst() throws Exception {
        abstractUnixStream.findFirst();

        verify(stream).findFirst();
    }

    @Test
    public void findAny() throws Exception {
        abstractUnixStream.findAny();

        verify(stream).findAny();
    }

    @Test
    public void iterator() throws Exception {
        abstractUnixStream.iterator();

        verify(stream).iterator();
    }

    @Test
    public void spliterator() throws Exception {
        abstractUnixStream.spliterator();

        verify(stream).spliterator();
    }

    @Test
    public void isParallel() throws Exception {
        abstractUnixStream.isParallel();

        verify(stream).isParallel();
    }

    @Test
    public void sequential() throws Exception {
        abstractUnixStream.sequential();

        verify(stream).sequential();
    }

    @Test
    public void parallel() throws Exception {
        abstractUnixStream.parallel();

        verify(stream).parallel();
    }

    @Test
    public void unordered() throws Exception {
        abstractUnixStream.unordered();

        verify(stream).unordered();
    }

    @Test
    public void onClose() throws Exception {
        abstractUnixStream.onClose(runnable);

        verify(stream).onClose(runnable);
    }

    @Test
    public void close() throws Exception {
        abstractUnixStream.close();

        verify(stream).close();
    }

}