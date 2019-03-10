package leetcode.iterationToAll;
/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2

 */
public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        if(nums.length <= 1) return -1;
        for(int i = 1; i < nums.length; i++){
            for(int j = i - 1; 0 <= j; j--){
                if(nums[i] == nums[j]) return nums[i];
            }
        }
        return -1;
    }
}
