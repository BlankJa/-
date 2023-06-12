package 滑动窗口;

import java.util.*;

public class LargestRectangleinHistogram {
    public static void main(String[] args) {
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        Solution solu = new Solution();
        int res = solu.largestRectangleArea(heights);
        System.out.println(res);
        // int n = heights.length;
        // int[] left = new int[n];
        // int[] right = new int[n];
        // Stack<Integer> stack = new Stack<>();

        // for(int i= 0; i<n;i++){
        // while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
        // stack.pop();
        // left[i] = stack.isEmpty()? -1: stack.peek();
        // stack.push(i);
        // }
        // stack.clear();
        // for(int i= n-1;i>=0;i--){
        // while(!stack.isEmpty() && heights[stack.peek()] >= heights[i])
        // stack.pop();
        // right[i] = stack.isEmpty()? n: stack.peek();
        // stack.push(i);
        // }
        // int ans = 0;
        // for(int i =0;i<n-1;i++){
        // ans = Math.max(ans,(right[i]-left[i]-1)*heights[i]);
        // }
        // System.out.println(ans);

    }
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        Deque<Integer> que = new ArrayDeque<>();
        int max = -1;
        Arrays.fill(right, heights.length);
        for (int i = 0; i < heights.length; i++) {
            while (!que.isEmpty() && heights[i] > heights[que.peek()]) {
                right[que.poll()] = i;
            }
            left[i] = que.isEmpty() ? -1 : que.peek();
            que.push(i);
        }
        for (int i = 0; i < heights.length; i++) {
            int cur = (right[i] - left[i] - 1) * heights[i];
            if (cur > max) {
                max = cur;
            }
        }
        return max;
    }
}
