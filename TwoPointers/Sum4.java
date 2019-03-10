package leetcode.TwoPointers;
/*
18. 4Sum
Medium

Given an array nums of n integers and an integer target, are there elements
a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets
in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]


 */


import java.util.*;

public class Sum4 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length < 4) return result;
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            if(1 <= i && nums[i] == nums[i-1]) continue;  //要保证每次计算的nums[i], nums[j]是不同的
                                                          // k, l的遍历已经找遍了中间所有可能
            for(int j = nums.length-1; i+3 <= j; j--){
                if(j <= nums.length-2 && nums[j] == nums[j+1]) continue;
                int newTarget = target - nums[i] - nums[j];
                int k = i+1, l = j-1;
                while(k < l){
                    //System.out.println(i + " " + k + " " + l + " " + j);
                    if(nums[k] + nums[l] == newTarget){
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[k]);
                        list.add(nums[l]);
                        list.add(nums[j]);
                        result.add(list);
                        k++;                   //找到一种情况后，要继续进行，就得推动一边继续，否则死循环
                        while(k <= l && nums[k] == nums[k-1]) k++;  //这里也要注意重复值，否则结果有重复
                    }else if(nums[k] + nums[l] < newTarget){
                        k++;
                        while(k <= l && nums[k] == nums[k-1]) k++; //如果跟上次的值一样，就递增
                                          //边界设为l，在下个循环退出，也不会自己循环到数组边界
                    }else{
                        l--;
                        while(k <= l && nums[l] == nums[l+1]) l--;
                    }

                }
            }
        }
        return result;
    }


    //backtrack 速度太慢。可以用于解决长度不等的问题
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0) return result;
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            int repTimes = 1;
            path.add(nums[i]);
            int j = i;
            while(j <= nums.length-2 && nums[j]==nums[j+1]){
                path.add(nums[i]);
                repTimes++;
                j++;
            }
            backtrack(result, path, nums, j+1, target - nums[i]*repTimes);
            while(repTimes-- > 0) path.remove(path.size()-1);
        }

        return result;
    }
    private void backtrack(List<List<Integer>> result, List<Integer> path, int[] nums, int start, int target){
        //System.out.println(path);
        if(path.size() > 4 || start > nums.length) return;
        if(path.size() == 4 && target == 0){
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for(int i = start; i < nums.length; i++){
            int repTimes = 1;
            path.add(nums[i]);
            int j = i;
            while(j <= nums.length-2 && nums[j]==nums[j+1]){
                path.add(nums[i]);
                repTimes++;
                j++;
            }
            backtrack(result, path, nums, j+1, target - nums[i]*repTimes);
            while(repTimes-- > 0) path.remove(path.size()-1);
        }
    }
}
