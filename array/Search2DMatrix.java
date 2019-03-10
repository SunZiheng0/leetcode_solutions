package leetcode.array;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        //int m = matrix.length, n = matrix[0].length; //如果写在这里，matrix[0]可能数组越界
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = n-1;
        while(i < m && 0 <= j){
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] < target) i++;
            else j--;
        }
        return false;
    }
}
