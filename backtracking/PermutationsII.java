package leetcode.backtracking;
/*
47. Permutations II
Medium

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]


 */
import java.util.*;

public class PermutationsII {
    //solution
    /*
    没搞懂
     */
    public List<List<Integer>> permuteUnique1(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, used, list, res);
        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        if(list.size()==nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue;
            //这里需要一些想法才能写出来

            used[i]=true;
            list.add(nums[i]);
            dfs(nums,used,list,res);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }


    //my solution use set
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> path = new ArrayList<Integer>();

        boolean[] used = new boolean[nums.length];
        backtrack(nums, result, path, used);
        return new ArrayList<List<Integer>>(result);
    }

    private void backtrack(int[] nums, Set<List<Integer>> result, List<Integer> path, boolean[] used){
        //System.out.println(path);
        if(path.size() == nums.length){
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            else{
                path.add(nums[i]);
                used[i] = true;
                backtrack(nums, result, path, used);
                used[i] = false;
                path.remove(path.size()-1);
            }

        }
    }

}
