package leetcode.KthProblem;

import java.util.*;

public class UsePriorityQueue {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<Integer>(k);
        //虽然可以预先设置大小，但会随着需要自动增加capacity，并不固定
        //要手动维护其固定大小。
        for(int i = 0; i < nums.length; i++){
            q.offer(nums[i]);
            if(q.size() > k) q.poll(); //默认弹出最小值
        }
        return q.poll();
    }

    public int findKthSmallest(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int i = 0; i < nums.length; i++){
            q.offer(nums[i]);
            if(q.size() > k) q.poll();
        }
        return q.poll();

    }
}
