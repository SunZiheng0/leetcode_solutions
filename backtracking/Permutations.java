package leetcode.backtracking;
/*
46. Permutations
Medium

Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]


 */
import java.util.*;
public class Permutations {
    //my solution
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        ArrayList<Integer> newL = new ArrayList<Integer>();
        newL.add(nums[0]);
        result.add(newL);

        for(int i = 1; i < nums.length; i++){
            List<List<Integer>> before = new ArrayList<>(result);
            result.clear();
            for(List<Integer> l : before){

                for(int j = 0; j <= i; j++){
                    newL = new ArrayList<Integer>(l);
                    newL.add(j, nums[i]);
                    result.add(newL);
                }
            }
        }
        return result;
    }


    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0) return result;

        boolean used[] = new boolean[nums.length];
        List<Integer> path = new ArrayList<Integer>();


        dfs(result, nums, path, used);
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] nums, List<Integer> path, boolean[] used){
        //System.out.println(path);
        //基准情况不准在path加减任何东西，才能正确回溯
        if(path.size() == nums.length){
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            else{
                used[i] = true;
                path.add(nums[i]);
                dfs(result, nums, path, used);
                used[i] = false;
                path.remove(path.size()-1);
            }
        }
    }
}
