package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int min = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[max + 1];
        arr[0] = true;
        arr[1] = true;
        for (int i = 2; i <= Math.sqrt(max) ; i++) {
            if (arr[i]) continue;
            for (int j = i * i; j < arr.length; j += i) {
                arr[j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = min; i <= max; i++) {
            if (!arr[i]) {
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }
}