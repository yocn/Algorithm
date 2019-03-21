package algorithm.binaryTree;

import algorithm.ITestInterface;
import util.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yocn on 2019/3/21.
 * 二叉树的中序遍历
 */
public class InorderTraversal implements ITestInterface {
    @Override
    public void test() {
        List<Integer> list = inorderTraversalReverse(initTreeNode());
        LogUtil.Companion.d("list->" + list.toString());
    }

    /**
     * 基于栈的中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalByStack(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    /**
     * 基于递归的中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalReverse(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    public void traversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            traversal(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            traversal(root.right, list);
        }
    }

    public TreeNode initTreeNode() {
//        TreeNode treeNode = new TreeNode(1);
//        treeNode.left = new TreeNode(2);
//        treeNode.left.right = new TreeNode(3);
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        return treeNode;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
