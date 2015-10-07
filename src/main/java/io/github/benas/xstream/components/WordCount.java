package io.github.benas.xstream.components;

import static java.lang.String.valueOf;

import java.util.function.Function;
import java.util.stream.Stream;
import io.github.benas.xstream.Stage;

public class WordCount implements Stage<String, String> {

    private WordCountOption wordCountOption;

    public enum WordCountOption {
        /**
         * Mimics wc -w
         */
        W,
        /**
         * Mimics wc -l
         */
        L
    }

    public WordCount() {
        this.wordCountOption = WordCountOption.W;
    }

    public WordCount(WordCountOption wordCountOption) {
        this.wordCountOption = wordCountOption;
    }
    
    public static WordCount wordCount() {
        return new WordCount();
    }

    public static WordCount wordCount(WordCountOption wordCountOption) {
        return new WordCount(wordCountOption);
    }

    @Override
    public Stream<String> apply(Stream<String> input) {
        if (wordCountOption.equals(WordCountOption.L)) {
            return Stream.of(valueOf(input.count()));
        } else {
            Stream<String> stringStream = input.flatMap(new Function<String, Stream<? extends String>>() {
                @Override
                public Stream<? extends String> apply(String s) {
                    return Stream.of(s.split(" "));
                }
            });
            return Stream.of(valueOf(stringStream.count()));
        }
    }
}
