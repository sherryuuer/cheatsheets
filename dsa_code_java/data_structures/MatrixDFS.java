package dsa_code_java.data_structures;

import java.lang.Math;
import java.util.HashSet;

// count paths (backtracking)
// public class MatrixDFS {
//     public int dfs(int[][] grid, int r, int c, int[][] visit) {
//         int ROWS = grid.length;
//         int COLS = grid[0].length;

//         if (Math.min(r, c) < 0 || r == ROWS || c == COLS ||
//                 grid[r][c] == 1 || visit[r][c] == 1) {
//             return 0;
//         }
//         if (r == ROWS - 1 && c == COLS - 1) {
//             return 1;
//         }

//         visit[r][c] = 1;
//         int count = 0;
//         count += dfs(grid, r + 1, c, visit);
//         count += dfs(grid, r - 1, c, visit);
//         count += dfs(grid, r, c + 1, visit);
//         count += dfs(grid, r, c - 1, visit);

//         visit[r][c] = 0;
//         return count;
//     }
// }

public class MatrixDFS {
    public int dfs(int[][] grid, int r, int c, HashSet<String> visit) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        if (Math.min(r, c) < 0 || r == ROWS || c == COLS ||
                grid[r][c] == 1 || visit.contains(r + "," + c)) {
            return 0;
        }
        if (r == ROWS - 1 && c == COLS - 1) {
            return 1;
        }

        // visit[r][c] = 1;
        visit.add(r + "," + c);
        int count = 0;

        int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int[] direction : directions) {
            count += dfs(grid, r + direction[0], c + direction[1], visit);
        }

        // visit[r][c] = 0;
        visit.remove(r + "," + c);
        return count;
    }
}
