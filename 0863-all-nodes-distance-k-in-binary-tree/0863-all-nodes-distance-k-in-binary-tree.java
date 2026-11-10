/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findDistance(root, target, k);
        return ans;
    }

    private int findDistance(TreeNode root, TreeNode target, int k) {

        if (root == null) {
            return -1;
        }
        if (root == target) {
            collectDown(root, k);
            return 0;
        }

        int leftDistance = findDistance(root.left, target, k);
        if (leftDistance != -1) {

            int distanceFromRoot = leftDistance + 1;

            if (distanceFromRoot == k) {
                ans.add(root.val);
            }

            int remaining = k - distanceFromRoot - 1;

            if (remaining >= 0) {
                collectDown(root.right, remaining);
            }

            return distanceFromRoot;
        }

        int rightDistance = findDistance(root.right, target, k);

        if (rightDistance != -1) {

            int distanceFromRoot = rightDistance + 1;

            if (distanceFromRoot == k) {
                ans.add(root.val);
            }
            int remaining = k - distanceFromRoot - 1;

            if (remaining >= 0) {
                collectDown(root.left, remaining);
            }

            return distanceFromRoot;
        }

        return -1;
    }

    private void collectDown(TreeNode root, int distance) {
        if (root == null || distance < 0) {
            return;
        }
        if (distance == 0) {
            ans.add(root.val);
            return;
        }
        collectDown(root.left, distance - 1);
        collectDown(root.right, distance - 1);
    }
}