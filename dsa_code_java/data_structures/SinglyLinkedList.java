package dsa_code_java.data_structures;

public class SinglyLinkedList {
    SinglyLinkedListNode head;
    SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        head = new SinglyLinkedListNode(-1);
        tail = head;
    }

    public int get(int index) {
        // 这个index不是内部定义的，是人数出来的
        SinglyLinkedListNode curr = head.next;
        int i = 0;
        while (curr != null) {
            if (i == index) {
                return curr.val;
            }
            i++;
            curr = curr.next;
        }
        return -1;
    }

    public void insertHead(int val) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(val);
        newNode.next = this.head.next;
        this.head.next = newNode;
        if (newNode.next == null) {
            this.tail = newNode;
        }

    }

    public void insertTail(int val) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(val);
        this.tail.next = newNode;
        this.tail = tail.next;
    }

    public boolean remove(int index) {
        int i = 0;
        SinglyLinkedListNode curr = head;
        while (i < index && curr != null) {
            i++;
            curr = curr.next; // 循环停止的时候curr正好处于index的前一个位置，这是因为head是一个dummy节点
        }

        // 目的是删除curr的下一个节点
        if (curr != null && curr.next != null) {
            if (curr.next == tail) {
                tail = curr; // 这时候删除的就是tail
                return true;
            }
            curr.next = curr.next.next;
            return true;
        }

        return false;
    }

    public void print() {
        SinglyLinkedListNode curr = head.next;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println();
    }
}
