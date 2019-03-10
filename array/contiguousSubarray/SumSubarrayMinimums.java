package leetcode.array.contiguousSubarray;
/*
907. Sum of Subarray Minimums
Medium

Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.

Since the answer may be large, return the answer modulo 10^9 + 7.



Example 1:

Input: [3,1,2,4]
Output: 17
Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.
 */
import java.util.*;

public class SumSubarrayMinimums {
    /*
    dp[i + 1]: Sum of minimum of subarrays which end with A[i]
    dp[i + 1] = dp[prev + 1] + (i - prev) * A[i], where prev is the last
    number which is less than A[i], since we maintain a monotonous increasing stack,
    prev = stack.peek()
     */
    public int sumSubarrayMins(int[] A) {
        Stack<Integer> s = new Stack<Integer>();
        int[] dp = new int[A.length];
        dp[0] = A[0];
        s.push(0);
        for(int i = 1; i < A.length; i++){
            while(!s.isEmpty() && A[i] <= A[s.peek()]) s.pop();
            if(s.isEmpty()){
                dp[i] = (i+1)*A[i];
                s.push(i);
            }else{
                int pre = s.peek();
                dp[i] = dp[pre] + (i-pre)*A[i];
                s.push(i);
            }
            //System.out.println(dp[i]);
        }
        int sum = 0, M = (int)1e9+7;
        for(int i = 0; i < A.length; i++){
            sum += dp[i];
            sum %= M;
        }
        return sum;
    }
}
