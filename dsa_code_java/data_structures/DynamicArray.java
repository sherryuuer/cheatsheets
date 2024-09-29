package dsa_code_java.data_structures;

public class DynamicArray {
    int capacity;
    int length;
    int[] arr;

    public DynamicArray() {
        capacity = 2;
        length = 0;
        arr = new int[2];
    }

    public void resize() {
        capacity = 2 * capacity;
        int[] newArr = new int[capacity];

        for (int i = 0; i < length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public void pushback(int n) {
        if (length == capacity) {
            resize();
        }

        arr[length] = n;
        length++;
    }

    public void popback() {
        if (length > 0) {
            length--;
        }
    }

    public int get(int i) {
        if (i < length) {
            return arr[i];
        }
        return -1;
    }

    public void insert(int i, int n) {
        if (i < length) {
            arr[i] = n;
        }
    }

    public void printArr() {
        for (int i = 0; i < length; i++) {
            System.out.println(arr[i]);
        }
    }
}
