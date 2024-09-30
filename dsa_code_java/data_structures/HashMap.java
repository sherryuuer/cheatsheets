package dsa_code_java.data_structures;

public class HashMap {
    int size;
    int capacity;
    Pair[] map;

    public HashMap(int size, int capacity) {
        this.size = size;
        this.capacity = capacity;
        this.map = new Pair[capacity];
    }

    public int hash(String key) {
        int index = 0;
        for (int i = 0; i < key.length(); i++) {
            index += (int) key.charAt(i);
        }
        return index % capacity;
    }

    public String get(String key) {
        int index = hash(key);

        while (map[index] != null) {
            if (map[index].key == key) {
                return map[index].val;
            }
            index++;
            index = index % capacity;
        }

        return null;
    }

    public void put(String key, String val) {
        int index = hash(key);

        while (true) {
            if (map[index] == null) {
                map[index] = new Pair(key, val);
                size++;
                if (size >= capacity / 2) {
                    rehash();
                }
                return;
            } else if (map[index].key == key) {
                map[index].val = val;
                return;
            }

            index++;
            index = index & capacity;
        }

    }

    // 当我们resize一个hashmap的时候我们不能把元素留在原地而是rehash！他们
    public void rehash() {
        int newCapacity = capacity * 2;
        Pair[] oldMap = this.map;
        this.map = new Pair[newCapacity];
        for (Pair pair : oldMap) {
            put(pair.key, pair.val);
        }

    }

}
