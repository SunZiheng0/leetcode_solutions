package leetcode.holders;

import java.util.*;
public class UsePriorityQueue {
    public static void main(String[] args){
        Queue<Integer> q = new PriorityQueue<Integer>(3);

        q.offer(4);
        q.offer(5);
        q.offer(1);
        q.offer(2);
        q.offer(6);
        while (!q.isEmpty())
            System.out.println(q.poll());

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

    }
}
