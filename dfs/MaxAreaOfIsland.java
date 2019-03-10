package leetcode.dfs;
/*
从一个节点出发，使用 DFS 对一个图进行遍历时，能够遍历到的节点都是从初始节点可达的，DFS 常用来求解这种
可达性 问题。

在程序实现 DFS 时需要考虑以下问题：

栈：用栈来保存当前节点信息，当遍历新节点返回时能够继续遍历当前节点。可以使用递归栈。
标记：和 BFS 一样同样需要对已经遍历过的节点进行标记。
查找最大的连通面积

695. Max Area of Island (Easy)

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 */

import java.util.*;

public class MaxAreaOfIsland {
    private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int max = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    int[] pos = new int[]{i, j};
                    max = Math.max(max, dfs(grid, visited, pos));
                }
            }
        return max;

    }
    private int dfs(int[][] grid, boolean[][] visited, int[] pos){
        if(pos[0] < 0 || pos[0] > grid.length-1 || pos[1] < 0 || pos[1] > grid[0].length-1
                || visited[pos[0]][pos[1]] || grid[pos[0]][pos[1]] == 0) return 0;

        int area = 1;
        visited[pos[0]][pos[1]] = true;
        for(int[] direct : directions){
            int[] next = new int[2];
            next[0] = pos[0] + direct[0];
            next[1] = pos[1] + direct[1];
            area += dfs(grid, visited, next);
        }
        return area;
    }
}
