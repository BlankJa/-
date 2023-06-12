
import java.util.*;
import java.io.*;

public class USACO08NOVBuy {
    public static void main(String[] args) {
        Input input = new Input();
        int n = input.nextInt();
        int v = input.nextInt() + 5000;
        int[] dp = new int[v + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        int[] c = new int[n + 1];
        int[] w = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            c[i] = input.nextInt();
            w[i] = input.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = c[i]; j <= v; j++) {
                dp[j] = Math.min(dp[j], dp[j - c[i]] + w[i]);

            }
        }

        int ans = dp[v];
        for (int i = v; i >= v - 5000; i--) {
            ans = Math.min(ans, dp[i]);
        }
        System.out.println(ans);
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

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        try {
            return buff.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
