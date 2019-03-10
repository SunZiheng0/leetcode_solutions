package leetcode.Tree;
/*
114. Flatten Binary Tree to Linked List
Medium

Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6

The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6


 */
import java.util.*;

public class FlattenTreeInPlace {
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> s = new Stack<TreeNode>();
        flat(s, root);
    }
    private TreeNode flat(Stack<TreeNode> s, TreeNode root){
        if(root == null) return null;
        s.push(root.right);
        root.right = flat(s, root.left);
        root.left = null;
        TreeNode pre = root;
        while(pre.right != null) pre = pre.right;
        pre.right = flat(s, s.pop());
        return root;
    }
}
