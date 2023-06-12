package 最小生成树;
//思路：先把所有边按照权值从小到大排序

//枚举每条边a，b和权重w，
//如果a，b不连通，则将这条边加入到集合中

import java.util.Arrays;
import java.util.Scanner;

class Node implements Comparable<Node> {
        int a;
        int b;
        int w;

        public Node(int a, int b, int w) {
                this.a = a;
                this.b = b;
                this.w = w;
        }

        @Override
        public int compareTo(Node o) {
                return this.w - o.w;
        }
}

public class 最小生成树模板 {
        static final int N = 100005;
        static int p[] = new int[N];
        static Node node[] = new Node[2 * N];
        static int n, m;

        static int find(int x) {
                if (p[x] != x)
                        p[x] = find(p[x]);
                return p[x];
        }

        public static void main(String[] args) {
                Scanner scan = new Scanner(System.in);
                n = scan.nextInt();
                m = scan.nextInt();
                for (int i = 0; i < m; i++) {
                        int a = scan.nextInt();
                        int b = scan.nextInt();
                        int w = scan.nextInt();
                        node[i] = new Node(a, b, w);
                }
                Arrays.sort(node, 0, m);
                for (int i = 1; i <= n; i++)
                        p[i] = i;
                int res = 0, cnt = 0;
                for (int i = 0; i < m; i++) {
                        int a = node[i].a;
                        int b = node[i].b;
                        if (find(a) != find(b)) {
                                res += node[i].w;
                                cnt++;
                                p[find(a)] = b;
                        }
                }
                // n个点由n-1条边连着
                if (cnt != n - 1)
                        System.out.println("impossible");
                else
                        System.out.println(res);
        }
}