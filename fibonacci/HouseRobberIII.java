package leetcode.fibonacci;
/*
337. House Robber III
Medium

The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:

Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \
     3   1

Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 */
import java.util.*;

public class HouseRobberIII {
    //my solution
    //depth first search , dynamic programming with memory
    // use index and Map as memory
    public int myRob(TreeNode root) {
        if(root == null) return 0;
        Map<Integer, Integer> memory = new HashMap<Integer, Integer>();
        if(root.left == null && root.right == null) return root.val;

        dfsRob(memory, root, 0);
        return memory.get(0);
    }

    private void dfsRob(Map<Integer, Integer> memory, TreeNode root, int index){
        if(root == null){
            memory.put(index, 0);
            return;    //must return at basic situation!
        }
        if(root.left == null && root.right == null){
            memory.put(index, root.val);
            return;  //must return at basic situation!
        }

        int indexLeft = index * 2 + 1, indexRight = index * 2 + 2;
        dfsRob(memory, root.left, indexLeft);
        dfsRob(memory, root.right, indexRight);

        int maxWithoutRoot = memory.getOrDefault(indexLeft, 0) + memory.getOrDefault(indexRight, 0);

        int indexLeftLeft = indexLeft * 2 + 1;
        int indexLeftRight = indexLeft * 2 + 2;
        int indexRightLeft = indexRight * 2 + 1;
        int indexRightRight = indexRight * 2 + 2;

        int maxWithRoot = root.val + memory.getOrDefault(indexLeftLeft, 0) + memory.getOrDefault(indexLeftRight, 0)
                    + memory.getOrDefault(indexRightLeft, 0) + memory.getOrDefault(indexRightRight, 0);

        memory.put(index, Math.max(maxWithoutRoot, maxWithRoot));
    }

    // the solution
    // recursive
    // O(logn * 2**n) == O(2**n)
    public int rob1(TreeNode root) {
        if (root == null) return 0;

        int val = 0;

        if (root.left != null) {
            val += rob1(root.left.left) + rob1(root.left.right);
        }

        if (root.right != null) {
            val += rob1(root.right.left) + rob1(root.right.right);
        }

        return Math.max(val + root.val, rob1(root.left) + rob1(root.right));
    }

    // if you recall the two conditions for dynamic programming:
    // "optimal substructure" + "overlapping of subproblems",
    // dynamic programming
    public int rob2(TreeNode root) {
        return robSub2(root, new HashMap<>());
    }

    private int robSub2(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);

        int val = 0;

        if (root.left != null) {
            val += robSub2(root.left.left, map) + robSub2(root.left.right, map);
        }

        if (root.right != null) {
            val += robSub2(root.right.left, map) + robSub2(root.right.right, map);
        }

        val = Math.max(val + root.val, robSub2(root.left, map) + robSub2(root.right, map));
        map.put(root, val);

        return val;
    }
    /*
    If we were able to maintain the information about the two scenarios for each tree root,
    let's see how it plays out. Redefine rob(root) as a new function which will return an
    array of two elements, the first element of which denotes the maximum amount of money
    that can be robbed if root is not robbed, while the second element signifies the maximum
    amount of money robbed if it is robbed.

    Let's relate rob(root) to rob(root.left) and rob(root.right)..., etc. For the 1st element
    of rob(root), we only need to sum up the larger elements of rob(root.left)
    and rob(root.right), respectively, since root is not robbed and we are free to
    rob its left and right subtrees. For the 2nd element of rob(root), however, we only
    need to add up the 1st elements of rob(root.left) and rob(root.right), respectively,
    plus the value robbed from root itself, since in this case it's guaranteed that we
    cannot rob the nodes of root.left and root.right.
     */
    // dynamic programming to greedy

    public int rob3(TreeNode root) {
        int[] res = robSub3(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub3(TreeNode root) {
        if (root == null) return new int[2];

        int[] left = robSub3(root.left);
        int[] right = robSub3(root.right);
        int[] res = new int[2];

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }

}
