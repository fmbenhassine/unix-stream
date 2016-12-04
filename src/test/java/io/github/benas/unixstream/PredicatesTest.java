package io.github.benas.unixstream;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PredicatesTest {

    @Test
    public void nonNull() throws Exception {
        assertThat(Predicates.nonNull().test(1)).isTrue();
        assertThat(Predicates.nonNull().test(null)).isFalse();
    }

    @Test
    public void isNull() throws Exception {
        assertThat(Predicates.isNull().test(1)).isFalse();
        assertThat(Predicates.isNull().test(null)).isTrue();
    }

    @Test
    public void empty() throws Exception {
        assertThat(Predicates.empty().test("")).isTrue();
        assertThat(Predicates.empty().test("a")).isFalse();
    }

    @Test
    public void startsWith() throws Exception {
        assertThat(Predicates.startsWith("a").test("ab")).isTrue();
        assertThat(Predicates.startsWith("a").test("cd")).isFalse();
    }

    @Test
    public void endsWith() throws Exception {
        assertThat(Predicates.endsWith("b").test("ab")).isTrue();
        assertThat(Predicates.endsWith("b").test("cd")).isFalse();
    }

    @Test
    public void matches() throws Exception {
        assertThat(Predicates.matches("a*").test("aa")).isTrue();
        assertThat(Predicates.matches("a*").test("bb")).isFalse();
    }

    @Test
    public void even() throws Exception {
        assertThat(Predicates.even().test(2)).isTrue();
        assertThat(Predicates.even().test(1)).isFalse();
    }

    @Test
    public void odd() throws Exception {
        assertThat(Predicates.odd().test(1)).isTrue();
        assertThat(Predicates.odd().test(2)).isFalse();
    }

    @Test
    public void isZero() throws Exception {
        assertThat(Predicates.isZero().test(0)).isTrue();
        assertThat(Predicates.isZero().test(1)).isFalse();
    }

}