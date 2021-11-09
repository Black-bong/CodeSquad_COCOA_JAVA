package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15552 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer str;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            str = new StringTokenizer(br.readLine()," ");
            sb.append(Integer.parseInt(str.nextToken()) + Integer.parseInt(str.nextToken())).append('\n');
        }
        br.close();
        System.out.println(sb);
    }
}