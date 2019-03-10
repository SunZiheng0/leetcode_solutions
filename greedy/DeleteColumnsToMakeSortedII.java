package leetcode.greedy;
/*
955. Delete Columns to Make Sorted II
Medium

93

15

Favorite

Share
We are given an array A of N lowercase letter strings, all of the same length.

Now, we may choose any set of deletion indices, and for each string, we delete all
the characters in those indices.

For example, if we have an array A = ["abcdef","uvwxyz"] and deletion indices {0, 2, 3},
then the final array after deletions is ["bef","vyz"].

Suppose we chose a set of deletion indices D such that after deletions, the final array
has its elements in lexicographic order (A[0] <= A[1] <= A[2] ... <= A[A.length - 1]).

Return the minimum possible value of D.length.
 */
/*
Explanation
Initial a boolean array sorted,
sorted[i] = true if and only if A[i] < A[i + 1],
that is to say A[i] and A[i + 1] are sorted.

For each col, we check all unsorted rows.
If A[i][j] > A[i + 1][j], we need to deleted this col, res++.

Otherwise, we can keep this col, and update all sorted rows.

 */

public class DeleteColumnsToMakeSortedII {
    //solution
    public int minDeletionSize(String[] A) {
        if(A.length == 0 || A[0].length() == 0) return 0;
        boolean[] sorted = new boolean[A.length-1];  //true when A[i] <= A[i+1]

        int count = 0;

        for(int j = 0; j < A[0].length(); j++){
            boolean delete = false;
            for(int i = 0; i < A.length-1; i++){
                if(!sorted[i] && A[i].charAt(j) > A[i+1].charAt(j)){
                    delete = true;
                    count++;
                    break;
                }
            }
            if(!delete){              //不被delete的项，才能用于sorted
                for(int i = 0; i < A.length-1; i++)
                    if(!sorted[i] && A[i].charAt(j) < A[i+1].charAt(j))
                        sorted[i] = true;
            }
        }
        return count;
    }

    //wrong answer
    public int minDeletionSize2(String[] A) {
        if(A.length == 0 || A[0].length() == 0) return 0;
        boolean[] sorted = new boolean[A.length-1];  //true when A[i] <= A[i+1]

        int count = 0;

        for(int j = 0; j < A[0].length(); j++){
            for(int i = 0; i < A.length-1; i++){
                if(!sorted[i] && A[i].charAt(j) > A[i+1].charAt(j)){
                    count++;
                    break;
                }
                if((!sorted[i] && A[i].charAt(j) < A[i+1].charAt(j))){ //不能写在一起
                    sorted[i] = true;                  //如果前面被sorted， 后面被delete，就出错了
                }                                      //delete完了再sorted
            }
        }
        return count;
    }
}

