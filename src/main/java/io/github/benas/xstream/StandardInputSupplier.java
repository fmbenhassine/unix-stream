package io.github.benas.xstream;

import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Supplier;

public class StandardInputSupplier implements Supplier<String> {

    private BufferedReader bufferedReader;

    public StandardInputSupplier() {
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
