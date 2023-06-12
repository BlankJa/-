package DFS;

public class DFS {
    public static char[][] water;
    public static int[][] dir = {
            { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 },
            { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 }
    };
    public static int m, n;

    public static void main(String[] args) {

    }

    public static void dfs(int r, int c) {
        for (int i = 0; i < 8; i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && water[nr][nc] == 'W') {
                water[nr][nc] = '.';
                dfs(nr, nc);
            }
        }
    }

}
