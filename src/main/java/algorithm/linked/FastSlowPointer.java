package algorithm.linked;

import util.LogUtil;

/**
 * Created by yocn on 2019/7/8.
 * 快慢指针应用
 * #####判断单链表是否存在环
 * #####判断链表是否存在环，如果存在，找到环入口
 * #####在有序链表中寻找中位数
 * #####输出链表中的倒数第K个节点(即正数第n-K个节点)
 * #####判断两个单链表是否相交，如果相交，找到他们的第一个公共节点
 */
public class FastSlowPointer {
    public void test() {
        SingleNode root = NodeUtil.createASingleNodeList(8);
        NodeUtil.printASingleNodeList(root);
        int middle = getMiddleOfLinkedList(root);
        SingleNode tarNode = getReverseNumK(root, 4);
        LogUtil.Companion.d("中位数->" + middle);
        LogUtil.Companion.d("倒数第k个数->" + tarNode.getVal());
        testIntersect(root);
        testLoop(root);
    }

    private void testLoop(SingleNode root) {
        root.getLevelNode(6).setNext(root.getLevelNode(4));
        boolean isLoop = isLinkedListLoop(root);
        LogUtil.Companion.d("是否有环->" + isLoop);
    }

    private void testIntersect(SingleNode root) {
        SingleNode middleNode = NodeUtil.getNodeDeep(root, 5);
        SingleNode rightNode = new SingleNode(0);
        rightNode.setNext(new SingleNode(1));
        rightNode.getNext().setNext(middleNode);
        SingleNode node1 = getIntersect1(root, rightNode);
        if (node1 == null) {
            LogUtil.Companion.d("不相交");
        } else {
            LogUtil.Companion.d("相交->" + node1.getVal());
        }
    }

    /**
     * 判断单链表是否存在环
     * 快指针走两步，慢指针走一步，两指针若重合说明有环
     *
     * @return 是否有环
     */
    private boolean isLinkedListLoop(SingleNode node) {
        return NodeUtil.isLinkedListLoop(node);
    }

    /**
     * 在有序链表中寻找中位数
     * 快指针走两步，慢指针走一步，快指针到tail，慢指针到中位数
     *
     * @param node head
     * @return 坐标
     */
    private int getMiddleOfLinkedList(SingleNode node) {
        SingleNode fastPointer = node;
        SingleNode slowPointer = node;
        int middle = 0;
        int index = 0;
        while (fastPointer != null) {
            fastPointer = fastPointer.getNext();
            if (index > 0 && index % 2 == 0) {
                slowPointer = slowPointer.getNext();
                middle++;
            }
            index++;
        }
        return middle;
    }

    /**
     * 输出链表中的倒数第K个节点(即正数第n-K个节点)
     * 思路：两个指针，指针一先走k个node，指针二开始走，指针一到尾部的时候，指针二到达倒数第k个节点
     *
     * @param node 目标链表的头结点
     * @param k    需要找的节点
     * @return 节点
     */
    public SingleNode getReverseNumK(SingleNode node, int k) {
        if (k >= NodeUtil.getLinkedListLength(node)) {
            return null;
        }
        SingleNode fastNode = node;
        SingleNode slowNode = node;
        int pointer = 0;
        while (fastNode != null) {
            fastNode = fastNode.getNext();
            if (pointer >= k) {
                slowNode = slowNode.getNext();
            }
            pointer++;
        }
        return slowNode;
    }

    /**
     * 判断两个链表是否相交，如果相交得到交点
     * 两个指针分别指向链表1链表2，指针一到结尾后指向链表2，指针二结尾后指向链表1，如果出现重合，说明相交。
     *
     * @param leftList  链表1
     * @param rightList 链表2
     */
    private SingleNode getIntersect1(SingleNode leftList, SingleNode rightList) {
        SingleNode pointer1 = leftList;
        SingleNode pointer2 = rightList;
        boolean pointer1End = false;
        boolean pointer2End = false;
        while (pointer1 != null) {
            if (pointer1 == pointer2) {
                return pointer1;
            }

            if (!pointer1End && pointer1.getNext() == null) {
                pointer1End = true;
                pointer1 = rightList;
            } else {
                pointer1 = pointer1.getNext();
            }

            if (!pointer2End && pointer2.getNext() == null) {
                pointer2End = true;
                pointer2 = leftList;
            } else {
                pointer2 = pointer2.getNext();
            }
        }
        return null;
    }
}
