package dsa_code_java.sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[] { 3, 5, 7, 1, 2, 6, 8, 9 };
        arr = mergeSort(arr);
        for (int n : arr) {
            System.out.print(n + " ");
        }
        // Add this to print a new line after array output
        System.out.println();
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }
        // Find the middle point
        int mid = arr.length / 2;

        // Create subarrays for left and right halves
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        // Fill left and right subarrays
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int resIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                result[resIndex] = left[leftIndex];
                resIndex++;
                leftIndex++;
            } else {
                result[resIndex] = right[rightIndex];
                resIndex++;
                rightIndex++;
            }
        }

        while (leftIndex < left.length) {
            result[resIndex] = left[leftIndex];
            resIndex++;
            leftIndex++;
        }

        while (rightIndex < right.length) {
            result[resIndex] = right[rightIndex];
            resIndex++;
            rightIndex++;
        }

        return result;

    }
}
