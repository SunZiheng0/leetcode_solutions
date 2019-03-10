package leetcode.bfs;
/*
417. Pacific Atlantic Water Flow
Medium

Given an m x n matrix of non-negative integers representing the height of each unit
cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix
and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another
one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]
(positions with parentheses in above matrix).

 */
import java.util.*;
public class PacificAtlanticWaterFlow {
    //my solution
    //这道题的问题是不能单纯用左上，右下dp去判断是否能到达
    //因为存在左上、右下不能到达，但另外两个方向可以到达
    //要用bfs，加四个方向去判断对每个点是否能到达

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length == 0) return result;
        int m = matrix.length, n = matrix[0].length;
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> q = new LinkedList<int[]>();

        boolean[][] reachPac = new boolean[m][n];
        for(int i = 0; i < m; i++){
            reachPac[i][0] = true;
            int[] pos = new int[]{i, 0};
            q.offer(pos);
        }
        for(int j = 0; j < n; j++){
            reachPac[0][j] = true;
            int[] pos = new int[]{0, j};
            q.offer(pos);
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dirt : directions){
                int[] next = new int[2];
                next[0] = curr[0] + dirt[0];
                next[1] = curr[1] + dirt[1];
                if(next[0] < 0 || next[0] > m-1 || next[1] < 0 || next[1] > n-1
                        || reachPac[next[0]][next[1]]) continue;
                if(matrix[curr[0]][curr[1]] <= matrix[next[0]][next[1]]){
                    reachPac[next[0]][next[1]] = true;
                    q.offer(next);
                }
            }
        }

        boolean[][] reachAtl = new boolean[m][n];
        for(int i = 0; i < m; i++){
            reachAtl[i][n-1] = true;
            int[] pos = new int[]{i, n-1};
            q.offer(pos);
        }
        for(int j = 0; j < n; j++){
            reachAtl[m-1][j] = true;
            int[] pos = new int[]{m-1, j};
            q.offer(pos);
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();
            for(int[] dirt : directions){
                int[] next = new int[2];
                next[0] = curr[0] + dirt[0];
                next[1] = curr[1] + dirt[1];
                if(next[0] < 0 || next[0] > m-1 || next[1] < 0 || next[1] > n-1
                        || reachAtl[next[0]][next[1]]) continue;
                if(matrix[curr[0]][curr[1]] <= matrix[next[0]][next[1]]){
                    reachAtl[next[0]][next[1]] = true;
                    q.offer(next);
                }
            }
        }

        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(reachPac[i][j] && reachAtl[i][j]){
                    int[] pos = new int[]{i, j};
                    result.add(pos);
                }

        return result;
    }
}
