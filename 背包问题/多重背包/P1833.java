
import java.util.*;
import java.io.*;

public class P1833 {
    public static void main(String[] args) {
        Input input = new Input();
        int v = -time(input.next()) + time(input.next());
        int n = input.nextInt();
        int[] dp = new int[v + 1];

        for (int i = 0; i < n; i++) {
            int c = input.nextInt();
            int w = input.nextInt();
            int t = input.nextInt();
            if (t == 0 )
                t = v / c;
            int x = t, k = 1;
            while (x >= k) {
                x -= k;
                for (int j = v; j >= k * c; j--) {
                    dp[j] = Math.max(dp[j], dp[j - k * c] + k * w);
                }

                k *= 2;
            }
            for (int j = v; j >= k * c; j--) {
                dp[j] = Math.max(dp[j], dp[j - x * c] + x * w);
            }
            // for (int j = v; j >= c; j--) {
            // if (c == 0) {
            // dp[j] = w * t;
            // } else {
            // for (int k = 1; k <= Math.min(t, j / c); k++) {
            // dp[j] = Math.max(dp[j], dp[j - k * c] + k * w);
            // }
            // }
            // }

        }
        System.out.println(dp[v]);
    }

    static int time(String t) {
        String[] s = t.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
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