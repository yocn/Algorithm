package structure;

import util.LogUtil;

import java.util.LinkedList;

/**
 * Created by yocn on 2019/6/13.
 * 字典树
 */
public class TireMap {
    private TireNode root = new TireNode();

    public void test() {
        addWord("app");
        addWord("apple");
        LogUtil.Companion.d(root.toString());
    }

    class TireNode {
        boolean isEnd = false;
        char content = 0;
        LinkedList<TireNode> child = new LinkedList<>();

        TireNode() {
        }

        TireNode(char content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "TireNode{" +
                    "isEnd=" + isEnd +
                    ", content=" + content +
                    ", child=" + child +
                    '}';
        }

        @Override
        public int hashCode() {
            return content;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof TireNode && (((TireNode) obj).content == content);
        }

        public TireNode getNode(Character character) {
            for (TireNode aChild : child) {
                if (aChild.content == character) {
                    return aChild;
                }
            }
            return null;
        }
    }

    /**
     * 添加一个word
     * apple
     *
     * @param word 需要添加的词
     */
    public void addWord(String word) {
        int deep = 0;
        TireNode currNode = root;
        while (deep < word.length()) {
            /*
             * 判断当前node的child，如果为空直接添加，不为空，查找是否含有，不含有则添加并设为currNode，含有则找到并设置为currNode
             */
            char c = word.charAt(deep);
            if (currNode.child.contains(new TireNode(c))) {
                currNode = currNode.getNode(c);
                LogUtil.Companion.d(deep + "-之前存在" );
            } else {
                TireNode node = new TireNode(c);
                currNode.child.add(node);
                currNode = node;
                LogUtil.Companion.d(deep + "-不存在，新创建" );
            }
            LogUtil.Companion.d(deep + "-" + root.toString());
            if (deep == word.length() - 1) {
                currNode.isEnd = true;
            }
            deep++;
        }
    }
}
