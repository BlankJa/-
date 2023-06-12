public class RangeQuery {
    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] arr1 = new int[10];
        arr1[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr1[i] = arr1[i - 1] + arr[i];
        }
        int left = 2;
        int right = 5;
        int sum = arr1[right] - arr1[left - 1];
        System.out.println(sum);
    }
}