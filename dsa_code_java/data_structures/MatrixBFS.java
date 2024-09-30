package dsa_code_java.data_structures;

import java.util.Deque;
import java.util.ArrayDeque;
import java.lang.Math;

// shortest path
// 同样的一道题，可以用DFS来解答，但是需要求出所有的方案，然后找到最短的，这就成了一个暴力解法
public class MatrixBFS {
    // Matrix (2D Grid)
    int[][] grid = { { 0, 0, 0, 0 },
            { 1, 1, 0, 0 },
            { 0, 0, 0, 1 },
            { 0, 1, 0, 0 } };

    public int bfs(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        int[][] visit = new int[ROWS][COLS];

        int length = 0;
        queue.add(new int[] { 0, 0 });
        visit[0][0] = 1;

        while (!queue.isEmpty()) {
            int queueLength = queue.size();
            for (int i = 0; i < queueLength; i++) {
                int[] pair = queue.poll();
                int r = pair[0];
                int c = pair[1];

                if (r == ROWS - 1 && c == COLS - 1) {
                    return length;
                }

                int[][] directions = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
                for (int[] direction : directions) {
                    int newR = r + direction[0];
                    int newC = c + direction[1];

                    if (Math.min(newR, newC) < 0 || newR == ROWS || newC == COLS ||
                            visit[newR][newC] == 1 || grid[newR][newC] == 1) {
                        continue;
                    }
                    queue.add(new int[] { newR, newC });
                    visit[newR][newC] = 1;

                }
            }
            length++;
        }

        return -1;

    }
}
