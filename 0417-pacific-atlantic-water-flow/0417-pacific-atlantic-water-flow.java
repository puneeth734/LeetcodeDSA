class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacificVisited = new boolean[m][n];
        boolean[][] atlanticVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacificVisited, heights[i][0], heights);
            dfs(i, n - 1, atlanticVisited, heights[i][n - 1], heights);
        }

        for (int j = 0; j < n; j++) {
            dfs(0, j, pacificVisited, heights[0][j], heights);
            dfs(m - 1, j, atlanticVisited, heights[m - 1][j], heights);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificVisited[i][j] && atlanticVisited[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }

        return result;
    }

    private void dfs(int r, int c, boolean[][] visited, int prevHeight, int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        visited[r][c] = true;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            dfs(r + dir[0], c + dir[1], visited, heights[r][c], heights);
        }
    }
}