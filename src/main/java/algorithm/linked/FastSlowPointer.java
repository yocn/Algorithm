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
        NodeUtil.getASingleNodeList(root);
        int middle = getMiddleOfLinkedList(root);
        SingleNode tarNode = getReverseNumK(root, 4);
        LogUtil.Companion.d("中位数->" + middle);
        LogUtil.Companion.d("倒数第k个数->" + tarNode.getVal());
        testIntersect(root);
        testLoop(root);
//        testMergeLinkedList();
        testReverseLinkedList();
        deleteLastNNode(root, 4);
    }

    private void testLoop(SingleNode root) {
        root.getLevelNode(7).setNext(root.getLevelNode(3));
        boolean isLoop = isLinkedListLoop(root);
        LogUtil.Companion.d("是否有环->" + isLoop);
        SingleNode node = getEntrance(root);
        LogUtil.Companion.d("环->" + node.getVal());
    }

    private void testIntersect(SingleNode root) {
//        SingleNode middleNode = NodeUtil.getNodeDeep(root, 5);
//        SingleNode rightNode = new SingleNode(5);
//        rightNode.setNext(new SingleNode(6));
//        rightNode.getNext().setNext(middleNode);
        SingleNode node8 = new SingleNode(8);
        node8.next = new SingleNode(4);
        node8.next.next = new SingleNode(5);
        SingleNode left = new SingleNode(4);
        left.next = new SingleNode(1);
        left.next.next = node8;
        SingleNode right = new SingleNode(5);
        right.next = new SingleNode(0);
        right.next.next = new SingleNode(1);
        right.next.next.next = node8;
        SingleNode node1 = getIntersectionNode(left, right);
        if (node1 == null) {
            LogUtil.Companion.d("不相交");
        } else {
            LogUtil.Companion.d("相交->" + node1.getVal());
        }
    }

    private void testMergeLinkedList() {
        SingleNode left = NodeUtil.createASingleNodeList(8);
        SingleNode right = NodeUtil.createASingleNodeList(3);
        SingleNode result = merge2Node(left, right);
        NodeUtil.printASingleNodeList("result", result);
    }

    private void testReverseLinkedList() {
        SingleNode root = NodeUtil.createASingleNodeList(8);
        SingleNode result = reverseLinkedList(root);
        NodeUtil.printASingleNodeList("反转", result);
    }

    /**
     * 判断单链表是否存在环
     * 快指针走两步，慢指针走一步，两指针若重合说明有环
     *
     * @return 是否有环
     */
    private boolean isLinkedListLoop(SingleNode node) {
        return NodeUtil.hasLoop(node);
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
        while (fastPointer.getNext() != null) {
            fastPointer = fastPointer.getNext();
            index++;
            if (index % 2 == 0) {
                slowPointer = slowPointer.getNext();
                middle++;
            }
        }
        return middle;
    }

    /**
     * 合并两个链表
     *
     * @param leftNode  左
     * @param rightNode 右
     * @return
     */
    private SingleNode merge2Node(SingleNode leftNode, SingleNode rightNode) {
        NodeUtil.printASingleNodeList("左", leftNode);
        NodeUtil.printASingleNodeList("右", rightNode);
        SingleNode result;
        SingleNode temp;
        if (leftNode == null) {
            return rightNode;
        } else if (rightNode == null) {
            return leftNode;
        } else {
            if (leftNode.getVal() > rightNode.getVal()) {
                result = rightNode;
            } else {
                result = leftNode;
            }
        }
        while (leftNode.next != null || rightNode.next != null) {
            NodeUtil.printASingleNodeList("-", result);
            if (leftNode.val > rightNode.val) {
                leftNode = result.next;
                result = rightNode;
            } else {
                rightNode = result.next;
                result = leftNode;
            }
        }
        return result;
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
     * 判断是否有环，如果有得到入口
     * 思路：如果有环，快慢指针会相遇，这时候把快指针赋值给head，快慢指针同时加一，相遇的时候就是指针入口
     *
     * @param root head
     * @return 入口Node
     */
    private SingleNode getEntrance(SingleNode root) {
        SingleNode fast = root;
        SingleNode slow = root;
        boolean front = false;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) {
                front = true;
                break;
            }
        }
        if (!front) {
            return null;
        }
        slow = root;
        while (slow != fast) {
            slow = slow.getNext();
            fast = fast.getNext();
        }
        return fast;
    }

    /**
     * 翻转链表
     * 思路：需要准备三个指针，
     *
     * @param node
     * @return
     */
    private SingleNode reverseLinkedList(SingleNode node) {
        SingleNode temp = node.next;
        SingleNode newList = node;
        newList.next = null;
        while (temp != null) {
            SingleNode pre = temp;
            temp = temp.next;
            pre.next = newList;
            newList = pre;
        }
        return newList;
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

    /**
     * 两个链表是否相交
     *
     * @param headA 链表A
     * @param headB 链表B
     * @return 是否相交
     */
    private SingleNode getIntersectionNode(SingleNode headA, SingleNode headB) {
        SingleNode fast = headA;
        SingleNode slow = headB;
        boolean endA = false;
        boolean endB = false;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            if (!endA && fast == null) {
                endA = true;
                fast = headB;
            }
            if (!endB && slow == null) {
                endB = true;
                slow = headA;
            }
            if (endA && endB && fast == slow) {
                return fast;
            }
        }
        return null;
    }

    /**
     * 删除倒数第n个节点
     * 思路：查找倒数第n个节点的基础上再加一个慢指针的父节点，找到第n个节点后删掉
     *
     * @param root 根节点
     * @param n    需要删除的index
     */
    private void deleteLastNNode(SingleNode root, int n) {
        SingleNode fast = root;
        SingleNode slowParent = root;
        SingleNode slow = root;
        int index = 0;
        while (fast.getNext() != null) {
            fast = fast.getNext();
            index++;
            if (index >= n) {
                slowParent = slow;
                slow = slow.getNext();
            }
        }
        slowParent.setNext(slow.getNext());
        NodeUtil.getASingleNodeList(root);
    }
}
