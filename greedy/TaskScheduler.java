package leetcode.greedy;
/*
621. Task Scheduler
Medium

Given a char array representing tasks CPU need to do. It contains capital letters
A to Z where different letters represent different tasks. Tasks could be done without
original order. Each task could be done in one interval. For each interval, CPU could
finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks,
there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.
 */

import java.util.*;
public class TaskScheduler {
    //这种题统一用PriorityQueue
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        for(int i = 0; i < tasks.length; i++)
            freq.put(tasks[i], freq.getOrDefault(tasks[i], 0) + 1);

        //这种每一轮循环前都要排序取最值的问题，用优先队列去出去
        //默认q.poll() 弹出最小，要在创建时候输入 Comparator
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> (b - a));
        //这个要自己调整，默认从小到大，别忘记
        for(Character key : freq.keySet()) pq.add(freq.get(key));

        int cycle = n + 1;
        List<Integer> l = new ArrayList<Integer>();
        int workTime = 0;
        int total = 0;

        while(!pq.isEmpty()){
            workTime = 0;
            l.clear();            //每次开始前清空l
            for(int i = 0; i < cycle; i++){
                if(!pq.isEmpty()){
                    l.add(pq.poll());
                    workTime++;
                }
            }
            for(int i = 0; i < l.size(); i++){
                int cnt = l.get(i);
                if(cnt > 1) pq.offer(cnt-1);
            }
            if(pq.isEmpty()) total += workTime;
            else total += cycle;
        }
        return total;
    }
}
