package leetcode.DymanicProgramming;
/*
718. Maximum Length of Repeated Subarray
Medium

Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:

Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation:
The repeated subarray with maximum length is [3, 2, 1].

 */
public class MaxLenSubstring {
    //题目的难度在于，要求substring是连续的，这个不知道怎么处理
    //修改maxLen(i, j)的含义，两个序列，a[]有i个值，且最长子串以A[i-1]结尾
    //b[]有j个值，且最长子串以B[j-1]结尾
    //再用个全局max去选出最大值
    /*
    使用动态规划，有两件事很重要
    1）递推式所用到的所有子问题，是不是都已经求解，或者初始化了。
    2）有没有遍历所有可能？递推式跟遍历不一定有关系的。有时候是递推式帮忙完成了遍历的步骤。
    3）遇到这种递推式并非最终结果，需要进行遍历的问题， 用dp[i][j] 替代 f(i, j)可能要方便。
       因为要对f(i, j)来两重循环
       在含义上面看f(i, j)跟dp[i][j]是一致的。
     */

    private int max = Integer.MIN_VALUE;
    public int myFindLength(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int[][] memo = new int[n+1][m+1];
        for(int i = 0; i <= m; i++)
            for(int j = 0; j <= n; j++){
                if(i == 0 || j == 0) memo[i][j] = 0;
                else memo[i][j] = -1;
            }

        for(int i = 0; i <= m; i++)
            for(int j = 0; j <= n; j++)
                maxSub(A, B, memo, i, j);
        return max;
    }
    private int maxSub(int[] A, int[] B, int[][] memo, int i, int j){
        int result = -1;

        if(memo[i][j] > -1) return memo[i][j];

        if(A[i-1] == B[j-1]){
            result = 1 + maxSub(A, B, memo, i-1, j-1);
        }else{
            result = 0;
        }
        //System.out.println(i + " " + j + " : " + result);
        max = Math.max(max, result);
        memo[i][j] = result;
        return result;
    }


    //solution
    public int findLength(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for(int i = 0; i <= m; i++)
            for(int j = 0; j <= n; j++){
                if(i == 0 || j == 0) dp[i][j] = 0;
                else if(A[i-1] == B[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        return max;
    }
}
