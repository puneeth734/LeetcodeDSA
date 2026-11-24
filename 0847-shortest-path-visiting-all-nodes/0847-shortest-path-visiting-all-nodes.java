class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int targetMask = (1 << n) - 1;

        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i, 1 << i, 0});
            visited.add(i + "," + (1 << i));
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int state = curr[1];
            int distance = curr[2];

            if (state == targetMask) {
                return distance;
            }

            for (int neighbor : graph[node]) {
                int newState = state | (1 << neighbor);
                String key = neighbor + "," + newState;

                if (!visited.contains(key)) {
                    visited.add(key);
                    queue.offer(new int[]{neighbor, newState, distance + 1});
                }
            }
        }
        return -1;
    }
}