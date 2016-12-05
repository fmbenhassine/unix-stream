package io.github.benas.unixstream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.IOException;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StandardInputSupplierTest {

    @Mock
    private BufferedReader bufferedReader;
    @Mock
    private IOException exception;

    private StandardInputSupplier standardInputSupplier;

    @Before
    public void setUp() throws Exception {
        standardInputSupplier = new StandardInputSupplier(bufferedReader);
    }

    @Test
    public void get() throws Exception {
        standardInputSupplier.get();

        verify(bufferedReader).readLine();
    }

    @Test(expected = RuntimeException.class)
    public void get_whenBufferedReaderThrowsException() throws Exception {
        Mockito.when(bufferedReader.readLine()).thenThrow(exception);

        standardInputSupplier.get();
    }

}