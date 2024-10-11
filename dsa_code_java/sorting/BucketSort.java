package dsa_code_java.sorting;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class BucketSort {
    public static void main(String[] args) {
        int[] arr = new int[] { 2, 1, 2, 0, 0, 2 };
        int[] res = bucketSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(res));
    }

    public static int[] bucketSort(int[] arr) {
        Set<Integer> uniqueElements = new HashSet<>();
        for (int num : arr) {
            uniqueElements.add(num);
        }
        int countsNum = uniqueElements.size();
        int[] counts = new int[countsNum + 1];

        for (int n : arr) {
            counts[n]++;
        }

        int i = 0; // index for arr
        for (int n = 0; n < counts.length; n++) {
            for (int j = 0; j < counts[n]; j++) {
                arr[i] = n;
                i++;
            }
        }

        return arr;
    }
}

// check the python logic is very simple
