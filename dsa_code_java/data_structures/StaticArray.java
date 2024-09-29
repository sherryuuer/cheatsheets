package dsa_code_java.data_structures;

public class StaticArray {
    public void insertEnd(int[] arr, int n, int length, int capacity) {
        if (length < capacity) {
            arr[length] = n;
        }
    }

    public void removeEnd(int[] arr, int length) {
        if (length > 0) {
            arr[length - 1] = 0;
            length--;
        }
    }

    public void insertMiddle(int[] arr, int idx, int n, int length) {
        for (int i = length - 1; i > idx - 1; i--) {
            arr[i + 1] = arr[i];
        }

        arr[idx] = n;
    }

    public void removeMiddle(int[] arr, int idx, int length) {
        for (int i = idx; i < length - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    public void printArr(int[] arr, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
