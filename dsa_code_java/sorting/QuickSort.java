package dsa_code_java.sorting;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[] { 3, 5, 7, 1, 2, 6, 8, 9 };
        quickSort(arr, 0, arr.length - 1);
        for (int n : arr) {
            System.out.print(n + " ");
        }
        // Add this to print a new line after array output
        System.out.println();
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (end - start + 1 <= 1) {
            return;
        }

        int partitionIndex = partition(arr, start, end);
        quickSort(arr, start, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, end);
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int left = start;

        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                int temp = arr[j];
                arr[j] = arr[left];
                arr[left] = temp;
                left++;
            }
        }

        arr[end] = arr[left];
        arr[left] = pivot;

        return left;
    }
}
