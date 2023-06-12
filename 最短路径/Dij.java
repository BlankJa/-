package 最短路径;

import java.util.*;

public class Dij {
    static int n, m, v0, v1;
    static int[][] graph;
    static int[] dis;
    static boolean[] vis;
    static int[] path;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();
            graph[a][b] = c;
            graph[b][a] = c;
        }
        v0 = input.nextInt();
        v1 = input.nextInt();
        dis = new int[n + 1];
        vis = new boolean[n + 1];
        path = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[v0] = 0;
        dij();
        for (int i : dis) {
            System.out.printf("%d  ", i);
        }
        System.out.println();
        // int[] pathN = new int[n];
        // int cur=v1;
        // int q = 0;
        // while(cur != path[v0]){
        // pathN[q++] = cur;
        // cur = path[cur];
        // }
        // for(int i = q-1; i >= 0; i--){
        // System.out.printf("%d ",pathN[i]);
        // }
        Dij a = new Dij();
        a.print(v1);
        System.out.println();
    }

    public static void dij() {
        for (int j = 0; j < n; j++) {
            int min = Integer.MAX_VALUE;
            int minv = -1;
            for (int i = 1; i <= n; i++) {
                if (!vis[i] && dis[i] < min) {
                    min = dis[i];
                    minv = i;
                }
            }
            vis[minv] = true;
            for (int i = 1; i <= n; i++) {
                if (!vis[i] && graph[minv][i] != 0) {
                    int d = dis[minv] + graph[minv][i];
                    if (d < dis[i]) {
                        dis[i] = d;
                        path[i] = minv;
                    }
                }
            }
        }
    }

    public void print(int v) {
        if (path[v] == 0) {
            System.out.printf("%d  ", v);
            return;
        }
        print(path[v]);
        System.out.printf("%d  ", v);
    }
}
