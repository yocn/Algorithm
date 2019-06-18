package algorithm.binaryTree;

import util.LogUtil;

/**
 * Created by yocn on 2019/6/18.
 * 二叉树是否对称
 */
public class BinaryTreeMirror {
    public void test() {
        LogUtil.Companion.d("" + isSymmetric(BinaryTreeUtil.prepareANode3()));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;
        if (left.val != right.val) return false;
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
