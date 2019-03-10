package leetcode.backtracking;
/*
https://leetcode.com/problems/subsets/
78. Subsets
Medium

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]


 */
import java.util.*;

//数字不重复，不同序列算相同结果的，用start去遍历
//数字不重复的，不同序列算不同结果的，用used去遍历，每次只选一个
public class Subsets {
    //my solution
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<Integer>();
        backtrack1(nums, result, path, 0);
        return result;
    }
    private void backtrack1(int[] nums, List<List<Integer>> result, List<Integer> path, int start){
        System.out.println(path);
        if(start > nums.length-1) return;

        result.add(new ArrayList<Integer>(path));//不能把引用拉过来，引用是会变的。必须新起一个变量
                                                 //用start， 是因为无方向，避免重复。

        //path 已经被处理（记录，判断）了， 下面的遍历接下来的情况。
        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            backtrack1(nums, result, path, i+1);
            path.remove(path.size()-1);
        }
    }

}
