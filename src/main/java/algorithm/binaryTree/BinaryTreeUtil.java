package algorithm.binaryTree;

import util.LogUtil;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by yocn on 2019/6/17.
 * 二叉树Utils
 */
public class BinaryTreeUtil {
    public static TreeNode prepareANode() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        return root;
    }

    public static TreeNode prepareANode2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.left.left.left.left = new TreeNode(6);
        return root;
    }

    public static TreeNode prepareANode3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(4);
        return root;
    }

    public static TreeNode prepareAConpleteNode() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }

    /**
     * 打印二叉树
     *
     * @param root 根节点
     */
    public static void printBinTree(TreeNode root) {
        Queue<TreeNode> src = new ArrayDeque<>();
        src.add(root);
        printBinTree(src, 0);
    }

    private static void printBinTree(Queue<TreeNode> src, int level) {
        if (src.isEmpty()) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> tar = new ArrayDeque<>();
        String space = " ";
//        for (int i = 0; i < src.size(); i++) {
//            space += " ";
//        }
        for (int i = 10; i > level; i--) {
            sb.append(" ");
        }
        while (!src.isEmpty()) {
            TreeNode node = src.poll();
            sb.append(node.val).append(space);
            if (node.left != null) {
                tar.add(node.left);
            }
            if (node.right != null) {
                tar.add(node.right);
            }
        }
        LogUtil.Companion.d(sb.toString());
        printBinTree(tar, level + 1);
    }
}
