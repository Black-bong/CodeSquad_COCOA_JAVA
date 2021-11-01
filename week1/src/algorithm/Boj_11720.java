package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;

        String numberCount = buf.readLine();
        String read = buf.readLine();

        for (int i=0;i<read.length();i++) {
            result += read.charAt(i) - '0';
        }

        System.out.println(result);
    }
}
