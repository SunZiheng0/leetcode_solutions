package leetcode.array;

public class SearchInRotatedArrayII {
    public boolean search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }
    private boolean binarySearch(int[] nums, int target, int lo, int hi){
        if(lo > hi) return false;
        if(lo == hi) return nums[lo] == target;
        if(lo+1 == hi) return nums[lo] == target || nums[hi] == target;  //防止lo==mid，后面mid-1越界

        int mid = (lo + hi) / 2;
        if(nums[mid] == target) return true;

        if(nums[lo] == nums[mid]){          //相等的情况，无法判断，只能减1处理
            return binarySearch(nums, target, lo+1, hi);
        }else if(nums[lo] < nums[mid]){
            if(nums[lo] <= target && target <= nums[mid-1])
                return binarySearch(nums, target, lo, mid-1);
            else return binarySearch(nums, target, mid+1, hi);
        }else{
            if(nums[mid+1] <= target && target <= nums[hi])
                return binarySearch(nums, target, mid+1, hi);
            else return binarySearch(nums, target, lo, mid-1);
        }

    }
}
