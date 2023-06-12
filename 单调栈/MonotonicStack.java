package 单调栈;

import java.util.*;

public class MonotonicStack {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 4, 7, 2 };
        int[] ans = bf(nums);
        for (int i : ans) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] bf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    ans[i] = nums[j];
                    break;
                }
            }
        }
        return ans;
    }

    public static int[] nextBiggerNumReverse(int[] nums) {
        int[] res = new int[nums.length];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] >= nums[st.peek()]) {
                st.poll();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return res;
    }

    public static int[] nextBiggerNum(int[] nums) {
        int[] res = new int[nums.length];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // 单调递减
            while (!st.isEmpty() && nums[i] >= nums[st.peek()]) {
                res[st.poll()] = nums[i];
            }
            // 存下标index
            st.push(i);
        }
        while (!st.isEmpty()) {
            res[st.poll()] = -1;
        }
        // 此时，stack中可能还有数据，里面的数据都是右边没有更大下标的数据，可再用一个循环处理。
        // 如果res已设置好没有更大元素时的默认值，那么这个循环可以省略。
        return res;
    }

    // 双向monotonic stack
    public static int[] range(int[] nums) {
        int[] resLeft = new int[nums.length];
        int[] resRight = new int[nums.length];
        Arrays.fill(resRight, -1);
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i--) {
            while (!st.isEmpty() && nums[i] >= nums[st.peek()]) {
                resRight[st.poll()] = nums[i];
            }
            resLeft[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return resLeft;
    }
}
