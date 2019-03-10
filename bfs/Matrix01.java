package leetcode.bfs;
/*
542. 01 Matrix
Medium

Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
The distance between two adjacent cells is 1.
Example 2:
Input:

0 0 0
0 1 0
1 1 1

Output:

0 0 0
0 1 0
1 2 1

 */
import java.util.*;

public class Matrix01 {
    //BFS solution
    public int[][] updateMatrix(int[][] matrix) {
        int[][] distances = new int[matrix.length][matrix[0].length];
        if(matrix.length == 0 || matrix[0].length == 0) return distances;

        Queue<int[]> q = new LinkedList<int[]>();

        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        //System.out.println(matrix.length + " " + matrix[0].length);
        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++){
                //System.out.println(i +" " + j);
                if(matrix[i][j] == 0){
                    distances[i][j] = 0;
                    int[] pos = new int[]{i, j};
                    q.offer(pos);

                }else{
                    distances[i][j] = Integer.MAX_VALUE;
                }
            }

        //for(int[] i : q) System.out.println(i[0] + " " + i[1]);
        while(!q.isEmpty()){
            int[] pos = q.poll();
            int[] next = new int[2];
            for(int[] direct : directions){
                next[0] = pos[0] + direct[0];
                next[1] = pos[1] + direct[1];

                if(next[0] < 0 || next[0] > matrix.length-1 || next[1] < 0 || next[1] > matrix[0].length-1
                        || distances[next[0]][next[1]] <= distances[pos[0]][pos[1]] + 1){
                    //重要的是最后面的判断，新出现的点才加入队列，否则会不停循环，时间原超过n，甚至死循环
                    //一定不能重复加入队列，否则构成环就死循环了
                    //自己尝试换个写法，做成层次遍历
                    //当时漏了+1,表示新结果，不是跟pos比
                    continue;
                }else{
                    distances[next[0]][next[1]] = distances[pos[0]][pos[1]] + 1;
                    //System.out.println(pos[0] +" " + pos[1] + " " + next[0] + " " + next[1]);
                    q.offer(new int[]{next[0], next[1]});
                    //这里才出了莫名其妙的错，其实是不能把next引用传进去，要传值。数组名是个引用，会被后面改变的
                }
                //
            }
        }
        return distances;
    }
}
