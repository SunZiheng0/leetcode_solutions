package leetcode.array;
/*
442. Find All Duplicates in an Array
Medium

Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

 */
import java.util.*;

public class FindAllDuplicatesinArray {
    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        //System.out.println(nums.length);
        for(int i = 0; i < nums.length; i++){
            int num = Math.abs(nums[i]);
            //System.out.println(num);
            if(nums[num-1] < 0) result.add(num);
            else nums[num-1] = - nums[num-1];
        }
        return result;
    }

}
