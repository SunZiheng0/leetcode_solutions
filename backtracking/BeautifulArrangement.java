package leetcode.backtracking;
/*
526. Beautiful Arrangement
Medium

Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:

    The number at the ith position is divisible by i.
    i is divisible by the number at the ith position.

 */
import java.util.*;
public class BeautifulArrangement {
    //my solution
    public int myCountArrangement(int N) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<Integer>();
        List<Integer> remain = new ArrayList<Integer>();

        for(int i = 1; i <= N; i++) remain.add(i);

        List<Integer> currRemain = new ArrayList<Integer>(remain); //在for循环中改变remain
        for(int item : currRemain){
            path.add(item);
            remain.remove(Integer.valueOf(item));
            backtrack(result, path, remain);
            path.remove(path.size()-1);
            remain.add(item);
        }
        return result.size();

    }
    private void backtrack(List<List<Integer>> result, List<Integer> path, List<Integer> remain){
        int pos = path.size();
        int num = path.get(path.size()-1);
        if(pos % num != 0 && num % pos != 0) return;
        if(remain.size() == 0){
            result.add(new ArrayList<Integer>(path));
            return;
        }

        List<Integer> currRemain = new ArrayList<Integer>(remain);
        for(int item : currRemain){
            path.add(item);
            remain.remove(Integer.valueOf(item));
            backtrack(result, path, remain);
            path.remove(path.size()-1);
            remain.add(item);
        }
    }


    // solution
    // 这种从1到N无重复取值的题，可以用数组下标标记
    private int count = 0;

    public int countArrangement(int N) {
        if (N == 0) return 0;
        helper(N, 1, new int[N + 1]);
        return count;
    }

    private void helper(int N, int pos, int[] used) {
        if (pos > N) {
            count++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (used[i] == 0 && (i % pos == 0 || pos % i == 0)) {
                used[i] = 1;
                helper(N, pos + 1, used);
                used[i] = 0;
            }
        }
    }

}
