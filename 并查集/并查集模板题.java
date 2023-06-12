package 并查集;

import java.util.*;
import java.io.*;

//题目 ： https://www.luogu.com.cn/problem/P1551
public class 并查集模板题 {
    static int n, m, p;
    static int[] fa, ranks;

    public static void main(String[] args) {
        Input input = new Input();
        n = input.nextInt();
        m = input.nextInt();
        p = input.nextInt();

        // init
        fa = new int[n + 1];// fa[i]表示i的父节点
        ranks = new int[n + 1];
        for (int i = 1; i <= n; i++) { // 初始化，每个节点的父节点都是自己
            fa[i] = i;
            ranks[i] = 1;
        }

        // input
        int x, y;// x,y表示两个节点
        for (int i = 0; i < m; i++) {
            x = input.nextInt();
            y = input.nextInt();
            merge(x, y);// 合并
        }

        // query
        for (int i = 0; i < p; i++) {
            x = input.nextInt();
            y = input.nextInt();
            if (find(x) == find(y)) {// 如果x,y的父节点相同，说明x,y在同一个集合中
                System.out.println("Yes");// 输出Yes
            } else {// 否则不在同一个集合中
                System.out.println("No");// 输出No
            }
        }
    }

    static int find(int x) {
        if (fa[x] == x)
            return x;// 如果x的父节点是自己，那么x就是根节点
        fa[x] = find(fa[x]);// 否则，x的父节点就是x的根节点
        return fa[x];
        // return fa[x] == x ? x : (fa[x] = find(fa[x]));
        // 上面这句话是上面两句话的简写
    }

    static void merge(int x, int y) {
        int fx = find(x);// 找到x的祖先
        int fy = find(y);// 找到y的祖先
        if (fx == fy)
            return;// 如果x,y的祖先相同，说明x,y在同一个集合中，不需要合并
        if (ranks[fx] == ranks[fy]) {// 如果x和y的祖先相同，就合并
            fa[fy] = fx;// 将x的祖先的父节点设置为y的祖先
            ranks[fx]++;// 合并
        } else if (ranks[fx] > ranks[fy]) {// 如果x的祖先的秩大于y的祖先的秩
            fa[fy] = fx;// 将y的祖先的父节点设置为x的祖先
        } else {// 如果y的祖先的秩大于x的祖先的秩
            fa[fx] = fy;// 将x的祖先的父节点设置为y的祖先
        }
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