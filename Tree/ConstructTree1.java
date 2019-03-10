package leetcode.Tree;
/*
106. Construct Binary Tree from Inorder and Postorder Traversal
Medium

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]

Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7


 */
public class ConstructTree1 {
    int postIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx = postorder.length-1;
        return build(inorder, 0, inorder.length-1, postorder);
    }
    private TreeNode build(int[] inorder, int inBegin, int inEnd, int[] postorder){
        if(postIdx < 0) return null;
        if(inBegin > inEnd) return null;

        int midVal = postorder[postIdx];
        TreeNode root = new TreeNode(midVal);
        postIdx--; //每用一个，要马上计数，再return
        if(inBegin == inEnd) return root;

        int inMid = inBegin; //要取计数前的值
        while(inorder[inMid] != midVal) inMid++;

        root.right = build(inorder, inMid+1, inEnd, postorder);
        root.left = build(inorder, inBegin, inMid-1, postorder);

        return root;
    }
}
