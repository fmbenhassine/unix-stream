package io.github.benas.unixstream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Supplier;

import static java.lang.System.in;

/**
 * Supplier that generates an infinite stream from the standard input.
 *
 * @author Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 */
class StandardInputSupplier implements Supplier<String> {

    private BufferedReader bufferedReader;

    StandardInputSupplier() {
        bufferedReader = new BufferedReader(new InputStreamReader(in));
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
