package leetcode.backtracking;
/*
113. Path Sum II
Medium

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1

 */
import java.util.*;

public class PathSumIII {
    //对path的理解特别重要，把path理解为在dfs开始前，已经加入了root.val，等待基本情况的处理
    //而基本情况不改变path，只做判断。这样dfs不会改变path
    //只要在dfs后回退一格，就可以接下去，就可以回到原点，继续处理其他情况
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        List<Integer> path = new ArrayList<Integer>();
        path.add(root.val);
        dfs(result, path, root, sum - root.val);
        return result;
    }
    private void dfs(List<List<Integer>> result, List<Integer> path, TreeNode root, int sum){
        if(root == null) return;
        if(root.left == null && root.right == null && sum == 0){
            result.add(new ArrayList<Integer>(path));
            return;
        }

        if(root.left != null){
            path.add(root.left.val);
            dfs(result, path, root.left, sum - root.left.val);
            path.remove(path.size()-1);
        }

        if(root.right != null){
            path.add(root.right.val);
            dfs(result, path, root.right, sum - root.right.val);
            path.remove(path.size()-1);
        }

    }
}
