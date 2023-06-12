package 最短路径;

import java.util.*;

public class BellmanFord算法复杂版 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int vnum = 5;
		Graph graph = new Graph(vnum);
		Edge[] edges = new Edge[10];
		edges[0] = new Edge(0, 1, 6);
		edges[1] = new Edge(0, 3, 7);
		edges[2] = new Edge(1, 2, 5);
		edges[3] = new Edge(1, 3, 8);
		edges[4] = new Edge(1, 4, -4);
		edges[5] = new Edge(2, 1, -2);
		edges[6] = new Edge(3, 2, -3);
		edges[7] = new Edge(3, 4, 9);
		edges[8] = new Edge(4, 0, 2);
		edges[9] = new Edge(4, 2, 7);
		for (int i = 0; i < 10; i++) {
			graph.insertEdge(edges[i]);
		}
		graph.bianli();

		boolean success = graph.BELLMAN_FORD(0);
		if (success) {
			System.out.println("没有负环");
			graph.showResult();
		} else {
			System.out.println("存在负环");
		}

	}
}

class Graph {

	private LinkedList<Edge>[] edgeLinks;
	private int vNum; // 顶点数
	private int edgeNum; // 边数
	private int[] distance; // 存放v.d
	private int[] prenode; // 存放前驱节点
	public static final int INF = 10000; // 无穷大
	public static final int NIL = -1; // 表示不存在

	public Graph(int vnum) {
		this.vNum = vnum;
		edgeLinks = new LinkedList[vnum];
		edgeNum = 0;
		distance = new int[vnum];
		prenode = new int[vnum];
		for (int i = 0; i < vnum; i++)
			edgeLinks[i] = new LinkedList<>();
	}

	public void insertEdge(Edge edge) {
		int v1 = edge.getV1();
		edgeLinks[v1].add(edge);
		edgeNum++;
	}

	public void bianli() {
		System.out.println("共有 " + vNum + " 个顶点， " + edgeNum + " 条边");
		for (int i = 0; i < vNum; i++) {
			LinkedList<Edge> list = (LinkedList<Edge>) edgeLinks[i].clone();
			while (!list.isEmpty()) {
				Edge edge = list.pop();
				System.out.println(edge.toString());
			}
		}
	}

	/**
	 * 对最短路径估计和前驱节点进行初始化
	 * 
	 * @param start
	 */
	public void INITIALIZE_SINGLE_SOURCE(int start) {
		for (int i = 0; i < vNum; i++) {
			distance[i] = INF;
			prenode[i] = NIL;
		}
		distance[start] = 0;
	}

	/**
	 * 松弛
	 * 
	 * @param edge
	 */
	public void RELAX(Edge edge) {
		int v1 = edge.getV1();
		int v2 = edge.getV2();
		int w = edge.getWeight();
		if (distance[v2] > distance[v1] + w) {
			distance[v2] = distance[v1] + w;
			prenode[v2] = v1;
		}
	}

	/**
	 * Bellman-Ford算法实现
	 * 
	 * @return 是否没有负环
	 */
	public boolean BELLMAN_FORD(int start) {

		INITIALIZE_SINGLE_SOURCE(start);
		for (int i = 0; i < vNum - 1; i++) {
			for (int j = 0; j < vNum; j++) {
				LinkedList<Edge> list = (LinkedList<Edge>) edgeLinks[j].clone();
				while (!list.isEmpty()) {
					Edge edge = list.pop();
					RELAX(edge);
				}
			}
		}

		for (int i = 0; i < vNum; i++) {
			LinkedList<Edge> list = (LinkedList<Edge>) edgeLinks[i].clone();
			while (!list.isEmpty()) {
				Edge edge = list.pop();
				int v1 = edge.getV1();
				int v2 = edge.getV2();
				int w = edge.getWeight();
				if (distance[v2] > distance[v1] + w)
					return false;
			}
		}

		return true;
	}

	/**
	 * 显示结果
	 */
	public void showResult() {
		Stack<Integer>[] routes = new Stack[vNum];
		for (int i = 0; i < vNum; i++) {
			routes[i] = new Stack<>();
			int j = i;
			while (j != NIL) {
				routes[i].push(j);
				j = prenode[j];
			}

			System.out.print(i + "(" + distance[i] + ") : ");
			while (!routes[i].isEmpty()) {
				int k = routes[i].pop();
				System.out.print("-->" + k);
			}
			System.out.println();
		}
	}

	public int[] getDistance() {
		return distance;
	}

	public int[] getPrenode() {
		return prenode;
	}

}

class Edge {

	private int v1;
	private int v2;
	private int weight;

	public Edge(int v1, int v2, int weight) {
		this.v1 = v1;
		this.v2 = v2;
		this.weight = weight;
	}

	public boolean equals(Edge edge) {
		return this.v1 == edge.getV1() && this.v2 == edge.getV2() && this.weight == edge.getWeight();
	}

	public int getV1() {
		return v1;
	}

	public int getV2() {
		return v2;
	}

	public int getWeight() {
		return weight;
	}

	public String toString() {
		String str = "[ " + v1 + " , " + v2 + " , " + weight + " ]";
		return str;
	}

}