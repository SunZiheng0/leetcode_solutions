package leetcode.Tree;
/*
889. Construct Binary Tree from Preorder and Postorder Traversal
Medium

Return any binary tree that matches the given preorder and postorder traversals.

Values in the traversals pre and post are distinct positive integers.



Example 1:

Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]

 */
public class ConstructTree2 {
    int preIdx = 0;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if(pre.length == 0) return null;
        return build(pre, post, 0, post.length-1);
    }
    private TreeNode build(int[] pre, int[] post, int postBegin, int postEnd){
        if(postBegin > postEnd) return null;
        if(preIdx > pre.length-1) return null;

        TreeNode root = new TreeNode(pre[preIdx]);
        preIdx++;  //return 前要计数，已经用了

        if(postBegin == postEnd) return root;

        if(preIdx > pre.length-1) return root;
        int leftMidVal = pre[preIdx];
        int leftMidIdx = postEnd;

        while(0<= leftMidIdx && post[leftMidIdx] != leftMidVal) leftMidIdx--;
        //if(leftMidIdx == -1) return root;

        root.left = build(pre, post, postBegin, leftMidIdx);
        root.right = build(pre, post, leftMidIdx+1, postEnd-1);
        return root;
    }
}
