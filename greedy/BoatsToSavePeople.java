package leetcode.greedy;
/*
881. Boats to Save People
Medium

The i-th person has weight people[i], and each boat can carry a maximum weight of limit.

Each boat carries at most 2 people at the same time, provided the sum of the weight of
those people is at most limit.

Return the minimum number of boats to carry every given person.  (It is guaranteed each
person can be carried by a boat.)
 */

import java.util.*;
/*
greedy 的证明是，可能有多种方法，但greedy是最优解中的一个（不唯一）
1. Greedy choice property.

Starting from the heaviest person hi, there are 2 possible cases:
a) if hi can NOT fit in a boat with any other, then both in S and O, hi is in a boat alone.
Apparently, our first step is optimal and the greedy choice property holds;
b) if hi CAN fit in a boat with at least 1 other person, then
in O, hi and lightest person lo together must be in same boat, according to our algorithm.

In S, if they are also in same boat, then our first step is optimal and the greedy choice
property holds;
If hi and lo are not in same boat, say in boat-hi and boat-lo respectively, then we can swap
hi with lo's boat mate, say m. Obviously, m <= hi, therefore the swap is feasible. Since the
swap results no extra boat(s), a new optimal solution T is obtained. That indicates our first
step--put hi and lo into same boat--is an optimal step and and greedy choice property also holds.

2.optimal substructure property.

Let P be the original problem at scale n, where n = people.length. From the above 1, after
first step, we have a subproblem P' at scale n'(n' = n - 1 or n - 2, depends on hi in a
boat alone or not). Similary, we have hi' and lo' and can do next step as in 1.

Since in 1 we proved T is an optimal solution, and the solution of P', say O', contained
within T is also an optimal one. Thus the the problem has the optimal substructure property.

Combine 1 and 2, we complete the proof.

end of proof.
 */
/*
Each boat carries at most 2 people at the same time,
provided the sum of the weight of those people is at most limit.
 */
public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int count = 0, lo = 0, hi = people.length-1;
        while(lo <= hi){
            int boat = limit - people[hi--];
            if(lo <= hi && people[lo] <= boat) lo++;
            count++;
        }
        return count;
    }
    public static void main(String[] args){
        BoatsToSavePeople t = new BoatsToSavePeople();
        int[] people = new int[]{3,3,2,2,2};
        int limit = 6;
        int result = t.numRescueBoats(people, limit);
        System.out.println(result);
    }
}
