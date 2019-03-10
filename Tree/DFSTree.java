package leetcode.Tree;
/*
897. Increasing Order Search Tree
Easy

Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.

https://leetcode.com/problems/increasing-order-search-tree/
 */

//BSTree 的深度优先，就是从小到大
public class DFSTree {

    TreeNode p = new TreeNode(-1);
    public TreeNode increasingBST(TreeNode root) {
        TreeNode result = p;
        traverse(root);
        return result.right;
    }
    private void traverse(TreeNode root){
        if(root == null) return;
        traverse(root.left);
        p.right = new TreeNode(root.val);  //错误 p.right = root;
                                           // p = p.right;
                                           // 不能改变root , p.right = root 只是改了引用
        p = p.right;
        traverse(root.right);
    }
}
