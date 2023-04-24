package 排序;

public class 合并二叉树 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return buildTree(root1, root2);
    }
    TreeNode buildTree(TreeNode node1 ,TreeNode node2){
        if(node1 ==null && node2==null) return null;
        int v1 = node1 == null? 0 : node1.val;
        int v2 = node2 == null? 0 : node2.val;
        TreeNode node = new TreeNode(v1+v2);
        node.left = buildTree(node1 == null? null : node1.left, node2 ==null? null: node2.left);
        node.right = buildTree(node1 == null? null :node1.right, node2 ==null? null: node2.right);
        return node;
    }
}
