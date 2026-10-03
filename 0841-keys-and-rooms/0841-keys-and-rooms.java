class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfs(0, visited, rooms);

        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int room, boolean[] visited, List<List<Integer>> rooms) {
        visited[room] = true;

        for (int key : rooms.get(room)) {
            if (!visited[key]) {
                dfs(key, visited, rooms);
            }
        }
    }
}