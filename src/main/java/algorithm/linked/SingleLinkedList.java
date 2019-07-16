package algorithm.linked;

import util.LogUtil;

/**
 * Created by yocn on 2019/7/9.
 * 链表
 */
public class SingleLinkedList {
    public void test() {

        SingleNode node3 = NodeUtil.createASingleNodeList(4);
        LogUtil.Companion.d(NodeUtil.getASingleNodeList(node3));
        SingleNode n = reverseNode(node3);
        LogUtil.Companion.d(NodeUtil.getASingleNodeList(n));


        SingleNode node1 = NodeUtil.createASingleNodeList(2);
        SingleNode node2 = NodeUtil.createASingleNodeList(4);
        LogUtil.Companion.d(NodeUtil.getASingleNodeList(node1));
        LogUtil.Companion.d(NodeUtil.getASingleNodeList(node2));
        SingleNode result = reverseNode(mergeTwoLists(node1, node2));
//        SingleNode result = mergeTwoLists(node1, node2);
        LogUtil.Companion.d(NodeUtil.getASingleNodeList(result));


//        SingleNode root = new SingleNode(6);
//        root.next = new SingleNode(6);
//        root.next.next = new SingleNode(6);
//        root.next.next.next = new SingleNode(3);
//        root.next.next.next.next = new SingleNode(4);
//        root.next.next.next.next.next = new SingleNode(5);
//        root.next.next.next.next.next.next = new SingleNode(6);
//        LogUtil.Companion.d(NodeUtil.getASingleNodeList(removeElements(root, 6)));

    }

    /**
     * 移除链表中的元素 普通写法，需要先找到不是val的head
     *
     * @param head
     * @param val
     * @return
     */
    public SingleNode removeElements(SingleNode head, int val) {
        if (head == null) {
            return head;
        }
        while (head.val == val) {
            head = head.next;
            if (head == null) {
                return head;
            }
        }
        SingleNode node = head;

        while (node.next != null) {
            if (node.next.val == val) {
                SingleNode temp = node.next.next;
                node.next = temp;
            }
            if (node.next == null) {
                break;
            }
            if (node.next.val != val) {
                node = node.next;
            }
        }
        return head;
    }

    /**
     * 移除链表中的元素，优化写法，使用一个头指针指向head，不用担心head就是需要移除的元素
     *
     * @param head
     * @param val
     * @return
     */
    public SingleNode removeElements2(SingleNode head, int val) {
        SingleNode preHead = new SingleNode(val - 1);
        preHead.next = head;
        SingleNode node = preHead;
        while (node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            }
            if (node.next == null) {
                break;
            }
            if (node.next.val != val) {
                node = node.next;
            }
        }
        return preHead.next;
    }

    /**
     * 链表反转
     *
     * @param root
     * @return
     */
    private SingleNode reverseNode(SingleNode root) {
        if (root == null || root.next == null) {
            return root;
        }
        SingleNode result = root;
        SingleNode next = root.next;
        root.next = null;
        while (next != null) {
            SingleNode temp = next;
            next = next.next;
            temp.next = result;
            result = temp;
        }
        return result;
    }

    //合并两个顺序数组，方式1：左右为null的时候继续往后遍历
    public SingleNode merge(SingleNode left, SingleNode right) {
        if (left == null) return right;
        if (right == null) return left;
        SingleNode newNode = null;
        while (left != null || right != null) {
            if (left == null) {
                SingleNode n = right;
                right = right.next;
                n.next = newNode;
                newNode = n;
                continue;
            }
            if (right == null) {
                SingleNode n = left;
                left = left.next;
                n.next = newNode;
                newNode = n;
                continue;
            }
            if (left.val > right.val) {
                SingleNode n = right;
                right = right.next;
                n.next = newNode;
                newNode = n;
            } else {
                SingleNode n = left;
                left = left.next;
                n.next = newNode;
                newNode = n;
            }
        }
        return newNode;
    }

    //方式2：左右为null的时候直接break结束循环
    public SingleNode merge2(SingleNode left, SingleNode right) {
        if (left == null || right == null) return left == null ? right : left;
        SingleNode head = null;
        if (left.val > right.val) {
            head = right;
            right = right.next;
            head.next = null;
        } else {
            head = left;
            left = left.next;
            head.next = null;
        }
        SingleNode tail = head;
        while (left != null || right != null) {
            if (left == null) {
                tail.next = right;
                break;
            }
            if (right == null) {
                tail.next = left;
                break;
            }
            if (left.val > right.val) {
                SingleNode temp = right;
                right = right.next;
                temp.next = null;
                tail.next = temp;
                tail = temp;
            } else {
                SingleNode temp = left;
                left = left.next;
                temp.next = null;
                tail.next = temp;
                tail = temp;
            }
        }
        return head;
    }

    //添加一个preHead指针，不在乎head是否为空
    private SingleNode mergeTwoLists(SingleNode l1, SingleNode l2) {
        SingleNode preHead = new SingleNode(0), node = preHead;
        while (l1 != null || l2 != null) {
            if (l1 == null || l2 == null) {
                node.next = (l1 == null ? l2 : l1);
                break;
            }
            SingleNode temp;
            if (l1.val > l2.val) {
                temp = l2;
                l2 = l2.next;
            } else {
                temp = l1;
                l1 = l1.next;
            }
            node.next = temp;
            temp.next = null;
            node = temp;
        }
        return preHead.next;
    }

}
