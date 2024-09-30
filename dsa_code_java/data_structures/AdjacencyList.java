package dsa_code_java.data_structures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

// adjList的一个好处是没有很多edge case，比如不会出界
// 注意这是一个没有weight的结构
public class AdjacencyList {
    public HashMap<String, ArrayList<String>> buildAdjList() {
        HashMap<String, ArrayList<String>> adjList = new HashMap<>();
        String[][] edges = { { "A", "B" }, { "B", "C" }, { "B", "E" }, { "C", "E" }, { "E", "D" } };

        for (String[] edge : edges) {
            String src = edge[0];
            String dst = edge[1];
            if (!adjList.containsKey(src)) {
                adjList.put(src, new ArrayList<>());
            }
            if (!adjList.containsKey(dst)) {
                adjList.put(dst, new ArrayList<>());
            }
            adjList.get(src).add(dst);
        }

        return adjList;
    }

    // count paths (backtracking)
    public int dfs(String node, String target, HashMap<String, ArrayList<String>> adjList, HashSet<String> visit) {
        if (visit.contains(node)) {
            return 0;
        }
        if (node == target) {
            return 1;
        }
        int count = 0;
        visit.add(node);
        for (String neighbor : adjList.get(node)) {
            count += dfs(neighbor, target, adjList, visit);
        }
        visit.remove(node);
        return count;
    }

    // shortest path from node to target
    public int bfs(String node, String target, HashMap<String, ArrayList<String>> adjList) {
        int length = 0;
        HashSet<String> visit = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visit.add(node);
        queue.add(node);

        while (queue.size() != 0) {
            for (int i = 0; i < queue.size(); i++) {
                String curr = queue.peek();
                queue.poll();
                if (curr == target) {
                    return length;
                }
                for (String neighbor : adjList.get(curr)) {
                    if (!visit.contains(neighbor)) {
                        visit.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            length++;
        }

        return length;
    }
}
