package leetcode.DymanicProgramming;

public class SubarraySumEqualsK {
    //my O(n**2)
    public int mySubarraySum(int[] nums, int k) {
        if(nums.length == 0) return 0;
        int count = 0;
        int sum[] = new int[nums.length];
        sum[0] = nums[0];
        if(sum[0] == k) count++;
        for(int i = 1; i < nums.length; i++){
            sum[i] = sum[i-1] + nums[i];
            if(sum[i] == k) count++;
        }
        for(int i = 1; i < nums.length; i++){
            for(int j = i ; j < nums.length; j++){
                sum[j] = sum[j] - nums[i - 1];
                if(sum[j] == k) count++;
            }
        }
        return count;
    }

    //sum[i, j] = sum[0, j] - sum[0, i - 1]
    //use the map to memory the processing result
    //像我原来的想法，记录所有 sum[0, i] 仍然是 O(n**2)
    //

}
