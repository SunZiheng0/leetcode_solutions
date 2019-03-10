package leetcode.Tree;
/*
310. Minimum Height Trees
Medium

For an undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1 :

Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3

Output: [1]

 */
import java.util.*;
public class MinHeightTree {
    //solution
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(n == 0) return result; //没有顶点
        if(n == 1){              //没有边
            result.add(0);
            return result;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) graph.add(new ArrayList<Integer>());
        int[] indegrees = new int[n];
        for(int i = 0; i < edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            indegrees[edges[i][1]]++;
            graph.get(edges[i][1]).add(edges[i][0]);
            indegrees[edges[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < n; i++) if(indegrees[i] == 1) q.offer(i);

        int count = 0;
        while(!q.isEmpty()){
            if(count == n-1 || count == n-2){  //只有一条边的情况，所以提前检验
                result.addAll(q);
                break;
            }
            int size = q.size();
            while(size-- > 0){
                int curr = q.poll();
                count++;
                for(int next : graph.get(curr)){
                    indegrees[next]--;
                    if(indegrees[next] == 1) q.offer(next);
                }
            }


        }
        return result;

    }

}
