package leetcode.graph.unionFind;
/*
947. Most Stones Removed with Same Row or Column
Medium

On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.

Now, a move consists of removing a stone that shares a column or row with another stone on the grid.

What is the largest possible number of moves we can make?



Example 1:

Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
Output: 5

 */
public class MostStonesRemoved {
    //my dfs solution
    public int removeStones1(int[][] stones) {
        if(stones.length == 0) return 0;
        int island = 0;
        boolean[] visited = new boolean[stones.length];
        for(int i = 0; i < stones.length; i++){
            if(!visited[i]){
                //System.out.println(i);
                dfs(stones, visited, i);
                island++;
            }
        }
        return stones.length - island;
    }

    private void dfs(int[][] stones, boolean[] visited, int i){

        visited[i] = true;
        for(int j = 0; j < stones.length; j++){  //要从0开始找，要不后面的发现不了前面的。用visited防止重复
            if(!visited[j] && (stones[j][0] == stones[i][0] || stones[j][1] == stones[i][1]))
                dfs(stones, visited, j);
        }
    }

    // my union find
    int count;
    public int removeStones(int[][] stones) {
        if(stones.length == 0) return 0;
        int[] id = new int[stones.length];
        for(int i = 0; i < id.length; i++) id[i] = i;
        count = stones.length;

        for(int i = 0; i < stones.length; i++)
            for(int j = 0; j < stones.length; j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    if(connected(id, i, j)) continue;
                    else union(id, i, j);
                }
            }
        return stones.length - count;
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
        else{
            id[p] = q;
            count--;
        }
    }
}
