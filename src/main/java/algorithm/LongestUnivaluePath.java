package algorithm;

import util.LogUtil;

/**
 * Created by yocn on 2019/3/8.
 * https://leetcode-cn.com/problems/longest-univalue-path/
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 * <p>
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 5
 * / \
 * 4   5
 * / \   \
 * 1   1   5
 * 输出:
 * <p>
 * 2
 * 示例 2:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 4   5
 * / \   \
 * 4   4   5
 * 输出:
 * <p>
 * 2
 */
public class LongestUnivaluePath {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int max = 0;
    int path = 0;

    public void test() {
        int path = longestUnivaluePath(prepareANode2());
        LogUtil.Companion.d(path);
    }

    public int longestUnivaluePath(TreeNode root) {
        findMax(root, -1, 0);
        return max;
    }

    private void findMax(TreeNode node, int preVal, int level) {
        if (node == null) {
            return;
        }
        if (node.val == preVal) {
            path++;
        } else {
            path = 0;
        }
        max = (max > path) ? max : path;
        if (node.left != null) {
            findMax(node.left, node.val, 0);
        }
        if (node.right != null) {
            findMax(node.right, node.val, 1);
        }
    }

    private TreeNode prepareANode() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(5);
        root.right.right.right.right = new TreeNode(5);
        return root;
    }

    private TreeNode prepareANode2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(4);
        root.left.right.left.right = new TreeNode(5);
        root.left.right.left.right.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(5);
        root.right.right.right.right = new TreeNode(5);
        return root;
    }
}
