package leetcode.bfs;
/*
210. Course Schedule II
Medium

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

Example 1:

Input: 2, [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
             course 0. So the correct course order is [0,1] .
 */

import java.util.*;
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return new int[0];
        ArrayList<Integer> tempRes = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] indegrees = new int[numCourses];
        Arrays.fill(indegrees, 0);

        for(int i = 0; i < numCourses; i++) graph.add(new ArrayList<Integer>());
        for(int i = 0; i < prerequisites.length; i++){
            indegrees[prerequisites[i][0]]++;
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++)
            if(indegrees[i] == 0) q.offer(i);

        int count = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            count++;
            tempRes.add(curr);
            for(int next : graph.get(curr)){
                indegrees[next]--;
                if(indegrees[next] == 0) q.offer(next);
            }
        }

        if(count == numCourses){
            int[] result = new int[tempRes.size()];
            for(int i = 0; i < result.length; i++) result[i] = tempRes.get(i);
            return result;
        }else{
            return new int[0];
        }

    }
}
