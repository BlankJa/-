import java.util.*;
import java.io.*;

public class LCA倍增_bl {
    static int n, m, s;
    static List<List<Integer>> graph;
    static int[] de;
    static int[][] anc;

    public static void main(String[] args) {
        Input input = new Input();
        n = input.nextInt();
        m = input.nextInt();
        s = input.nextInt();
        // init
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        anc = new int[n + 1][20];
        // for (int v = 1; v <= n; v++) {
        // anc[v][0] =
        // }
        de = new int[n + 1];
        // fa[s] = s;
        de[s] = 1;
        // input
        for (int i = 1; i < n; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        // 深搜计算深度与父结点
        dfs(s);
        for (int j = 1; j <= 18; j++) {
            for (int i = 1; i <= n; i++) {
                anc[i][j] = anc[anc[i][j - 1]][j - 1];
            }
        }
        // query
        for (int i = 0; i < m; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            System.out.println(getLca(u, v));
        }
        // System.out.println((int)(Math.log(500000) / Math.log(2)));
    }

    static void dfs(int u) {
        for (int v : graph.get(u)) {
            if (anc[u][0] == v)
                continue;
            anc[v][0] = u;
            de[v] = de[u] + 1;
            dfs(v);
        }
    }

    static int getLca(int u, int v) {
        if (de[u] < de[v]) {
            u ^= v;
            v ^= u;
            u ^= v;
        }
        // while (de[u] > de[v]) u = fa[u];
        for (int i = 18; i >= 0; i--) {
            if (de[anc[u][i]] >= de[v]) {
                u = anc[u][i];
            }
        }
        // de[u] == de[v]
        if (u == v)
            return u;
        for (int i = 18; i >= 0; i--) {
            if (anc[u][i] != anc[v][i]) {
                u = anc[u][i];
                v = anc[v][i];
            }
        }
        return anc[u][0];
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
