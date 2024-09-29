package dsa_code_java.data_structures;

public class DoublyLinkedList {
    DoublyLinkedListNode head;
    DoublyLinkedListNode tail;

    public DoublyLinkedList() {
        DoublyLinkedListNode head = new DoublyLinkedListNode(-1);
        DoublyLinkedListNode tail = new DoublyLinkedListNode(-1);
        head.next = tail;
        tail.prev = head;
    }

    public void insertFront(int val) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(val);
        newNode.next = head.next;
        newNode.prev = head;

        head.next.next.prev = newNode;
        head.next = newNode;

    }

    public void insertEnd(int val) {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(val);
        newNode.prev = tail.prev;
        newNode.next = tail;

        tail.prev.next = newNode;
        tail.prev = newNode;
    }

    public void removeFront() {
        head.next = head.next.next;
        head.next.next.prev = head;
    }

    public void removeEnd() {
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
    }

    public void print() {
        DoublyLinkedListNode curr = head.next;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println();
    }
}
