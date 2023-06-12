package 前缀和;

class TwoDPrefixArray {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] per = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                per[i][j] = per[i - 1][j] + per[i][j - 1] - per[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int l = j - k < 0 ? 0 : j - k;
                int r = j + k > n - 1 ? n : j + k + 1;
                int t = i - k < 0 ? 0 : i - k;
                int b = i + k > m - 1 ? m : i + 1 + k;
                ans[i][j] = per[b][r] - per[b][l] - per[t][r] + per[t][l];
            }
        }
        return ans;
    }
}