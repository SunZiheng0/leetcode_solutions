package leetcode.backtracking;
/*
863. All Nodes Distance K in Binary Tree
Medium

We are given a binary tree (with root node root), a target node, and an integer value K.

Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.



Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2

Output: [7,4,1]
 */
import java.util.*;
public class AllNodesDistanceK {
    boolean found = false;
    List<TreeNode> foundPath = new ArrayList<TreeNode>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new ArrayList<Integer>();
        List<TreeNode> path = new ArrayList<TreeNode>();

        if(root == null) return result;
        path.add(root);
        searchTarget(path, root, target);

        if(!found) return result;

        int index = foundPath.size()-1;
        while(index >= 0 && K >= 0){
            TreeNode node = foundPath.get(index);
            TreeNode nextNode = null;
            if(index != foundPath.size()-1) nextNode = foundPath.get(index+1);
            index--;
            getKDistNode(result, nextNode, node, K);
            K--;
        }
        return result;
    }

    private void searchTarget(List<TreeNode> path, TreeNode root, TreeNode target){
        if(root == null) return;
        if(root == target){
            //System.out.println("found " + root.val); //在backtrack中，先在path加入节点，再判断
                                                       //不准在判断中改变path
                                                       // 得到path后要保存起来，不能用path，因为后面
                                                       //path会被backtrack改变
            foundPath = new ArrayList<TreeNode>(path);
            found = true;
            return;
        }

        if(!found && root.left != null){
            path.add(root.left);
            searchTarget(path, root.left, target);
            path.remove(path.size()-1);
        }
        if(!found && root.right != null){
            path.add(root.right);
            searchTarget(path, root.right, target);
            path.remove(path.size()-1);
        }

    }

    private void getKDistNode(List<Integer> result, TreeNode nextNode, TreeNode root, int K){
        if(root == null) return;
        if(K == 0){
            result.add(root.val);
            return;
        }
        //要避免对path路径上的值进行搜索
        if(root.left != null && root.left != nextNode) getKDistNode(result, nextNode, root.left, K-1);
        if(root.right != null && root.right != nextNode) getKDistNode(result, nextNode,root.right, K-1);
    }

}
