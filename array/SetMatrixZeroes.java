package leetcode.array;
/*
73. Set Matrix Zeroes
Medium

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input:
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output:
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]

 */
public class SetMatrixZeroes {
    //用自己的边路进行标记，再最后处理边路
    public void setZeroes(int[][] matrix) {

        boolean col0 = false;
        for(int i = 0; i < matrix.length; i++)
            if(matrix[i][0] == 0) col0 = true;

        boolean row0 = false;
        for(int j = 0; j < matrix[0].length; j++)
            if(matrix[0][j] == 0) row0 = true;

        for(int i = 1; i < matrix.length; i++)
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }

        for(int i = 1; i < matrix.length; i++)
            if(matrix[i][0] == 0)
                for(int j = 1; j < matrix[0].length; j++)
                    matrix[i][j] = 0;

        for(int j = 1; j < matrix[0].length; j++)
            if(matrix[0][j] == 0)
                for(int i = 1; i < matrix.length; i++)
                    matrix[i][j] = 0;

        if(col0)
            for(int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;

        if(row0)
            for(int j = 0; j < matrix[0].length; j++)
                matrix[0][j] = 0;
    }
}
