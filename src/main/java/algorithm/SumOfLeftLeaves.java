package algorithm;

import util.LogUtil;

/**
 * Created by yocn on 2019/3/14.
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 * 计算给定二叉树的所有左叶子之和。
 * <p>
 * 示例：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
public class SumOfLeftLeaves {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void test() {
        TreeNode node = initANode();
        int result = sumOfLeftLeaves(node);
        LogUtil.Companion.d("result->" + result);
    }

    public TreeNode initANode() {
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.right = new TreeNode(3);
        node.right.right.left = new TreeNode(4);
        node.right.right.right = new TreeNode(5);
        return node;
    }

    public static int result = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        result = 0;
        visitANode(root);
        return result;
    }

    public void visitANode(TreeNode node) {
        if (node.left != null) {
            result += node.left.val;
            visitANode(node.left);
        }
        if (node.right != null) {
            visitANode(node.right);
        }
    }
}
