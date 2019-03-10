package leetcode.greedy;
/*
910. Smallest Range II
Medium

Given an array A of integers, for each integer A[i] we need to choose either x = -K or x = K,
and add x to A[i] (only once).

After this process, we have some array B.

Return the smallest possible difference between the maximum value of B and the
minimum value of B.
 */
/*
---------------explain----------------------
Intuition:
For each integer A[i],
we may choose either x = -K or x = K.

If we add K to all B[i], the result won't change.

It's the same as:
For each integer A[i], we may choose either x = 0 or x = 2 * K.

Explanation:
We sort the A first, and we choose to add x = 0 to all A[i].
Now we have res = A[n - 1] - A[0].
Starting from the smallest of A, we add 2 * K to A[i],
hoping this process will reduce the difference.

Update the new mx = max(mx, A[i] + 2 * K)
Update the new mn = min(A[i + 1], A[0] + 2 * K)
Update the res = min(res, mx - mn)
 */
import java.util.*;

public class SmallestRangeII {
    //凭直觉最优解出现在左半边 +2K，右半边加0, 使用遍历
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int res = A[A.length-1] - A[0];
        int min = A[0], max = A[A.length-1];

        for(int i = 0; i < A.length-1; i++){
            min = Math.min(A[0]+2*K, A[i+1]);
            max = Math.max(max, A[i]+2*K);
            res = Math.min(res, max - min);
        }
        return res;

    }
}
