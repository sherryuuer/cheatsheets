package dsa_code_java.data_structures;

public class HashTable {
    private int capacity;
    private int size;
    private HashTableNode[] table;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.table = new HashTableNode[this.capacity];
    }

    public int getHashIndex(int key) {
        return key % capacity;
    }

    public void insert(int key, int value) {
        int index = getHashIndex(key);
        HashTableNode node = table[index];
        HashTableNode prev = null;

        if (node == null) {
            table[index] = new HashTableNode(key, value);
            size++;
        } else {
            while (node != null) {
                if (node.key == key) {
                    node.value = value;
                    return;
                }
                prev = node; // prev node is for storing the node before current node
                node = node.next;
            }
            prev.next = new HashTableNode(key, value);
            size++;
        }

        if (size >= capacity * 0.5) {
            resize();
        }
    }

    public int get(int key) {
        int index = getHashIndex(key);
        HashTableNode node = table[index];

        while (node != null) {
            if (node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }

    public boolean remove(int key) {
        int index = getHashIndex(key);
        HashTableNode node = table[index];
        HashTableNode prev = null;

        while (node != null) {
            if (node.key == key) {
                if (prev != null) {
                    prev.next = node.next;
                } else {
                    table[index] = node.next;
                }
                size--;
                return true;
            }
            prev = node;
            node = node.next;
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void resize() {
        int newCapacity = capacity * 2;
        HashTableNode[] newTable = new HashTableNode[newCapacity];

        for (HashTableNode node : table) {
            while (node != null) {
                int index = node.key % newCapacity;
                if (newTable[index] == null) {
                    newTable[index] = new HashTableNode(node.key, node.value); // must create a new one!
                } else {
                    HashTableNode currNode = newTable[index];
                    while (currNode.next != null) {
                        currNode = currNode.next;
                    }
                    currNode.next = new HashTableNode(node.key, node.value);
                }
                node = node.next; // while condition
            }
        }
        capacity = newCapacity;
        table = newTable;
    }
}
