class Solution {
    private int m, n;
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific, heights);
            dfs(i, n - 1, atlantic, heights);
        }

        for (int j = 0; j < n; j++) {
            dfs(0, j, pacific, heights);
            dfs(m - 1, j, atlantic, heights);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int r, int c, boolean[][] visited, int[][] heights) {
        visited[r][c] = true;

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n 
                    && !visited[nr][nc] 
                    && heights[nr][nc] >= heights[r][c]) {
                dfs(nr, nc, visited, heights);
            }
        }
    }
}