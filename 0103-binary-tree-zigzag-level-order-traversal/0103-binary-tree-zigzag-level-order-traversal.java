/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    private void dfs(TreeNode root, int level, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        if (level == ans.size()) {
            ans.add(new LinkedList<>());
        }

        LinkedList<Integer> current = (LinkedList<Integer>) ans.get(level);

        if (level % 2 == 0) {
            current.addLast(root.val);
        } else {
            current.addFirst(root.val);
        }

        dfs(root.left, level + 1, ans);
        dfs(root.right, level + 1, ans);
    }
}