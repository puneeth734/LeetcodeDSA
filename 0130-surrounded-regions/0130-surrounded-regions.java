class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O')
                bfs(board, i, 0);

            if (board[i][m - 1] == 'O')
                bfs(board, i, m - 1);
        }

        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O')
                bfs(board, 0, j);

            if (board[n - 1][j] == 'O')
                bfs(board, n - 1, j);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    private void bfs(char[][] board, int row, int col) {
        int n = board.length;
        int m = board[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        board[row][col] = '#';

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && board[nr][nc] == 'O') {
                    board[nr][nc] = '#';
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
}