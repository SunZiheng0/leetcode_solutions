package leetcode.KthProblem;
// quick select 原地选择，但会改变数组的顺序
// priority queue 不会改变原来数组的顺序

public class Kselect {
    private int select(int[] nums, int k){
        if(k > nums.length) return -1;
        return kselect(nums, 0, nums.length - 1, k);
    }
    private int kselect(int[] nums, int lo, int hi, int k){
        if(lo >= hi ) return nums[lo];
        int part = partition(nums, lo, hi, k);
        if(part == k) return nums[k];
        else if(part < k){
            return kselect(nums, part + 1, hi, k);
        }else {
            return kselect(nums, lo, part - 1, k);
        }
    }
    private int partition(int[] nums, int lo, int hi, int k){
        int i = lo, j = hi+1;
        int val = nums[lo];
        while (true){
            while (nums[++i] < val) if(i == hi) break;
            while (nums[--j] > val) if(j == lo) break;
            if(i <= j){
                exch(nums, i, j);
            }else{
                break;
            }
        }
        exch(nums, lo, j);
        return j;
    }
    private void exch(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
