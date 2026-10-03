import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, 0);
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        dist[0][0] = 1; 
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},  {0, 1},
            {1, -1},  {1, 0},  {1, 1}
        };

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            if (row == n - 1 && col == n - 1) {
                return dist[row][col];
            }

            for (int[] dir : directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];
             
                if (nr >= 0 && nr < n && nc >= 0 && nc < n 
                    && grid[nr][nc] == 0 && dist[nr][nc] == 0) {
                    
                    q.offer(new int[]{nr, nc});
                    dist[nr][nc] = dist[row][col] + 1;
                }
            }
        }
        return -1; 
    }
}