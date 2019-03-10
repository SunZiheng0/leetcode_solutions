package leetcode.array.contiguousSubarray;
/*
713. Subarray Product Less Than K
Medium

Your are given an array of positive integers nums.

Count and print the number of (contiguous) subarrays where the product of all the
elements in the subarray is less than k.

Example 1:

Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6],
[10, 5], [5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.

 */
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(nums.length == 0) return 0;

        long prod = 1;
        int start = 0, end = 0;
        int count = 0;

        //subarray end with uums[end]
        for(end = 0; end < nums.length; end++){
            prod *= nums[end];
            if(prod < k){
                count += end - start + 1;
            }else{
                while(start < end && prod >= k){
                    prod /= nums[start];
                    start++;
                }
                if(start < end){
                    count += end - start + 1;
                }else{
                    if(prod < k) count++;
                }

            }

        }
        return count;
    }

    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        if(nums.length == 0) return 0;

        long prod = 1;
        int start = 0, end = 0;
        int count = 0;

        //subarray end with uums[end]
        for(end = 0; end < nums.length; end++){
            prod *= nums[end];

            while(start < end && prod >= k){
                prod /= nums[start];
                start++;
            }

            if(start < end){
                count += end - start + 1;
            }else{
                if(prod < k) count++;
            }
        }
        return count;
    }
}
