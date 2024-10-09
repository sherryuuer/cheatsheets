package dsa_code_java.data_structures;

import java.util.Map;
import java.util.HashMap;

public class UnionFind {
    Map<Integer, Integer> parent;
    Map<Integer, Integer> rank;

    public UnionFind(int n) {
        parent = new HashMap<>();
        rank = new HashMap<>();

        for (int i = 0; i < n + 1; i++) {
            parent.put(i, i);
            rank.put(i, 0);
        }
    }

    public int find(int n) {
        int p = parent.get(n);
        while (p != parent.get(p)) {
            parent.put(p, parent.get(parent.get(p)));
            p = parent.get(p);
        }
        return p;
    }

    public boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);

        if (p1 == p2) {
            return false;
        }

        if (rank.get(p1) > rank.get(p2)) {
            parent.put(p2, p1);
        } else if (rank.get(p1) < rank.get(p2)) {
            parent.put(p1, p2);
        } else {
            parent.put(p1, p2);
            rank.put(p2, rank.get(p2) + 1);
        }
        return true;
    }

}
