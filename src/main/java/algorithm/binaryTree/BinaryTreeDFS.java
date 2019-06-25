package algorithm.binaryTree;

import algorithm.ITestInterface;
import util.LogUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by yocn on 2019/3/21.
 * 二叉树的中序遍历
 */
public class BinaryTreeDFS implements ITestInterface {
    @Override
    public void test() {
        List<Integer> list = inorderTraversalReverse(initTreeNode());
        LogUtil.Companion.d("list->" + list.toString());
        BinaryTreeUtil.printBinTree(initTreeNode());
        DFS(initTreeNode());
    }

    /**
     * 基于栈的中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalByStack(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root != null) {
        }
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

    public void DFS(TreeNode node) {
        if (node == null) {
            return;
        }
        LogUtil.Companion.d("node->" + node.val);
        DFS(node.left);
        DFS(node.right);
    }

    public TreeNode initTreeNode() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        return treeNode;
    }

}
