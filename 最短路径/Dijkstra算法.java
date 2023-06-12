package 最短路径;

import java.util.*;

public class Dijkstra算法 {
    // https://www.cnblogs.com/skywang12345/p/3711516.html
    /*
     * 思路：
     * 每次选取一个离出发点最近且未标记的节点，
     * 调整出发点到以这个节点为中心的周边节点的最短距离。
     * 这个过程持续 n - 1 次，直到所有节点都遍历完毕。
     * https://mrfzh.github.io/2020/03/06/Dijkstra%EF%BC%88%E8%BF%AA%E6%9D%B0%E6%96%
     * AF%E7%89%B9%E6%8B%89%EF%BC%89%E7%AE%97%E6%B3%95%E7%9A%84-java-%E5%AE%9E%E7%8E
     * %B0/
     */


    public static void main(String[] args) {
        int MAX = Integer.MAX_VALUE; // 无法到达时距离设为 Integer.MAX_VALUE
        int[][] weight = {
                { 0, 1, 12, MAX, MAX, MAX },
                { MAX, 0, 9, 3, MAX, MAX },
                { MAX, MAX, 0, MAX, 5, MAX },
                { MAX, MAX, 4, 0, 13, 15 },
                { MAX, MAX, MAX, MAX, 0, 4 },
                { MAX, MAX, MAX, MAX, MAX, 0 }
        };
        int start = 0; // 选择出发点
        System.out.println(Arrays.toString(dij(weight, start)));
    }

    private static int[] dij(int[][] weight, int start) {
        boolean[] visit = new boolean[weight.length]; // 标记某节点是否被访问过
        int[] res = new int[weight.length]; // 记录 start 点到各点的最短路径长度
        for (int i = 0; i < res.length; i++) {
            res[i] = weight[start][i];
        }

        // 查找 n - 1 次（n 为节点个数），每次确定一个节点
        for (int i = 1; i < weight.length; i++) {
            int min = Integer.MAX_VALUE;
            int p = 0;
            // 找出一个未标记的离出发点最近的节点
            for (int j = 0; j < weight.length; j++) {
                if (j != start && !visit[j] && res[j] < min) {
                    min = res[j];
                    p = j;
                }
            }
            // 标记该节点为已经访问过
            visit[p] = true;

            for (int j = 0; j < weight.length; j++) {
                if (j == p || weight[p][j] == Integer.MAX_VALUE) { // p 点不能到达 j
                    continue;
                }
                if (res[p] + weight[p][j] < res[j]) {
                    res[j] = res[p] + weight[p][j]; // 更新最短路径
                }
            }
        }

        return res;
    }
}