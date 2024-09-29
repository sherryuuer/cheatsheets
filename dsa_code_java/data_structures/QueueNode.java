package dsa_code_java.data_structures;

public class QueueNode {
    int value;
    QueueNode next;
    QueueNode prev;

    public QueueNode(int value) {
        this.value = value;
        next = null;
        prev = null;
    }
}
