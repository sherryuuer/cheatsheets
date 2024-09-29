package dsa_code_java.data_structures;

// Double ended queue implementation
public class Queue {
    private QueueNode dummyHead;
    private QueueNode dummyTail;

    public Queue() {
        this.dummyHead = new QueueNode(-1);
        this.dummyTail = new QueueNode(-1);

        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public boolean isEmpty() {
        return this.dummyHead.next == this.dummyTail;
    }

    public void append(int value) {
        QueueNode newNode = new QueueNode(value);
        newNode.next = dummyTail;
        newNode.prev = dummyTail.prev;
        dummyTail.prev.next = newNode;
        dummyTail.prev = newNode;
    }

    public void appendLeft(int value) {
        QueueNode newNode = new QueueNode(value);
        newNode.prev = dummyHead;
        newNode.next = dummyHead.next;
        dummyHead.next.prev = newNode;
        dummyHead.next = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        QueueNode poped = dummyTail.prev;
        poped.prev.next = dummyTail;
        dummyTail.prev = poped.prev;
        return poped.value;
    }

    public int popLeft() {
        if (isEmpty()) {
            return -1;
        }
        QueueNode poped = dummyHead.next;
        poped.next.prev = dummyHead;
        dummyHead.next = poped.next;
        return poped.value;
    }
}
