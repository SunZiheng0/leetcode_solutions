package leetcode.bfs;
/*
207. Course Schedule
Medium

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.
 */
import java.util.*;

public class CourseSchedule {
    //my solution
    //怎么判断一幅图有环？我是用path去遍历，再用contains看是否重复了
    public boolean myCanFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;
        Map<Integer, List<Integer>> preMap = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < prerequisites.length; i++){
            if(!preMap.containsKey(prerequisites[i][0])){
                List<Integer> l = new ArrayList<Integer>();
                l.add(prerequisites[i][1]);
                preMap.put(prerequisites[i][0], l);
            }else{
                preMap.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }
        }
        //System.out.println(preMap);
        int[] memo = new int[numCourses];
        Arrays.fill(memo, 0);
        List<Integer> path = new ArrayList<Integer>();
        boolean result = true;
        for(int i = 0; i < numCourses; i++){
            path.add(i);
            result = result && dfs(numCourses,  preMap, path, memo, i);
            if(!result) return false;
            path.remove(path.size()-1);
        }
        return true;
    }

    private boolean dfs(int numCourses, Map<Integer, List<Integer>> preMap, List<Integer> path, int[] memo, int curr){
        if(!preMap.containsKey(curr)) return true;
        if(memo[curr] != 0) return memo[curr] == 1 ? true : false;

        path.remove(path.size()-1);
        if(path.contains(curr)){
            memo[curr] = 2;
            return false;
        }
        path.add(curr);

        boolean result = true;
        for(int next : preMap.get(curr)){
            path.add(next);
            result = result && dfs(numCourses,  preMap, path, memo, next);
            if(!result){
                memo[curr] = 2;
                return false;
            }
            path.remove(path.size()-1);
        }
        memo[curr] = 1;
        return true;
    }


    //BFS
    //ArrayList[]
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0) return false;
        if(prerequisites.length == 0 || prerequisites[0].length == 0) return true;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] indegrees = new int[numCourses];
        Arrays.fill(indegrees, 0);
        for(int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<Integer>());

        for(int i = 0; i < prerequisites.length; i++){
            indegrees[prerequisites[i][0]]++;
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Queue<Integer> q = new LinkedList<Integer>();  //Queue是抽象类，不能创建对象

        for(int i = 0; i < numCourses; i++)
            if(indegrees[i] == 0) q.offer(i);

        int count = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
                                   //把Object转成ArrayList<Integer>
            for(int next : graph.get(node)){
                indegrees[next]--;
                if(indegrees[next] == 0) q.offer(next);
            }
        }

        return count == numCourses;
    }

}
