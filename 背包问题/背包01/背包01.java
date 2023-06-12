// package 背包问题.背包01;

import java.util.*;
import java.io.*;

public class 背包01 {
    public static void main(String[] args) {
        Input input = new Input();
        int v = input.nextInt();
        int n = input.nextInt();
        // int[] pre = new int[v + 1];
        // int[] cur = new int[v + 1];
        // for(int i = 1; i <= n; i++) {
        // int c = input.nextInt();
        // int w = input.nextInt();
        // for(int j = 0; j <= v; j++) {
        // if(j < c) {
        // cur[j] = pre[j];
        // } else {
        // cur[j] = Math.max(pre[j], pre[j - c] + w);
        // }
        // }
        // pre = cur;
        // }
        // System.out.println(cur[v]);

        // 如果背包要求正好装满，那么初始化时dp[0] = 0，其余dp[i] = -INF
        // 如果背包不要求正好装满，那么初始化时dp[0] = 0，其余dp[i] = 0
        // 如果背包要求最小化，那么初始化时dp[0] = 0，其余dp[i] = INF。 在转移时，dp[j] = Math.min(dp[j], dp[j -
        // c] + w);

        int[] dp = new int[v + 1];
        for (int i = 1; i <= n; i++) {
            int c = input.nextInt();// 体积
            int w = input.nextInt();// 价值
            for (int j = v; j >= c; j--) {
                dp[j] = Math.max(dp[j], dp[j - c] + w);//dp[j - c] + w 代表装入第i个物品后的价值
            }
        }
        System.out.println(dp[v]);
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