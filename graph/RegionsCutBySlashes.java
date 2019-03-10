package leetcode.graph;
/*
959. Regions Cut By Slashes
Medium

In a N x N grid composed of 1 x 1 squares, each 1 x 1 square consists of a /, \, or blank space.  These characters divide the square into contiguous regions.

(Note that backslash characters are escaped, so a \ is represented as "\\".)

Return the number of regions.



Example 1:

Input:
[
  " /",
  "/ "
]
Output: 2
Explanation: The 2x2 grid is as follows:


 */
import java.util.*;

public class RegionsCutBySlashes {
    //solution
    /*
    Split a cell in to 4 parts like this.
    We give it a number top is 1, right is 2, bottom is 3 left is 4.

    Two adjacent parts in different cells are contiguous regions.
    In case '/', top and left are contiguous, botton and right are contiguous.
    In case '\\', top and right are contiguous, bottom and left are contiguous.
    In case ' ', all 4 parts are contiguous.
     */
    int n;
    int count;
    public int regionsBySlashes(String[] grid) {
        n = grid.length;
        if(n == 0) return 0;
        count = n * n * 4;
        int[] id = new int[n * n * 4 + 1]; // index: from 1 to  n * n * 4
        for(int i = 0; i < id.length; i++) id[i] = i;

        for(int i = 0; i < n-1; i++)
            for(int j = 0; j < n; j++)
                union(id, g(i, j, 3), g(i+1, j, 1));

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n-1; j++)
                union(id, g(i, j, 2), g(i, j+1, 4));

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++){
                char c = grid[i].charAt(j);
                switch(c){
                    case ' ' :{union(id, g(i, j, 1), g(i, j, 2));
                        union(id, g(i, j, 2), g(i, j, 3));
                        union(id, g(i, j, 3), g(i, j, 4));
                        break;}
                    case '/' :{union(id, g(i, j, 1), g(i, j, 4));
                        union(id, g(i, j, 2), g(i, j, 3));
                        break;}
                    case '\\':{union(id, g(i, j, 1), g(i, j, 2));
                        union(id, g(i, j, 3), g(i, j, 4));
                        break;}
                    default  : break;
                }
            }
        return count;

    }
    private void union(int[] id, int p, int q){
        int valp = find(id, p);
        int valq = find(id, q);
        if(valp == valq) return;
        else{
            id[valp] = valq;
            count--;
        }
    }

    private int find(int[] id, int i){
        //System.out.println(id.length + " " + i);
        while(id[i] != i) i = id[i];
        return i;
    }

    private int g(int i, int j, int k){
        //int num = (i * n + j) * 4 + k;
        //System.out.println(i + " " + j + " " + k +" " + num);
        return (i * n + j) * 4 + k;
    }
}
