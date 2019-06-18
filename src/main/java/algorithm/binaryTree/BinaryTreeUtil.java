package algorithm.binaryTree;

/**
 * Created by yocn on 2019/6/17.
 * 二叉树Utils
 */
public class BinaryTreeUtil {
    public static TreeNode prepareANode() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        return root;
    }

    public static TreeNode prepareANode2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.left.left.left = new TreeNode(6);
        root.left.left.left.left = new TreeNode(6);
        return root;
    }
}
