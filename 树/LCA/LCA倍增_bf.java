package 树.LCA;

import java.util.*;
import java.io.*;
//luogu P3379

public class LCA倍增_bf {
    static int n, m, s;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] depth, father;

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
        // build graph
        depth = new int[n + 1];
        father = new int[n + 1];
        // father[s] = s; //根节点的父节点是自己
        depth[s] = 1; // 根节点的深度是1
        // input
        for (int i = 1; i < n; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        // 深搜计算深度与父节点
        dfs(s);
        // 倍增计算LCA
        for (int i = 0; i < m; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            System.out.println(getLca(u, v));
        }
    }

    static void dfs(int u) {
        for (int v : graph.get(u)) {
            if (v == father[u])
                continue;
            father[v] = u;
            depth[v] = depth[u] + 1;
            dfs(v);
        }
    }

    static int getLca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
            /*
             * or
             * u = u^v;
             * v = u^v;
             * u = u^v;
             */
        }
        // 保证u的深度大于v
        while (depth[u] > depth[v]) {
            u = father[u];
        }
        // //如果u==v，说明u和v在同一深度，且是同一个节点
        // if(u==v) return u;
        // //如果u!=v，说明u和v在同一深度，但不是同一个节点
        // while(father[u]!=father[v]){
        // u = father[u];
        // v = father[v];
        // }
        // return father[u];
        // 或者
        while (u != v) {
            u = father[u];
            v = father[v];
        }
        return u;
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

}