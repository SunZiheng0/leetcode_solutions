package leetcode.dfs;
/*
15. 3Sum
Medium

Given an array nums of n integers, are there elements a, b, c in nums such that
a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.
 */
import java.util.*;
public class Sum3 {
    //my DFS
    Set<List<Integer>> result = new HashSet<>();
    List<Integer> path = new ArrayList<Integer>();
    public List<List<Integer>> myThreeSum(int[] nums) {

        dfs(nums, path, 0);

        return new ArrayList(result);
    }
    private void dfs(int[] nums, List<Integer> path, int index){

        if(path.size() == 3 && path.get(0) + path.get(1) + path.get(2) == 0){
            List<Integer> l = new ArrayList<Integer>(path);
            //System.out.println(l);
            l.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            result.add(l);
            return;
        }
        if(index > nums.length-1 || path.size() > 3) return;
        for(int i = index; i < nums.length; i++){
            path.add(nums[i]);

            for(int j = i+1; j <= nums.length; j++)
                dfs(nums, path, j);
            path.remove(path.size()-1);
        }
    }

    //solution
    //3Sum to 2Sum
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 3) return result;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++){
            if(i == 0 || nums[i-1] < nums[i]){
                int lo = i+1, hi = nums.length-1;
                while(lo < hi){
                    if(nums[i] + nums[lo] + nums[hi] == 0){
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(nums[i]);
                        l.add(nums[lo]);
                        l.add(nums[hi]);
                        result.add(l);
                        while(lo < hi && nums[hi-1] == nums[hi]) hi--; //就算等于0, 还要继续遍历
                        hi--;
                    }else if(nums[i] + nums[lo] + nums[hi] < 0){
                        while(lo < hi && nums[lo] == nums[lo+1]) lo++; //循环是防止重复的
                        lo++;
                    }else{
                        while(lo < hi && nums[hi-1] == nums[hi]) hi--;
                        hi--;
                    }
                }
            }
        }
        return result;
    }
}
