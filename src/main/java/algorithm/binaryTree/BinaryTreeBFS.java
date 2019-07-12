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
//        Queue<TreeNode> src = new ArrayDeque<>();
//        src.add(init());
//        BFS(src);
        testAdd();
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

    public TreeNode init() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(7);
        return root;
    }

    private void visitBFS(Queue<TreeNode> src) {
        Queue<TreeNode> tar = new ArrayDeque<>();
        if (src.size() == 0) {
            return;
        }
        while (src.size() > 0) {
            TreeNode node = src.poll();
            if (node.left != null) {
                tar.add(node.left);
            }
            if (node.right != null) {
                tar.add(node.right);
            }
            LogUtil.Companion.d("node->" + node.val);
        }
        visitBFS(tar);
    }

    private void BFS(Queue<TreeNode> queue) {
        if (queue.size() == 0) return;
        Queue<TreeNode> temp = new ArrayDeque<>();
        for (TreeNode node : queue) {
            if (node.left != null) {
                temp.add(node.left);
            }
            if (node.right != null) {
                temp.add(node.right);
            }
            LogUtil.Companion.d("node->" + node.val);
        }
        BFS(temp);
    }

    public void testAdd() {
        TreeNode root2 = init();
        BinaryTreeUtil.printBinTree(root2);
        TreeNode[] nodes = new TreeNode[]{root2};
        AddANode(nodes, new TreeNode(3));
        BinaryTreeUtil.printBinTree(root2);
    }

    public void AddANode(TreeNode[] nodes, TreeNode target) {
        if (nodes.length == 0) return;
        if (nodes[0].left == null) {
            nodes[0].left = target;
            return;
        }
        boolean isLast = false;//最后一层
        if (nodes[nodes.length - 1] == null || nodes[nodes.length - 1].left == null || nodes[nodes.length - 1].right == null) {
            isLast = true;
        }
        LogUtil.Companion.d("list->" + nodes.length + " isLast->" + isLast);
        if (isLast) {
            int low = 0;
            int high = nodes.length - 1;
            int middle = (low + high) / 2;
            while (low < high) {
                LogUtil.Companion.d("low-" + low + " high->" + high);
                if (nodes[middle].left == null) {
                    high = middle;
                } else if (nodes[middle].left != null && nodes[middle].right == null) {
                    nodes[middle].right = target;
                    return;
                } else {
                    low = middle;
                }
                if (nodes[low].right != null && nodes[high].left == null) {
                    nodes[high].left = target;
                    return;
                }
            }
        } else {
            TreeNode[] newNodes = new TreeNode[nodes.length * 2];
            for (int i = 0; i < nodes.length; i++) {
                newNodes[i * 2] = nodes[i].left;
                newNodes[i * 2 + 1] = nodes[i].right;
            }
            AddANode(newNodes, target);
        }
    }

}
