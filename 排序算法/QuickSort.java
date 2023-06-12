package 排序算法;

/**
 * 快速排序(Quick Sort) Java代码实现
 * 快排时间复杂度：n*log(n)
 */

public class QuickSort {

    public static void main(String args[]) {
        int[] arr = new int[] { 49, 38, 65, 97, 76, 13, 27 };
        QuickSort mySort = new QuickSort();

        System.out.print("排序前的数组： ");
        PrintArray(arr, 0, arr.length - 1);
        mySort.quickSort(arr, 0, arr.length - 1);

        System.out.print("排序后的结果： ");
        PrintArray(arr, 0, arr.length - 1);
    }

    /**
     * 对数组 arr 下标从 start 到 end 的内容进行排序
     * 
     * @param arr：待排序数组
     * @param start：开始的下标
     * @param end：结束的下标
     */
    public void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        // 1. 设两个指针 low 和 high ，他们的初始值分别为数组开始的下标 start，数组结束的下标end
        int low = start;
        int high = end;

        // 2. 枢轴值为 pivotKey
        int pivotKey = arr[start];

        // 5. 重复前两步操作（3，4），直至 low == high
        while (low < high) {

            // 3. 首先从 high 所指位置向前搜索，搜索到第一个小于 pivotKey 的 值，然后将这个值和 pivotKey 互相交换
            while (low < high && arr[high] >= pivotKey) {
                --high;
            }
            int temp1 = arr[low];
            arr[low] = arr[high];
            arr[high] = temp1;

            // 4. 从 low 所指位置向后搜索，搜索到第一个大于 pivotKey 的 值，然后将这个值和 pivotKey 互相交换。
            while (low < high && arr[low] <= pivotKey) {
                ++low;
            }
            temp1 = arr[low];
            arr[low] = arr[high];
            arr[high] = temp1;
        }

        // 对 小于枢轴值的那部分数组值 进行快排
        quickSort(arr, start, low - 1);
        // 对 大于枢轴值的那部分数组值 进行快排
        quickSort(arr, low + 1, end);
    }

    /**
     * 输出数组中的值
     * 
     * @param arr：数组
     * @param start：数组开始的下标
     * @param end：数组结束的下标
     */
    public static void PrintArray(int[] arr, int start, int end) {

        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
}