package leetcode.fibonacci;
/*
70. Climbing Stairs
Easy

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

 */
public class ClimbStairs {
    //normal
    int count = 0;
    private int climbStairs1(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        count = 0;
        climb(0, n);
        return count;
    }
    private void climb(int start, int n){
        if(start > n) return;
        if(start == n) count++;
        climb(start+1, n);
        climb(start+2, n);
        // 这种结构在树里面可以用， 1/2递减，复杂度n，
        // 在n递减下的情况就是2**n
    }
    //大量重复计算，复杂度 随n指数增加

    private int climbStairs2(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        int cn_1 = 2, cn_2 = 1;
        int cn = 0;
        while(n-- >= 3){
            cn = cn_1 + cn_2; //错误： cn = cn_1 + cn_2 * 2;
                              //cn_1 跨1步， cn_2跨2步，可以涵盖所有情况，而且二者独立
            cn_2 = cn_1;
            cn_1 = cn;
        }
        return cn;
    }
}
