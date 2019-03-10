package leetcode.DymanicProgramming;
/*
264. Ugly Number II
Medium

Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 */
import java.util.*;

public class UglyNumber {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> q = new PriorityQueue();  //遇到特别大的数， 用Long
        q.offer(1l);
        long num = 0;
        while(n-- > 0){
            num = q.poll();
            while(!q.isEmpty() && q.peek() == num) q.poll();
            q.offer(num * 2l);
            q.offer(num * 3l);
            q.offer(num * 5l);
        }
        return (int) num;
    }
}
