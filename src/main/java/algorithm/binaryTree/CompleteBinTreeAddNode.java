package algorithm.binaryTree;

import util.LogUtil;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by yocn on 2019/6/18.
 * 完全二叉树
 */
public class CompleteBinTreeAddNode {

    public void test() {
        Queue<TreeNode> newQueue = new ArrayDeque<>();
        TreeNode root = BinaryTreeUtil.prepareANode2();
        newQueue.add(root);
        BinaryTreeUtil.printBinTree(root);
        LogUtil.Companion.d("-----------------");
        visitBFS(newQueue, new TreeNode(10));
        visitBFS(newQueue, new TreeNode(11));
        BinaryTreeUtil.printBinTree(root);
    }

    private void visitBFS(Queue<TreeNode> queue, TreeNode newNode) {
        if (queue.isEmpty()) {
            return;
        }
        Queue<TreeNode> newQueue = new ArrayDeque<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null || node.right == null) {
                if (node.left == null) {
                    node.left = newNode;
                    return;
                }
                if (node.right == null) {
                    node.right = newNode;
                    return;
                }
            } else {
                newQueue.add(node.left);
                newQueue.add(node.right);
            }
        }
        visitBFS(newQueue, newNode);
    }
}
