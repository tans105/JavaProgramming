package utils.pojo;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode(TreeNode node) {
        this.val = node.val;
        this.left = null;
        this.right = null;
    }

    public String toString() {
        return String.valueOf(val);
    }
}
