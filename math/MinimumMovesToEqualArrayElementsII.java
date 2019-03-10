package leetcode.math;
/*
462. Minimum Moves to Equal Array Elements II
Medium

319

29

Favorite

Share
Given a non-empty integer array, find the minimum number of moves required to make
all array elements equal, where a move is incrementing a selected element by 1 or
decrementing a selected element by 1.

You may assume the array's length is at most 10,000.

 */
import java.util.*;

public class MinimumMovesToEqualArrayElementsII {
    //成对移动到中位数
    //设 m 为中位数。a 和 b 是 m 两边的两个元素，且 b > a。要使 a 和 b 相等，它们总共移动的次数为
    // b - a，这个值等于 (b - m) + (m - a)，也就是把这两个数移动到中位数的移动次数。
    //设数组长度为 N，则可以找到 N/2 对 a 和 b 的组合，使它们都移动到 m 的位置。
    public int minMoves21(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int lo = 0, hi = nums.length-1;
        int count = 0;
        while(lo < hi){
            count += nums[hi] - nums[lo];
            hi--;
            lo++;
        }
        return count;
    }

    //fast select
    public int minMoves22(int[] nums) {
        int move = 0;
        int median = findKthSmallest(nums, nums.length / 2); //k 是下标k, 0, 1, 2, ... , k-1, k
        for (int num : nums) {
            move += Math.abs(num - median);
        }
        return move;
    }

    private int findKthSmallest(int[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            }
            if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] nums, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (nums[++i] < nums[l] && i < h) ;
            while (nums[--j] > nums[l] && j > l) ;
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
