package leetcode.array.contiguousSubarray;
/*
209. Minimum Size Subarray Sum
Medium

Given an array of n positive integers and a positive integer s, find the minimal
length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example:

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinimumSizeSubarraySum {
    //类似滑窗
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        for(end = 0; end < nums.length; end++){
            sum += nums[end];
            if(sum < s) continue;
            else if(sum == s){
                int newLen = end - start + 1;
                minLen = Math.min(minLen, newLen);
            }else{
                while(true){
                    int newSum = sum - nums[start];
                    if(newSum > s){
                        start++;
                        sum = newSum;
                    }else if(newSum == s){
                        start++;
                        sum = newSum;
                        int newLen = end -start + 1;
                        minLen = Math.min(minLen, newLen);
                        break;
                    }else{
                        int newLen = end -start + 1;
                        minLen = Math.min(minLen, newLen);
                        break;
                    }
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
