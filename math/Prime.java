package leetcode.math;
/*
204. Count Primes
Easy

902

362

Favorite

Share
Count the number of prime numbers less than a non-negative number, n.
 */
public class Prime {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n+1];
        int count = 0;
        for(int i = 2; i < n; i++){
            if(notPrime[i]) continue;
            count++;
            // 从 2*i, 3 * i , ... , k * i < n 因为k < i 的已经被处理了， 所以从 i * i 起
            for(long j = (long)i * i; j < n; j += i){
                notPrime[(int)j] = true;
            }
        }
        return count;
    }

    int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }

    int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

}
