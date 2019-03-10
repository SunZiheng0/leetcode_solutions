package leetcode.backtracking;
/*
40. Combination Sum II
Medium

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

 */

import java.util.*;

public class CombinationSumII {
    //with duplicates
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<Integer>();

        Arrays.sort(candidates);
        backtrack(candidates, result, path, target, 0);
        return result;
    }

    private void backtrack(int[] candidates, List<List<Integer>> result, List<Integer> path, int target, int start){
        if(target == 0){
            result.add(new ArrayList<Integer>(path));
            return;
        }

        if(target < 0 || start > candidates.length-1) return;

        //deal with duplicates
        for(int i = start; i < candidates.length; i++){
            path.add(candidates[i]);

            int repTimes = 1;
            int j = i;
            while(j < candidates.length-1 && candidates[j] == candidates[j+1]){
                j++;
                path.add(candidates[j]);
                repTimes++;
            }
            backtrack(candidates, result, path, target - candidates[i]*repTimes, j+1);
            while(repTimes-- > 0) path.remove(path.size()-1);
        }

    }
}
