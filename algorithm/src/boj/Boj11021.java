package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11021 {
    public static void main(String[] args) throws IOException {

        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(buf.readLine());
        StringTokenizer str;
        StringBuilder sbr = new StringBuilder();

        for (int i = 0; i < a; i++) {

            str = new StringTokenizer(buf.readLine(), " ");
            sbr.append("Case #").append(i+1).append(": ").append(Integer.parseInt(str.nextToken()) + Integer.parseInt(str.nextToken())).append('\n');
        }
        buf.close();
        System.out.println(sbr);
    }
}