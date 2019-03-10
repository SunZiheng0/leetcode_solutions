package leetcode.DymanicProgramming;
/*
486. Predict the Winner
Medium

Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on. Each time a player picks a number, that number will not be available for the next player. This continues until all the scores have been chosen. The player with the maximum score wins.

Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.

Example 1:

Input: [1, 5, 2]
Output: False
Explanation: Initially, player 1 can choose between 1 and 2.
If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2).
So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
Hence, player 1 will never be the winner and you need to return False.

 */
public class WhoCanWin {
/*
The dp[i][j] saves how much more scores that the first-in-action player will get
from i to j than the second player. First-in-action means whomever moves first.
You can still make the code even shorter but I think it looks clean in this way.
 */
    public boolean PredictTheWinner(int[] nums) {
        if(nums.length <= 2) return true;
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) dp[i][i] = nums[i];

        for(int d = 1; d < n; d++)
            for(int i = 0; i+d < n; i++)
                dp[i][i+d] = Math.max(nums[i] - dp[i+1][i+d], nums[i+d] - dp[i][i+d-1]);
        return dp[0][n-1] >= 0;//If the scores of both players are equal,
                               // then player 1 is still the winner.
    }

}
