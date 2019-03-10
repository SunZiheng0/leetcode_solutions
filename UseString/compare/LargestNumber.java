package leetcode.UseString.compare;
/*
179. Largest Number
Medium

Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
 */

import java.util.*;
public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] sarr = new String[nums.length];

        for(int i = 0; i < nums.length; i++)
            sarr[i] = String.valueOf(nums[i]);
        //直接用最后结果去比较的思想。
        //如果分类讨论排序，要考虑的情况非常多
        Arrays.sort(sarr, (s1, s2) -> (s1+s2).compareTo((s2+s1)));

        //System.out.println(Arrays.toString(sarr));

        String result = "";
        for(int i = sarr.length-1; 0 <= i; i--)
            result += sarr[i];

        if(result.charAt(0) == '0') result = "0";
        return result;
    }
}
