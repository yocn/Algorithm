package algorithm;

import util.LogUtil;

/**
 * Created by yocn on 2019/3/19.
 * 题目：给定两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，也就是个位排在链表首部。编写函数对这两个整数求和，并用链表形式返回结果。
 * <p>
 * 示例 输入：(7->1->6) +(5->9->2)，即617+295
 * 输出：2->1->9，即912。
 * <p>
 * 进阶 假设这些数位是正向存放的，请再做一遍。
 * 示例 输入：(6->1->7) + (2->9->5)，即617+295.
 * <p>
 * 输出：9->1->2，即912。
 */
public class ChainAdd {
    public void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(8);
        Node node4 = new Node(8);
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;

        Node n1 = new Node(3);
        Node n2 = new Node(4);
        n1.next = n2;

//        LogUtil.Companion.d(getNode(node1) + " " + getNode(node1, 3).val);
        int result = add(node1, n1, true);
        LogUtil.Companion.d(result);
    }

    int destDepth, srcDepth = 0;

    public int add(Node destNode, Node srcNode, boolean needSort) {
        if (needSort) {
            int depth1 = getDepthOfNode(destNode);
            int depth2 = getDepthOfNode(srcNode);
            if (depth1 < depth2) {
                //保证destNode层级比srcNode深
                add(srcNode, destNode, false);
                destDepth = depth2;
                srcDepth = depth1;
            } else {
                destDepth = depth1;
                srcDepth = depth2;
            }
        }
        int result = 0;
        boolean hasTen = false;
        int index = 0;
        while (index != srcDepth) {
            int destIndex = destDepth - index - 1;
            int srcIndex = srcDepth - index - 1;
            int destVal = getNode(destNode, destIndex).val;
            int srcVal = getNode(srcNode, srcIndex).val;
            destVal += srcVal;
            if (hasTen) {
                destVal++;
            }
            if (destVal > 10) {
                hasTen = true;
                destVal -= 10;
            } else {
                hasTen = false;
            }
            setNode(destNode, destVal, destIndex);
            result += Math.pow(10, index);
            index++;
        }
        if (hasTen) {
            int lastIndex = destDepth - srcDepth - 1;
            LogUtil.Companion.d("has->" + hasTen + " lastIndex->" + lastIndex);
            setNodeSelAdd(destNode, lastIndex);
        }
        LogUtil.Companion.d(printNode(destNode));
        return result;
    }

    private Node getNode(Node root, int index) {
        Node node = root;
        int temp = index;
        while (temp != 0) {
            temp--;
            node = node.next;
//            LogUtil.Companion.d("getNode root->" + node.val + " temp->" + temp);
        }
        return node;
    }

    private void setNode(Node root, int val, int index) {
        Node node = root;
        int i = 0;
        while (i != index) {
            node = node.next;
            i++;
            if (i == index) {
                node.val = val;
            }
        }
    }

    private void setNodeSelAdd(Node root, int index) {
        Node node = root;
        int i = 0;
        while (i != index) {
            node = node.next;
            i++;
            if (i == index) {
                node.val++;
            }
        }
    }

    private int getDepthOfNode(Node root) {
        int depth = 0;
        while (root.hasNext()) {
            root = root.next;
            depth++;
        }
        return depth + 1;
    }

    private String printNode(Node root) {
        StringBuilder sb = new StringBuilder();
        while (root.hasNext()) {
            sb.append(root.val).append(" ");
            root = root.next;
        }
        sb.append(root.val).append(" ");
        return sb.toString();
    }

    public static class Node {
        int val;
        Node next = null;

        public Node(int val) {
            this.val = val;
        }

        public boolean hasNext() {
            return next != null;
        }
    }
}
