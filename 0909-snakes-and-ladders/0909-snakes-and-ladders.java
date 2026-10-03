class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];

        q.offer(1);
        visited[1] = true;
        int move = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int node = q.poll();

                if (node == n * n) {
                    return move;
                }

                for (int curr = 1; curr <= 6; curr++) {
                    int next = node + curr;
                    if (next > n * n) {
                        break;
                    }

                    int[] pos = getposition(next, n);
                    int r = pos[0];
                    int c = pos[1];

                    int destination = board[r][c] != -1 ? board[r][c] : next;

                    if (!visited[destination]) {
                        q.offer(destination);
                        visited[destination] = true;
                    }
                }
            }
            move++;
        }
        return -1;
    }

    private int[] getposition(int num, int n) {
        int r = n - 1 - (num - 1) / n;
        int c = (num - 1) % n;

        if ((n - 1 - r) % 2 == 1) {
            c = n - 1 - c;
        }
        return new int[]{r, c};
    }
}