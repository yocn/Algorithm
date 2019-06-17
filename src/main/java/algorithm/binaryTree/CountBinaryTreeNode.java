package algorithm.binaryTree;

import util.LogUtil;

/**
 * Created by yocn on 2019/6/17.
 * 给出一个完全二叉树，求出该树的节点个数。
 * <p>
 * 说明：
 * <p>
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
 * 若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 */
public class CountBinaryTreeNode {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void test() {
        int num = countNodes(prepareNode());
        LogUtil.Companion.d("num->" + num);
    }

    public class Bean {
        int num;
    }

    public int countNodes(TreeNode root) {
        Bean bean = new Bean();
        visitNode(root, bean);
        LogUtil.Companion.d(bean.num);
        return bean.num;
    }

    public void visitNode(TreeNode node, Bean bean) {
        if (node == null) {
            return;
        }
        bean.num++;
        visitNode(node.left, bean);
        visitNode(node.right, bean);
    }

    private TreeNode prepareNode() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        return root;
    }
}
