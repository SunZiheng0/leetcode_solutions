package leetcode.graph;
/*
802. Find Eventual Safe States
Medium

In a directed graph, we start at some node and every turn, walk along a directed
edge of the graph.  If we reach a node that is terminal (that is, it has no outgoing
 directed edges), we stop.

Now, say our starting node is eventually safe if and only if we must eventually walk
to a terminal node.  More specifically, there exists a natural number K so that for any
choice of where to walk, we must have stopped at a terminal node in less than K steps.

Which nodes are eventually safe?  Return them as an array in sorted order.

The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.
 The graph is given in the following form: graph[i] is a list of labels j such that (i, j)
 is a directed edge of the graph.

Example:
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Here is a diagram of the above graph.


 */
import java.util.*;

public class FindEventualSafeStates {
    //my union find + bfs
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<Integer>();
        int n = graph.length;
        if(n == 0) return result;

        Map<Integer, List<Integer>> preMap = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < n; i++) preMap.put(i, new ArrayList<Integer>());

        for(int i = 0; i < n; i++)
            for(int next : graph[i])
                preMap.get(next).add(i);

        //System.out.println(preMap);

        int[] id = new int[n]; //-1 unvisited, 1 safe, 0 unsafe
        Arrays.fill(id, -1);

        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < n; i++){
            if(graph[i].length == 0){
                result.add(i);
                q.offer(i);
                id[i] = 1;
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int pre : preMap.get(curr)){
                if(id[pre] != -1) continue;
                boolean unsafe = false;
                boolean unkown = false;
                for(int next : graph[pre]){
                    if(id[next] == 0) unsafe = true;
                    if(id[next] == -1) unkown = true;
                }
                if(unsafe){
                    id[pre] = 0;
                }else if(unkown){
                    id[pre] = -1;
                }else{
                    id[pre] = 1;
                    q.offer(pre);
                    result.add(pre);
                }
            }
        }
        result.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        return result;
    }
}
