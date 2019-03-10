package leetcode.array.contiguousSubarray;
/*
918. Maximum Sum Circular Subarray
Medium

Given a circular array C of integers represented by A, find the maximum possible
sum of a non-empty subarray of C.

Here, a circular array means the end of the array connects to the beginning of the array.
(Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)

Also, a subarray may only include each element of the fixed buffer A at most once.
(Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j
with k1 % A.length = k2 % A.length.)



Example 1:

Input: [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3

 */
/*
So there are two case.

    The first is that the subarray take only a middle part, and we know how to find the max
     subarray sum.
    The second is that the subarray take a part of head array and a part of tail array.
    We can transfer this case to the first one.
    The maximum result equals to the total sum minus the minimum subarray sum.

Here is a diagram by @motorix:

So the max subarray circular sum equals to
max(the max subarray sum, the total sum - the min subarray sum)
 */

/*
Corner case

Just one to pay attention:
If all numbers are negative, maxSum = max(A) and minSum = sum(A).
In this case, max(maxSum, total - minSum) = 0, which means the sum of an empty subarray.
According to the deacription, We need to return the max(A), instead of sum of am empty subarray.
So we return the maxSum to handle this corner case.
 */
public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] A) {
        int[] dpmax = new int[A.length];
        dpmax[0] = A[0];
        int max = dpmax[0];
        for(int i = 1; i < A.length; i++){
            dpmax[i] = Math.max(dpmax[i-1] + A[i], A[i]);
            max = Math.max(max, dpmax[i]);
        }

        int[] dpmin = new int[A.length];
        dpmin[0] = A[0];
        int min = dpmin[0];
        for(int i = 1; i < A.length; i++){
            dpmin[i] = Math.min(dpmin[i-1] + A[i], A[i]);
            min = Math.min(min, dpmin[i]);
        }

        int sum = 0;
        for(int i = 0; i < A.length; i++) sum += A[i];

        return max > 0 ? Math.max(max, sum - min) : max;

    }
}
