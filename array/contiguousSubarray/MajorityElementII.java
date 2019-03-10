package leetcode.array.contiguousSubarray;
/*
229. Majority Element II
Medium

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.
 */
import java.util.*;
public class MajorityElementII {
    //moore vote
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int num1 = Integer.MAX_VALUE, count1 = 0, num2 = Integer.MAX_VALUE, count2 = 0;

        for(int i = 0; i < nums.length; i++){
            if(count1 == 0 && count2 == 0){  //1、2数组 同时为0
                num1 = nums[i];
                count1++;
            }else if(count1 == 0 && nums[i] != num2){  // 要考虑后面会出现 数组2 不为0, 数组1为0的情况
                num1 = nums[i];
                count1++;
            }else if(count2 == 0 && nums[i] != num1){
                num2 = nums[i];
                count2++;
            }else if(nums[i] == num1){
                count1++;
            }else if(nums[i] == num2){
                count2++;
            }else{
                count1--;
                count2--;
            }

        }

        int n = nums.length / 3;

        if(count1 > 0){              //要先判断数组是否为0,不能直接用num1
            count1 = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == num1) count1++;
            }
            if(count1 > n) result.add(num1);
        }

        if(count2 > 0){
            count2 = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == num2) count2++;
            }
            if(count2 > n) result.add(num2);
        }

        return result;
    }
}
