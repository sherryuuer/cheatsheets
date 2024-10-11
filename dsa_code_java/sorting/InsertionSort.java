package dsa_code_java.sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[] { 3, 7, 1, 10, 5, 4, 7 };
        insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    static void insertionSort(int[] arr) {
        // 一种不断插入有序array的过程
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                int tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
                j--;
            }
        }
    }
}
