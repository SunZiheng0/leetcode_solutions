package leetcode.graph.unionFind;
/*
684. Redundant Connection
Medium

538

180

Favorite

Share
In this problem, a tree is an undirected graph that is connected and has no cycles.

The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.

Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.

Example 1:
Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given undirected graph will be like this:
  1
 / \
2 - 3
 */
import java.util.*;
public class RedundantConnection {
    // my solution 1
    public int[] findRedundantConnection1(int[][] edges) {
        int[] id = new int[edges.length+1];
        for(int i = 0; i < id.length; i++) id[i] = i;
        int[] result = new int[2];

        for(int i = 0; i < edges.length; i++){
            if(connected1(id, edges[i][0], edges[i][1])){
                result = edges[i];
                //System.out.println(result);
            }
            else{
                union1(id, edges[i][0], edges[i][1]);
            }

        }
        return result;
    }

    private boolean connected1(int[] id, int p, int q){
        return id[p] == id[q];
    }

    private void union1(int[] id, int p, int q){
        if(connected1(id, p, q)) return;
        int valp = id[p], valq = id[q];  //这里有个问题，是刚开始的时候，两个集的标识valp，valq必须保存下来
                                         //不能直接用id[p], id[q]
                                         //因为在后续过程中，id[q], id[p]作为数组引用，是会改变的
        for(int i = 0; i < id.length; i++){
            if(id[i] == valp){
                //System.out.println(i + " " + id[i]);
                id[i] = valq;
            }
        }
    }


    //采用数树的结构， id[i] 表示 i 点的parent，
    // id[i] == i, 则是root, 表示集合标志
    public int[] findRedundantConnection2(int[][] edges) {
        int[] id = new int[edges.length+1];
        for(int i = 0; i < id.length; i++) id[i] = i;
        int[] result = new int[2];

        for(int i = 0; i < edges.length; i++){
            if(connected(id, edges[i][0], edges[i][1])){
                result = edges[i];
            }
            else{
                union(id, edges[i][0], edges[i][1]);
            }

        }
        return result;
    }

    private boolean connected(int[] id, int p, int q){
        while(id[p] != p) p = id[p];
        while(id[q] != q) q = id[q];
        return p == q;
    }

    private void union(int[] id, int p, int q){
        while(id[p] != p) p = id[p];
        while(id[q] != q) q = id[q];
        if(p == q) return;
        id[p] = q;   //p： parent -> q
    }
}
