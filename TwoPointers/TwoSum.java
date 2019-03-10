package leetcode.TwoPointers;
/*
1. Two Sum
Easy

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

 */


import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if(nums.length < 2) return result;
        //map (need, index)
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(m.containsKey(nums[i])){
                result[0] = m.get(nums[i]);
                result[1] = i;
                return result;
            }else{
                m.put(target - nums[i], i);
            }
        }

        return result;
    }

    //题目要求返回index，所以不能用sort改变下标
    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        Arrays.sort(nums);
        int i = 0, j = nums.length-1;
        while(i < j){
            int sum = nums[i] + nums[j];
            if(sum == target){
                result[0] = i;
                result[1] = j;
                return result;
            }else if(sum < target){
                i++;
            }else{
                j--;
            }
        }

        return result;
    }
}
