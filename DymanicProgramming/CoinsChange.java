package leetcode.DymanicProgramming;
/*
322. Coin Change
Medium

You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

 */

public class CoinsChange {

    //recursive
    //min(1+coinChange(amount-coin1_value), 1+coinChange(amount-coin2_value, ......)
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount+1];
        for(int i = 0; i < memo.length; i++) memo[i] = -2;
        return minCoins(coins, memo, amount);
    }
    private int minCoins(int[] coins, int[] memo, int amount){
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        if(memo[amount] > -2) return memo[amount];

        int min = Integer.MAX_VALUE;
        int next = -2;
        int result = -2;
        for(int i = 0; i < coins.length; i++){
            next = minCoins(coins, memo, amount - coins[i]);
            if(next != -1){
                min = Math.min(min, next + 1);
            }
        }
        if(min == Integer.MAX_VALUE){
            result = -1;
        }else{
            result = min;
        }
        memo[amount] = result;
        return result;
    }
}
