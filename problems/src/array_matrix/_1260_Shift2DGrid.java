package array_matrix;

//https://leetcode.com/problems/shift-2d-grid/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1260_Shift2DGrid {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] newGrid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int nextI = (i + (j + k) / n) % m;
                int nextJ = (j + k) % n;
                newGrid[nextI][nextJ] = grid[i][j];
            }
        }

        return (List) Arrays.asList(newGrid);
    }
}
