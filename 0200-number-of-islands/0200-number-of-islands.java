class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void bfs(char[][] grid, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        grid[r][c] = '0'; // Mark as visited

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currR = current[0];
            int currC = current[1];

            for (int i = 0; i < 4; i++) {
                int newR = currR + dr[i];
                int newC = currC + dc[i];

                if (newR >= 0 && newR < rows && newC >= 0 && newC < cols && grid[newR][newC] == '1') {
                    queue.add(new int[]{newR, newC});
                    grid[newR][newC] = '0'; // Mark as visited
                }
            }
        }
    }
}