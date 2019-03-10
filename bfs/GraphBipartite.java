package leetcode.bfs;
/*
785. Is Graph Bipartite?
Medium

Given an undirected graph, return true if and only if it is bipartite.

Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.

The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.

Example 1:
Input: [[1,3], [0,2], [1,3], [0,2]]
Output: true
Explanation:
The graph looks like this:
0----1
|    |
|    |
3----2
We can divide the vertices into two groups: {0, 2} and {1, 3}.

 */
import java.util.*;

public class GraphBipartite {

    //solution bfs
    public boolean isBipartite(int[][] graph) {
        if(graph.length == 0) return false; //这是图，graph[0]是0顶点连接的边，跟matrix[0] == 0不一样
                                            // 没有值只是说明0点是孤立的点而已，

        int[] color = new int[graph.length];
        Queue<Integer> q = new LinkedList<Integer>();

        for(int i = 0; i < graph.length; i++){
            if(color[i] == 0){
                q.offer(i);
                color[i] = 1;

                while(!q.isEmpty()){
                    int curr = q.poll();
                    for(int next : graph[curr]){
                        if(color[next] == 0){
                            color[next] = -color[curr];
                            q.offer(next);
                        }else{
                            //System.out.println(next + " " + curr);
                            if(color[next] != -color[curr]) return false;
                        }
                    }
                }
            }
        }
        return true;

    }

}
