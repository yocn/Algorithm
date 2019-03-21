package algorithm.binaryTree;

import algorithm.ITestInterface;
import util.LogUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by yocn on 2019/3/21.
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 */
public class NaryTreeLevelOrderTraversal implements ITestInterface {
    @Override
    public void test() {
        LogUtil.Companion.d(levelOrder(init2()).toString());
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        result.add(list);
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(root);
        readALevelNode(nodeList, result);
        return result;
    }

    public void readALevelNode(List<Node> nodeList, List<List<Integer>> list) {
        List<Integer> newList = new ArrayList<>();
        List<Node> newDeque = new ArrayList<>();
        for (Node node : nodeList) {
            if (node.children != null && node.children.size() > 0) {
                /*存在子Node*/
                for (Node n : node.children) {
                    newList.add(n.val);
                    newDeque.add(n);
                    LogUtil.Companion.d("n->" + n.val);
                }
            }
        }
        if (!newDeque.isEmpty()) {
            list.add(newList);
            readALevelNode(newDeque, list);
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public Node init() {
        Node root = new Node(1, new ArrayList<>());
        root.children.add(new Node(3, new ArrayList<>()));
        root.children.add(new Node(2, null));
        root.children.add(new Node(4, null));
        root.children.get(0).children.add(new Node(5, null));
        root.children.get(0).children.add(new Node(6, null));
        return root;
    }

    public Node init2() {
        Node root = new Node(1, new ArrayList<>());
        root.children.add(new Node(10, new ArrayList<>()));
        root.children.add(new Node(3, new ArrayList<>()));
        root.children.get(0).children.add(new Node(5, null));
        root.children.get(0).children.add(new Node(0, null));
        root.children.get(1).children.add(new Node(6, null));
        return root;
    }
}
