package leetcode.fibonacci;
/*
198. House Robber
Easy

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
 */
public class HouseRobber {
    //recursive O(2**n)
    public int robber1(int[] nums) {
        if(nums.length == 0) return 0; //不能用nums == null， 不是null ，有地址的，只是没有值
        return rob1(nums, nums.length - 1);
    }
    private int rob1(int[] nums, int end){
        if(end < 0) return 0;
        if(end == 0) return nums[0];
        return Math.max(rob1(nums, end - 2) + nums[end], rob1(nums, end - 1));
    }

    //recursive with memory
    //被计算一次的，不会再重复计算，所以是O(n)
    private int[] memory2;
    public int robber2(int[] nums) {
        if(nums.length == 0) return 0;
        memory2 = new int[nums.length];
        return rob2(nums, nums.length-1);
    }
    private int rob2(int[] nums, int end){
        int result = 0;
        if(end == 0){
            result = nums[0];
            memory2[0] = result;
        }
        if(end == 1){
            result = Math.max(nums[1], memory2[0]);
            memory2[1] = result;
        }

        result = Math.max(memory2[end - 2] + nums[end], memory2[end - 1]);
        memory2[end] = result;
        return result;
    }

    //iteration with memory
    //bottom to top
    //O(n)
    private int[] memory3;
    private int robber3(int[] nums){
        if(nums.length == 0) return 0;
        memory3 = new int[nums.length];

        memory3[0] = nums[0];
        if(nums.length == 1) return memory3[0];
        memory3[1] = Math.max(nums[1], memory3[0]);
        if(nums.length == 2) return memory3[1];

        for(int i = 2; i < nums.length; i++){
            memory3[i] = Math.max(nums[i] + memory3[i - 2], memory3[i - 1]);
        }
        return memory3[nums.length-1];
    }

    //iteration with variables
    private int robber4(int[] nums){
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int max_i_2 = nums[0], max_i_1 = Math.max(nums[0], nums[1]);
        int max_i = 0;
        for(int i = 2; i < nums.length; i++){
            max_i = Math.max(max_i_2 + nums[i], max_i_1);
            max_i_2 = max_i_1;
            max_i_1 = max_i;
        }
        return max_i;
    }

}
