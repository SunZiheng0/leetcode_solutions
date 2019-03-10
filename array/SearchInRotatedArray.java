package leetcode.array;
/*
33. Search in Rotated Sorted Array
Medium

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise
return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

 */
public class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }
    private int binarySearch(int[] nums, int lo, int hi, int target){
        if(lo > hi) return -1;      //1、2的基准情况，直接判断。
        if(lo == hi){               //因为在下面的判断中用了大于、小于
            if(nums[lo] == target) return lo;
            else return -1;
        }
        if(lo+1 == hi){
            if(nums[lo] == target) return lo;
            else return nums[hi] == target ? hi : -1;
        }

        int mid = (lo + hi) / 2;
        if(nums[mid] == target) return mid;  //底部除法，所以长度2时候，出现lo==mid

        if(nums[mid] > nums[lo]){        //长度为2要分开处理，要不这里数组越界了
            if(nums[lo] <= target && target <= nums[mid-1]) // 单边的判断不成立
                return binarySearch(nums, lo, mid-1, target);
            else return binarySearch(nums, mid+1, hi, target);
        }else{
            if(nums[mid+1] <= target && target <= nums[hi])
                return binarySearch(nums, mid+1, hi, target);
            else return binarySearch(nums, lo, mid-1, target);
        }
    }
}
