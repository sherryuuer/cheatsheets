package dsa_code_java.data_structures;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        MatrixDFS mdfs = new MatrixDFS();
        int[][] grid = new int[][] { {} };
        int count = mdfs.dfs(grid, 0, 0, new HashSet<>());
        System.out.println(count);
    }
}
