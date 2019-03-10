package leetcode.others;
/*
454. 4Sum II
Medium

Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

Example:

Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]
 */


import java.util.*;
public class Sum4III {
    //用map记录结果，把n**4降为 N**2
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();

        for(int i = 0; i < C.length; i++)
            for(int j = 0; j < D.length; j++){
                int sum = C[i] + D[j];
                m.put(sum, m.getOrDefault(sum, 0) + 1);
            }

        int result = 0;
        for(int i = 0; i < A.length; i++)
            for(int j = 0; j < B.length; j++)
                result += m.getOrDefault(-1*(A[i] + B[j]), 0);
        return result;
    }
}
