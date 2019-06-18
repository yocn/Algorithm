package algorithm.binaryTree;

import algorithm.ITestInterface;
import util.LogUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yocn on 2019/3/21.
 * 二叉树的BFS
 */
public class BinaryTreeBFS implements ITestInterface {
    @Override
    public void test() {
//        LogUtil.Companion.d(levelOrder(init()).toString());
        Queue<TreeNode> src = new ArrayDeque<>();
        src.add(init());
        visitBFS(src);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        result.add(list);
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        readALevelNode(nodeList, result);
        return result;
    }

    public void readALevelNode(List<TreeNode> nodeList, List<List<Integer>> list) {
        List<Integer> newList = new ArrayList<>();
        List<TreeNode> newDeque = new ArrayList<>();
        for (TreeNode node : nodeList) {
            if (node.left != null) {
                /*存在子Node*/
                newList.add(node.left.val);
                newDeque.add(node.left);
            }
            if (node.right != null) {
                /*存在子Node*/
                newList.add(node.right.val);
                newDeque.add(node.right);
            }
        }
        if (!newDeque.isEmpty()) {
            list.add(newList);
            readALevelNode(newDeque, list);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode init() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        return root;
    }

    private void visitBFS(Queue<TreeNode> src) {
        Queue<TreeNode> tar = new ArrayDeque<>();
        while (!src.isEmpty()) {
            TreeNode node = src.peek();
            if (node.left != null) {
                tar.add(node.left);
            }
            if (node.right != null) {
                tar.add(node.right);
            }
        }
        visitBFS(tar);
    }
}
