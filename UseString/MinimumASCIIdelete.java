package leetcode.UseString;
/*
712. Minimum ASCII Delete Sum for Two Strings
Medium

Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.

Example 1:

Input: s1 = "sea", s2 = "eat"
Output: 231
Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
Deleting "t" from "eat" adds 116 to the sum.
At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.

 */

 //dp[i][j] = minimumDeleteSum( s1[0,i], s2[0,j])
public class MinimumASCIIdelete {
     public int minimumDeleteSum(String s1, String s2) {
         int m = s1.length(), n = s2.length();
         int sum = 0;

         int[][] dp = new int[m+1][n+1];
         char[] cs1 = s1.toCharArray();
         char[] cs2 = s2.toCharArray();

         dp[0][0] = 0;
         for(int i = 1; i <= m; i++) dp[i][0] = dp[i-1][0] + cs1[i-1];
         for(int j = 1; j <= n; j++) dp[0][j] = dp[0][j-1] + cs2[j-1];

         for(int i = 1; i <= m; i++)
             for(int j = 1; j <= n; j++){
                 if(cs1[i-1] == cs2[j-1])
                     dp[i][j] = dp[i-1][j-1];
                 else{
                     dp[i][j] = Math.min(dp[i-1][j] + cs1[i-1], dp[i][j-1] + cs2[j-1]);
                     dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1] + cs1[i-1] + cs2[j-1]);
                 }
             }
         return dp[m][n];
     }

}
