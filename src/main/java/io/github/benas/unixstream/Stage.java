package io.github.benas.unixstream;

import java.util.stream.Stream;

/**
 * Interface representing a stage of the pipeline.
 * This interface is intended to filter/transform the input stream without any side-effect.
 *
 * @param <I> the type of input elements
 * @param <O> the type of output elements
 * @author Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 */
public interface Stage<I, O> {

    /**
     * Apply the transformation to the input stream to produce the output stream.
     *
     * @param input the input stream
     * @return the output stream
     */
    Stream<O> apply(Stream<I> input);

}
