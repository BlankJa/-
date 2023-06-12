//package 背包问题.背包01;

import java.util.*;
import java.io.*;

public class P1049 {
    public static void main(String[] args) {
        Input input = new Input();
        int v = input.nextInt();
        int n = input.nextInt();
        int[] dp = new int[v + 1];
        int c;
        for (int i = 1; i <= n; i++) {
            c = input.nextInt();
            for (int j = v; j >= c; j--) {
                dp[j] = Math.max(dp[j], dp[j - c] + c);
            }
        }
        System.out.println(v - dp[v]);
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
}
