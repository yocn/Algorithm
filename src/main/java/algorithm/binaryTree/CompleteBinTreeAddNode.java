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
        TreeNode root = BinaryTreeUtil.prepareAConpleteNode();
        BinaryTreeUtil.printBinTree(root);
        newQueue.add(root);
//        visitBFS(newQueue, new TreeNode(10));

        insert(new TreeNode[]{root}, new TreeNode(10));
        BinaryTreeUtil.printBinTree(root);
//        LogUtil.Companion.d("-----------------");
//        visitBFS(newQueue, new TreeNode(10));
//        visitBFS(newQueue, new TreeNode(11));
//        BinaryTreeUtil.printBinTree(root);
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

    private void insert(TreeNode[] nodes, TreeNode target) {
        if (nodes[0].left == null) {
            nodes[0].left = target;
            return;
        }
        boolean isLast = false;
        if (nodes[nodes.length - 1].right == null) {
            isLast = true;
        }
        if (!isLast) {
            TreeNode[] newNodes = new TreeNode[nodes.length * 2];
            for (int i = 0; i < nodes.length; i++) {
                newNodes[2 * i] = nodes[i].left;
                newNodes[2 * i + 1] = nodes[i].right;
            }
            insert(newNodes, target);
        } else {
            int low = 0, high = nodes.length - 1, middle = (low + high) / 2;
            while (low < high) {
                if (nodes[middle].left == null) {
                    high = middle;
                } else if (nodes[middle].left != null && nodes[middle].right == null) {
                    nodes[middle].right = target;
                    return;
                } else {
                    low = middle;
                }
                if (nodes[low].right != null && nodes[middle].left == null) {
                    nodes[middle].left = target;
                    return;
                }
            }
        }
    }

}
