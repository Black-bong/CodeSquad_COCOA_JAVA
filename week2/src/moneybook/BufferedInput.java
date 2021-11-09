package moneybook;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferedInput {

    private static final BufferedReader instance = new BufferedReader(new InputStreamReader(System.in));

    public static BufferedReader getInstance() {
//        if (instance == null) {
//            instance = new BufferedReader(new InputStreamReader(System.in));
//        }
        return instance;
    }
}