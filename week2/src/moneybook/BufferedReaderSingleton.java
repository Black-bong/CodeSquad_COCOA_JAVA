package moneybook;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferedReaderSingleton {

    private static final BufferedReader instance = new BufferedReader(new InputStreamReader(System.in));

    public static BufferedReader getInstance() {
        return instance;
    }
}