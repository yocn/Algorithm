package algorithm.linked;

/**
 * Created by yocn on 2019/7/8.
 * 单链表
 */
public class SingleNode {
    public int val;
    public SingleNode next;

    public SingleNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public SingleNode getNext() {
        return next;
    }

    public void setNext(SingleNode next) {
        this.next = next;
    }

    public SingleNode getLevelNode(int level) {
        if (level == 0) {
            return this;
        }
        int deep = 0;
        SingleNode result = this;
        while (deep++ < level) {
            result = result.getNext();
        }
        return result;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof SingleNode && ((SingleNode) obj).val == val;
    }
}
