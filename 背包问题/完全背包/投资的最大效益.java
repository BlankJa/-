package 背包问题.完全背包;

import java.util.*;
import java.io.*;

public class 投资的最大效益 {
    public static void main(String[] args) {
        Input input = new Input();
        long v = input.nextLong();
        int years = input.nextInt();
        int n = input.nextInt();
        int[] c = new int[n];
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = input.nextInt();
            w[i] = input.nextInt();
        }

        for (int i = 0; i < years; i++) {
            v += invest(c, w, v, n);
        }
        System.out.println(v);
    }

    public static long invest(int[] c, int[] w, long v, int n) {
        long[] dp = new long[(int) v + 1];
        for (int i = 0; i < n; i++) {
            for (int j = c[i]; j <= v; j++) {
                dp[j] = Math.max(dp[j], dp[j - c[i]] + w[i]);
            }
        }
        return dp[(int) v];
    }
}

class Input {
    BufferedReader buff;
    StringTokenizer token;

    Input() {
        buff = new BufferedReader(new InputStreamReader(System.in));
        token = new StringTokenizer("");
    }

    String next() {
        while (!token.hasMoreTokens()) {
            try {
                token = new StringTokenizer(buff.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return token.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }
}