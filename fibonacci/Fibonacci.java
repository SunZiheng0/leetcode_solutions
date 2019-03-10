package leetcode.fibonacci;
/*
f(0) = 1
f(1) = 1
f(n) = f(n-1) + f(n-2)
 */
public class Fibonacci {
    //normal
    private int fib1(int n){
        if(n == 0) return 1;
        if(n == 1) return 1;
        return fib1(n - 1) + fib1(n - 2);
     }
     //含有大量重复计算

    //good
    private int fib2(int n){
        if(n <= 1) return 1;
        int a = 1;
        int b = 1;
        int c = 0;
        while(n-- >= 2){
            c = b + a;
            a = b;
            b = c;
        }
        return c;
    }
}
