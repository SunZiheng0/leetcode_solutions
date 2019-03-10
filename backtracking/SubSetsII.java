package leetcode.backtracking;
/*
90. Subsets II
Medium

Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]


 */

import java.util.*;

public class SubSetsII {
    // my solution
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(nums);

        backtrack(nums, result, path, 0);
        return result;
    }
    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> path, int start) {
        result.add(new ArrayList<Integer>(path));

        if (start > nums.length - 1) return;

        //12223333
        //则分为 path = 222 + 剩下的 ， 22 + 剩下的， 2 + 剩下的
        //每个重复值，都只选一种情况，则不会重复。如果在开头遇到2,则按 222, 22, 2的顺序来
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            int removeTimes = 1;
            int j = i;
            while (j < nums.length - 1 && nums[i] == nums[j + 1]) {
                j++;
                path.add(nums[j]);
                removeTimes++;
            }
            backtrack(nums, result, path, j + 1);
            while (removeTimes-- > 0) path.remove(path.size() - 1);
        }
    }


    // wrong solution
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<Integer>();

        backtrack2(nums, result, path, 0);
        return result;
    }
    private void backtrack2(int[] nums, List<List<Integer>> result, List<Integer> path, int start){
        result.add(new ArrayList<Integer>(path));

        if(start > nums.length-1) return;

        for(int i = start; i < nums.length; i++){
            if(1 <= i && nums[i-1] == nums[i]) continue;  //要考虑每次循环都去掉了重复值
                                                          //而要求是，以此为path最新值的时候才去掉
            path.add(nums[i]);
            backtrack2(nums, result, path, i+1);
            path.remove(path.size()-1);
        }
    }
}
