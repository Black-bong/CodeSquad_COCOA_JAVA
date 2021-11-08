package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10870 {

    static int N;

    public static void main(String[] args) throws IOException {
        Boj10870 boj10870 = new Boj10870();
        boj10870.input();
        boj10870.solve();
    }

    void input() throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(buf.readLine());
    }

    void solve() {
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i ++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        System.out.println(dp[N]);
    }
}
