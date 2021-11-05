package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2475 {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(buf.readLine(), " ");

        double[] number = new double[5];
        int serialNumber = 0;
        int sum = 0;

        for (int i = 0; i < number.length; i++) {
            number[i] = Math.pow(Integer.parseInt(str.nextToken()), 2) ;
        }

        for (double i : number) {
            sum += i;
        }
        serialNumber = sum % 10;
        System.out.println(serialNumber);
    }
}
