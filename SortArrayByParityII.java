package leetcode;
/*
922. Sort Array By Parity II
Easy

Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.

Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.

You may return any answer array that satisfies this condition.



Example 1:

Input: [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.



Note:

    2 <= A.length <= 20000
    A.length % 2 == 0
    0 <= A[i] <= 1000

https://leetcode.com/problems/sort-array-by-parity-ii/
 */
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        if(A.length <= 1) return A;
        int evenp = 0, oddp = 1;
        int t;
        //双指针移动前要先分别判断是否越界，写在内部
        while(true){
            //这个写法很重要，因为在循环里面自增，所以要先判越界，在判查询条件
            while(evenp < A.length && A[evenp] % 2 == 0) evenp += 2;
            while(oddp < A.length && A[oddp] % 2 != 0) oddp += 2;
            //离开循环条件有两种：越界，不符合循环条件，要分开处理;
            if(evenp < A.length && oddp < A.length){
                t = A[evenp];
                A[evenp] = A[oddp];
                A[oddp] = t;
            }else{
                break; //主循环用while（true），一定要设置break
            }
        }
        return A;
    }
}
