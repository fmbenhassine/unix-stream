package io.github.benas.unixstream;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.function.Supplier;

/**
 * Supplier that generates an infinite stream from the standard input.
 *
 * @author Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 */
class StandardInputSupplier implements Supplier<String> {

    private BufferedReader bufferedReader;

    StandardInputSupplier(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    @Override
    public String get() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
