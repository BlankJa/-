package 最短路径;

import java.util.Scanner;
// https://blog.csdn.net/john_bian/article/details/74612722
/*
 * Sample input
5 8
1 2 2
1 3 5
2 3 2
2 4 6
3 4 7
3 5 1
4 3 2
4 5 4
 * Sample output
最短距离：
0 2 4 8 5

 * Sample input 2
4 4
1 2 3
2 3 -4
3 4 2
4 2 1
 * Sample output 2
有负环！
 */

/*
 * 如果遇到负权边，则在没有负环（回路的权值之和为负）存在时，
 * 可以采用 Bellman-Ford 算法求解最短路径。
 * 该算法的优点是变的权值可以是负数、实现简单，
 * 缺点是时间复杂度过高。但是该算法可以进行若干种优化，以提高效率。
 * 
 * 
 * Bellman-Ford 算法与 Dijkstra 算法类似，都是以松弛操作作为基础。
 * Dijkstra 算法以贪心法选取未被处理的具有最小权值的节点，
 * 然后对其进行松弛操作；而 Bellman-Ford 算法对所有边都进行松弛操作，
 * 共 n-1 次。因为负环可以无限制地减少最短路径长度，
 * 所以吐过发现第 n 次操作仍然可松弛，则一定存在负环。
 * Bellman-Ford 算法最长运行时间为O(nm),其中 n 和 m 分别是节点数和边数。
 * 
 * 
1 数据结构
因为需要利用边进行松弛，因此采用边集数组存储。每条边都有三个域：两个端点a和b，以及边权w

2 松弛操作
对所有的边 j(a,b,w),如果 dis[e[j]b]>dis[e[j].a]+e[j].w,则松弛，另 dis[e[j]b]=dis[e[j].a]+e[j].w。其中，dis[v] 表示从源点到节点 v 的最短路径长度。

3 重复松弛操作 n-1 次

4 负环判断
再执行一次松弛操作，如果仍然可以松弛，则说明右负环。
 */
public class BellmanFord算法标准版 {
    static node e[] = new node[210];
    static int dis[] = new int[110];
    static int n;
    static int m;
    static int cnt = 0;

    static {
        for (int i = 0; i < e.length; i++) {
            e[i] = new node();
        }
    }

    static void add(int a, int b, int w) {
        e[cnt].a = a;
        e[cnt].b = b;
        e[cnt++].w = w;
    }

    static boolean bellman_ford(int u) { // 求源点 u 到其它顶点的最短路径长度，判负环
        for (int i = 0; i < dis.length; i++) {
            dis[i] = 0x3f;
        }
        dis[u] = 0;
        for (int i = 1; i < n; i++) { // 执行 n-1 次
            boolean flag = false;
            for (int j = 0; j < m; j++) // 边数 m 或 cnt
                if (dis[e[j].b] > dis[e[j].a] + e[j].w) {
                    dis[e[j].b] = dis[e[j].a] + e[j].w;
                    flag = true;
                }
            if (!flag)
                return false;
        }
        for (int j = 0; j < m; j++) // 再执行 1 次，还能松弛说明有环
            if (dis[e[j].b] > dis[e[j].a] + e[j].w)
                return true;
        return false;
    }

    static void print() { // 输出源点到其它节点的最短距离
        System.out.println("最短距离：");
        for (int i = 1; i <= n; i++)
            System.out.print(dis[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int a, b, w;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            w = scanner.nextInt();
            add(a, b, w);
        }
        if (bellman_ford(1)) // 判断负环
            System.out.println("有负环！");
        else
            print();
    }
}

class node {
    int a;
    int b;
    int w;
}