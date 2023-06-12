package 最短路径;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
        int dis;
        int ind;

        public Node(int ind, int dis) {
                this.dis = dis;
                this.ind = ind;
        }

        @Override
        public int compareTo(Node o) {
                // TODO Auto-generated method stub
                return this.dis - o.dis;
        }
}

public class DIJ最短路径 {
        static final int N = 100005, INF = (int) 1e9 + 5;
        static int h[] = new int[N];
        static int e[] = new int[N];
        static int ne[] = new int[N];
        static int w[] = new int[N];
        static boolean vis[] = new boolean[N];
        static int dis[] = new int[N];
        static int n, m, idx;
        static PriorityQueue<Node> q = new PriorityQueue<Node>();

        static void add(int a, int b, int c) {
                e[idx] = b;
                w[idx] = c;
                ne[idx] = h[a];
                h[a] = idx++;
        }

        static int dijkstra() {
                Arrays.fill(dis, INF);
                dis[0] = 0;
                q.offer(new Node(1, 0));
                while (!q.isEmpty()) {
                        Node t = q.poll();
                        if (vis[t.ind])
                                continue;
                        vis[t.ind] = true;
                        for (int i = h[t.ind]; i != -1; i = ne[i]) {
                                int j = e[i];// 一定要注意e[]数组代表当前的数字
                                if (dis[j] > t.dis + w[i]) {
                                        dis[j] = t.dis + w[i];
                                        q.offer(new Node(j, dis[j]));
                                }
                        }
                }
                if (dis[n] == INF)
                        return -1;
                else
                        return dis[n];
        }

        public static void main(String[] args) {
                Scanner scan = new Scanner(System.in);
                n = scan.nextInt();
                m = scan.nextInt();
                Arrays.fill(h, -1);
                while (m-- > 0) {
                        int a = scan.nextInt();
                        int b = scan.nextInt();
                        int c = scan.nextInt();
                        add(a, b, c);
                }
                System.out.println(dijkstra());
        }
}