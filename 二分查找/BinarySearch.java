package 二分查找;

import java.util.*;

public class BinarySearch {
    public static void main(String[] agrs) {

        Scanner sc = new Scanner(System.in);

        // 二分查找
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int target = 5;
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == target) {
                System.out.println(mid);
                break;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // 位移查找
        int n = sc.nextInt();
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }
        int target2 = sc.nextInt();

        int l = 0, r = n - 1;
        while (l < r) {
            int mid2 = l + r >> 1;
            if (arr[mid2] >= target2)
                r = mid2;
            else
                l = mid2 + 1;
        }

        if (arr2[l] != target2)
            System.out.println(-1);
        else
            System.out.println(l);

    }

}