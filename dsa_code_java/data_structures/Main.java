package dsa_code_java.data_structures;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();

        System.out.println(queue.isEmpty()); // Output: true

        queue.append(1); // Should not return anything, output is null in test cases

        System.out.println(queue.isEmpty()); // Output: false
    }
}
