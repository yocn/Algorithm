package algorithm;

import util.LogUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by yocn on 2019/1/28.
 * 生成二叉树，遍历二叉树
 */
public class TraverseBinaryTree {
    private Node mRootNode;
    private int index = 0;

    public void test() {
        mRootNode = new Node(index);
        generateBinaryTree();
        printBinaryTree(mRootNode);
        traverseBinaryTree();
    }


    public void generateBinaryTree() {
        addChildNode(mRootNode);
    }

    public void addChildNode(Node node) {
        Node leftNode = new Node(++index);
        Node rightNode = new Node(++index);
        node.setLeftNode(leftNode);
        node.setRightNode(rightNode);
        if (index < 8) {
            addChildNode(leftNode);
            addChildNode(rightNode);
        }
    }

    private void printBinaryTree(Node node) {
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        ArrayList<Node> rootList = new ArrayList<>();
        rootList.add(node);
        list.add(rootList);
        visitOneLayerList(list);
    }

    private void visitOneLayerList(ArrayList<ArrayList<Node>> list) {
        boolean hasChild = false;
        ArrayList<Node> latestList = list.get(list.size() - 1);
        ArrayList<Node> childList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < latestList.size(); i++) {
            Node node = latestList.get(i);
            sb.append(node.toString()).append(" ");
            if (node.hasLeftNode()) {
                childList.add(node.getLeftNode());
                if (node.getLeftNode().hasChildNode()) {
                    hasChild = true;
                }
            }
            if (node.hasRightNode()) {
                childList.add(node.getRightNode());
                if (node.getRightNode().hasChildNode()) {
                    hasChild = true;
                }
            }

        }
        list.add(childList);
        LogUtil.Companion.d(sb.toString());
        if (hasChild) {
            visitOneLayerList(list);
        }
    }

    public void traverseBinaryTree() {
        visitAllNode(mRootNode);
    }

    public void visitAllNode(Node node) {
        if (node != null) {
            visitNode(node);
            visitAllNode(node.getLeftNode());
            visitAllNode(node.getRightNode());
        }
    }

    private void visitNode(Node node) {
        LogUtil.Companion.d("" + node.getId());
    }

    public static class Node {

        private int id;
        private Node leftNode;
        private Node rightNode;

        public Node(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean hasLeftNode() {
            return leftNode != null;
        }

        public boolean hasRightNode() {
            return rightNode != null;
        }

        public boolean hasChildNode() {
            return hasLeftNode() || hasRightNode();
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }

        @Override
        public String toString() {
            return
                    "" + id;
        }
    }
}
