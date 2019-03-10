package leetcode.greedy;
/*
738. Monotone Increasing Digits
Medium

Given a non-negative integer N, find the largest number that is less than or equal
to N with monotone increasing digits.

(Recall that an integer has monotone increasing digits if and only if each pair of
adjacent digits x and y satisfy x <= y.)

Example 1:

Input: N = 10
Output: 9

 */
public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        if(N < 10) return N;
        char[] chars = String.valueOf(N).toCharArray();

        int mark = chars.length;
        for(int i = chars.length-1; 1 <= i; i--){
            if(chars[i-1] > chars[i]){
                mark = i-1;
                chars[mark]--;    //修改一个，不能保证整个数组递增
            }                     //对修改后的也要去遍历
        }

        if(mark == chars.length) return N;

        for(int i = mark+1; i < chars.length; i++)
            chars[i] = '9';

        return Integer.parseInt(new String(chars));

    }
    public static void main(String[] args){
        MonotoneIncreasingDigits t = new MonotoneIncreasingDigits();
        int result = t.monotoneIncreasingDigits(34252);
        System.out.println(result);
    }
}
