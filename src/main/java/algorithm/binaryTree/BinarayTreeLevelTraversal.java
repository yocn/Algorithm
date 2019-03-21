package algorithm.binaryTree;

import algorithm.ITestInterface;
import util.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yocn on 2019/3/21.
 */
public class BinarayTreeLevelTraversal implements ITestInterface {
    @Override
    public void test() {
        LogUtil.Companion.d(levelOrder(init()).toString());
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
                LogUtil.Companion.d("n->" + node.left.val);
            }
            if (node.right != null) {
                /*存在子Node*/
                newList.add(node.right.val);
                newDeque.add(node.right);
                LogUtil.Companion.d("n->" + node.right.val);
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
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        return root;
    }
}
