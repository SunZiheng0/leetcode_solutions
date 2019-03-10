package leetcode.array;
/*
153. Find Minimum in Rotated Sorted Array
Medium

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2]
Output: 1

 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        return binarySearch(nums, 0, nums.length-1);
    }
    private int binarySearch(int[] nums, int lo, int hi){
        if(lo > hi) return -1;
        if(lo == hi) return nums[lo];
        if(lo+1 == hi) return nums[lo] < nums[hi] ? nums[lo] : nums[hi];

        if(nums[lo] < nums[hi]) return nums[lo];  //判断是否真的存在折返

        int mid = (lo + hi) / 2;
        if(nums[lo] < nums[mid]){
            return binarySearch(nums, mid+1, hi);
        }else{
            return binarySearch(nums, lo+1, mid);
        }

    }
}
