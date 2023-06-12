package 最短路径;

import java.util.*;

/*
https://www.cnblogs.com/skywang12345/p/3711532.html
 * 通过Floyd计算图G=(V,E)中各个顶点的最短路径时，
 * 需要引入一个矩阵S，矩阵S中的元素a[i][j]表示
 * 顶点i(第i个顶点)到顶点j(第j个顶点)的距离。

    假设图G中顶点个数为N，则需要对矩阵S进行N次更新。
    初始时，矩阵S中顶点a[i][j]的距离为顶点i到顶点j的权值；
    如果i和j不相邻，则a[i][j]=∞。 接下来开始，对矩阵S进行N次更新。
    第1次更新时，如果"a[i][j]的距离" > "a[i][0]+a[0][j]"(a[i][0]+a[0][j]
    表示"i与j之间经过第1个顶点的距离")，则更新a[i][j]为"a[i][0]+a[0][j]"。
     同理，第k次更新时，如果"a[i][j]的距离" > "a[i][k]+a[k][j]"，
     则更新a[i][j]为"a[i][k]+a[k][j]"。更新N次之后，操作完成！
 */

/*
 * 算法步骤如下：

1、初始化矩阵。



2、选取0号节点作为中间点，初始化矩阵。



3、选取1号节点作为中间点，更新矩阵，通过两层循环计算(i->1)，
(1->j)的路径是否比目前i到j的路径长度更短。此时可以将矩阵数值看作是将0、
1作为中间点获得的多源最短路径长度。



4、选取2号节点作为中间点，更新矩阵，通过两层循环计算(i->2)，(2->j)
的路径是否比目前i到j的路径长度更短。此时可以将矩阵数值看作是将0、1、2
作为中间点获得的多源最短路径长度。



5、选取3号节点作为中间点，更新矩阵，通过两层循环计算(i->3)，(1->3)
的路径是否比目前i到j的路径长度更短。
此时可以将矩阵数值看作是将0、1、2、3为中间点获得的多源最短路径长度。



6、选取4号节点作为中间点，更新矩阵，通过两层循环计算(i->4)，(4->j)
的路径是否比目前i到j的路径长度更短。此时可以将矩阵数值看作是将0、1、2、3、4
作为中间点获得的多源最短路径长度。



7、选取5号节点作为中间点，更新矩阵，通过两层循环计算(i->5)，(5->j)
的路径是否比目前i到j的路径长度更短。此时可以将矩阵数值看作是将0、
1、2、3、4、5作为中间点获得的多源最短路径长度。



8、选取6号节点作为中间点，更新矩阵，通过两层循环计算(i->6)，(6->j)
的路径是否比目前i到j的路径长度更短。
此时可以将矩阵数值看作是将所有节点作为中间点获得的多源最短路径长度，
遍历结束，得到最后结果。

原文链接：https://blog.csdn.net/qq_34842671/article/details/90637502
 */
public class Floyd算法 {
    public static int MaxValue = 100000;
    public static int[][] path;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入顶点数和边数:");
        // 顶点数
        int vertex = input.nextInt();
        // 边数
        int edge = input.nextInt();

        int[][] matrix = new int[vertex][vertex];
        // 初始化邻接矩阵
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                matrix[i][j] = MaxValue;
            }
        }

        // 初始化路径数组
        path = new int[matrix.length][matrix.length];

        // 初始化边权值
        for (int i = 0; i < edge; i++) {
            System.out.println("请输入第" + (i + 1) + "条边与其权值:");
            int source = input.nextInt();
            int target = input.nextInt();
            int weight = input.nextInt();
            matrix[source][target] = weight;
        }

        // 调用算法计算最短路径
        floyd(matrix);
    }

    // 非递归实现
    public static void floyd(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                path[i][j] = -1;
            }
        }

        for (int m = 0; m < matrix.length; m++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][m] + matrix[m][j] < matrix[i][j]) {
                        matrix[i][j] = matrix[i][m] + matrix[m][j];
                        // 记录经由哪个点到达
                        path[i][j] = m;
                    }
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i != j) {
                    if (matrix[i][j] == MaxValue) {
                        System.out.println(i + "到" + j + "不可达");
                    } else {
                        System.out.print(i + "到" + j + "的最短路径长度是：" + matrix[i][j]);
                        System.out.print("最短路径为：" + i + "->");
                        findPath(i, j);
                        System.out.println(j);
                    }
                }
            }
        }
    }

    // 递归寻找路径
    public static void findPath(int i, int j) {
        int m = path[i][j];
        if (m == -1) {
            return;
        }

        findPath(i, m);
        System.out.print(m + "->");
        findPath(m, j);
    }
}
