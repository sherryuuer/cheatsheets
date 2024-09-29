package dsa_code_java.data_structures;

public class DoublyLinkedListNode {
    int val;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int val) {
        this.val = val;
        next = null;
        prev = null;
    }
}
