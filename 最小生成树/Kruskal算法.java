package 最小生成树;

// https://www.cnblogs.com/skywang12345/p/3711504.html
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
/*
 * kruskal算法其实也是和prim算法一样求无向图的最小生成树，
 * 也属于贪心算法，不过prim算法的复杂度为O(n^2)，适用于稠密图，
 * 而kruskal算法的复杂度为O(eloge)，适用于稀疏图。
 */

/*
1.设连通网N=(V,{E})，令最小生成树初始状态为只有n个顶点而无边的非连通图T=(V,{F})，
每个顶点自成一个连通分量

2.在E中选取代价最小的边，加入到T中,若它的添加使T 中产生回路，则舍去此边，
选取下一条代价最小的边

3.依此类推，直至T中有 n-1 条边为止

Kruskal算法牵涉到集合操作，包括集合的建立和集合的合并，这里用并查集解决。

初始化：把每个节点所在结合初始化为自身。
查找：查找元素所在的集合，即根节点
合并：将两个在不同集合的元素合并为一个集合，应将树深度小的合并到深
度大的上面或将子孙少的合并到子孙多的上面。

 */
public class Kruskal算法 {
    private int father[];
    private int son[];
    private Edge e[];
    private int n;// 结点个数
    private int l;// 边的数目

    public Kruskal算法(int n, int l, Edge[] e) {
        this.n = n;
        this.l = l;
        this.e = e;
        father = new int[n];
        son = new int[n];
        for (int i = 0; i < n; ++i) {
            father[i] = i;// 将每个顶点初始化为一个集合，父节点指向自己。
            son[i] = 1;// 初始化每个父节点的儿子数为1
        }
    }

    public int unionsearch(int x) { // 查找根结点
        return (x == father[x]) ? x : unionsearch(father[x]);
    }

    public boolean join(int x, int y) { // 合并
        int root1, root2;
        root1 = unionsearch(x);
        root2 = unionsearch(y);
        if (root1 == root2) { // 为环
            return false;
        } else if (son[root1] >= son[root2]) {
            father[root2] = root1;
            son[root1] += son[root2];
        } else {
            father[root1] = root2;
            son[root2] += son[root1];
        }
        return true;
    }

    public int kruskal() {
        int ans = 0;
        int ltotal = 0;

        Arrays.sort(e); // 按权值由小到大排序
        for (int i = 0; i < l; ++i) {
            if (join(e[i].a, e[i].b) == true) {
                ltotal++; // 边数加1
                ans = e[i].weight; // 记录

            }
            if (ltotal == n - 1) // 最小生成树条件：边数=顶点数-1
            {

                return ans;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int temp = 0;
        int T = in.nextInt();
        while ((T--) > 0) {
            int k = 0;
            int n = in.nextInt();
            Edge[] e = new Edge[n * (n - 1) / 2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i < j) {// 只读取上三角
                        e[k] = new Edge(i, j, in.nextInt());
                        k++;
                    } else {
                        temp = in.nextInt();
                    }

                }
            }
            Kruskal算法 m = new Kruskal算法(n, k, e);
            System.out.printf("%d\n", m.kruskal());
        }

    }
}

class Edge implements Comparable {
    int a; // 边的一个顶点，从数字0开始
    int b; // 边的另一个顶点
    int weight; // 权重

    Edge(int a, int b, int weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {
        Edge m = (Edge) o;
        int result = (int) (this.weight - m.weight);
        if (result > 0)
            return 1;
        else if (result == 0)
            return 0;
        else
            return -1;
    }

}