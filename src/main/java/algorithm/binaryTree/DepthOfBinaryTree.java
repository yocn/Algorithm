package algorithm.binaryTree;

import util.LogUtil;

/**
 * Created by yocn on 2019/6/17.
 * 二叉树的最大深度
 */
public class DepthOfBinaryTree {

    public void test() {
        int min = minDepth(BinaryTreeUtil.prepareANode2());
        int max = maxDepth(BinaryTreeUtil.prepareANode2());
        LogUtil.Companion.d("min->" + min);
        LogUtil.Companion.d("max->" + max);
    }

    int max;

    public int maxDepth(TreeNode root) {
        visitMaxNode(root, 1);
        return max;
    }

    private void visitMaxNode(TreeNode node, int deep) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            //说明是叶子节点
            if (deep > max) {
                max = deep;
            }
        }
        visitMaxNode(node.left, deep + 1);
        visitMaxNode(node.right, deep + 1);
    }

    int min = 0;

    public int minDepth(TreeNode root) {
        visitMinNode(root, 1);
        return min;
    }

    private void visitMinNode(TreeNode node, int deep) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            //说明是叶子节点
            if (min == 0) {
                min = deep;
            }
            if (deep < min) {
                min = deep;
            }
        }
        visitMinNode(node.left, deep + 1);
        visitMinNode(node.right, deep + 1);
    }
}
