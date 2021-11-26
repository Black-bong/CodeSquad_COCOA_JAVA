package simplerpg.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {

    public String inputString() {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        try {
            input = buf.readLine().toUpperCase();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            inputString();
        }
        return input;
    }
}