package 前缀和.SparseTable;

public class SparseTable {
    static int n, m;
    static int[][] st;
    static int[] nums;

    public static void main(String[] argd) {
        nums = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        n = nums.length;
        m = (int) (Math.log(n) / Math.log(2));
        st = new int[n][m + 1];

    }

    static void init() {
        for (int i = 0; i < n; i++) {
            st[i][0] = nums[i];
        }
        for (int j = 1; (1 << j) < n; j++) {
            for (int i = 0; i < n; i++) {
                st[i][j] = Math.min(st[i][j - 1], st[i + (1 << j - 1)][j - 1]);
            }
        }
    }

    static int query(int l, int r) {
        int k = (int) (Math.log(r - l + 1) / Math.log(2));
        return Math.min(st[l][k], st[r - (1 << k) + 1][k]);
    }
}
