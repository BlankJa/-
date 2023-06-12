import java.util.*;
import java.io.*;

public class P1164 {
    public static void main(String[] args) {
        Input input = new Input();
        int n = input.nextInt();
        int v = input.nextInt();
        int[] dp = new int[v + 1];
        dp[0] = 1;
        int c;
        for (int i = 1; i <= n; i++) {
            c = input.nextInt();
            for (int j = v; j >= c; j--) {
                dp[j] = dp[j] + dp[j - c];
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