package leetcode.array;
/*
670. Maximum Swap
Medium

Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.

Example 1:

Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.

 */
import java.util.*;
public class MaximumSwap {
    public int maximumSwap(int num) {
        List<Integer> l1 = new ArrayList<Integer>();
        int curr = num;
        while(curr > 0){
            l1.add(0, curr % 10);
            curr /= 10;
        }
        List<Integer> l2 = new ArrayList<Integer>(l1);
        l2.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int i = 0; i < l1.size(); i++){
            if(l1.get(i) != l2.get(i)){
                int t = l1.get(i);

                int index = l1.lastIndexOf(l2.get(i)); //用indexOf返回第一个值
                                                       //用indexOf注意考虑重复情况
                l1.set(i, l2.get(i));
                l1.set(index, t);
                return getNum(l1);
            }
        }
        return num;     //注意num有没有被改动
    }
    private int getNum(List<Integer> l){
        int num = 0;
        for(int i : l){
            num = num * 10 + i;
        }
        return num;
    }
}
