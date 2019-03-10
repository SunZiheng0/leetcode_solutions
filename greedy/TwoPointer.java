package leetcode.greedy;
/*
11. Container With Most Water
Medium

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
 */

//双指针能把n*n时间减少到n
//关键是理解遍历过程中，中间相同情况下，最值会出现在哪一边，不停缩小数组
public class TwoPointer {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0, right = height.length-1;
        while(left < right){
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if(height[left] <= height[right]) left++;
            else right--;
        }
        return max;
    }
}
