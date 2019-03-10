package leetcode;
import java.util.*;

public class DFS {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);
        dfsSearch(graph, 0, res, path);

        return res;
    }

    //dfs add the next node to path;
    //if reach target add a new array to result
    private void dfsSearch(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
        System.out.println("entrance dfs " + node + ":" + path);
        if (node == graph.length - 1) {
            res.add(new ArrayList<Integer>(path));
            //res.add(path);
            //System.out.println(res);
            return;
        }

        //path in current node before every loop
        for (int nextNode : graph[node]) {
            path.add(nextNode);
            System.out.println("after add " + node + " : " + path);
            dfsSearch(graph, nextNode, res, path);
            System.out.println("before remove " + node + " : " + path);
            path.remove(path.size() - 1);
            System.out.println("after remove " + node + " : " + path);
        }
    }

    public static void main(String[] args){
        int[][] graph = {{1,2}, {3}, {3}, {}};
        DFS dfs = new DFS();
        System.out.println(dfs.allPathsSourceTarget(graph));
    }
}
