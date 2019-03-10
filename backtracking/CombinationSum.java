package leetcode.backtracking;
/*
39. Combination Sum
Medium

Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]

 */
import java.util.*;
//每个选项可重复

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<Integer>();

        backtrack(candidates, result, path, target, 0);
        return result;
    }
    private void backtrack(int[] candidates, List<List<Integer>> result, List<Integer> path, int target, int start){
        if(target == 0){
            result.add(new ArrayList<Integer>(path));
            return;
        }

        if(target < 0 || start > candidates.length-1) return;

        for(int i = start; i < candidates.length; i++){
            path.add(candidates[i]);
            backtrack(candidates, result, path, target - candidates[i], i);
            path.remove(path.size()-1);
        }
    }
}
