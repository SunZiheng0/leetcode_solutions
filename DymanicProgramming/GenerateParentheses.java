package leetcode.DymanicProgramming;
/*
22. Generate Parentheses
Medium

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

 */
import java.util.*;

public class GenerateParentheses {
    public List<String> myGenerateParenthesis(int n) {
        if(n == 0) return new ArrayList<String>();
        ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> before = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> l = new ArrayList<Integer>();
        ArrayList<Integer> newl = new ArrayList<Integer>();
        l.add(0); l.add(1);
        temp.add(l);

        while(--n > 0){

            before = new ArrayList<ArrayList<Integer>>(); //典型错误，before = temp
                                                          //要用一个新的ArrayList，否则只是在引用旧值
                                                          //后面被清空
            before.addAll(temp);
            temp.clear();
            for(int i = 0; i < before.size(); i++){
                l = before.get(i);
                newl = new ArrayList<Integer>();
                newl.addAll(l);
                newl.add(0, 0);
                newl.add(1);
                temp.add(newl);
            }
            for(int i = 0; i < before.size(); i++){
                l = before.get(i);
                newl = new ArrayList<Integer>();
                newl.addAll(l);
                newl.add(0);
                newl.add(1);
                temp.add(newl);

                if(i != before.size()-1){
                    newl = new ArrayList<Integer>();
                    newl.addAll(l);
                    newl.add(0, 0);
                    newl.add(1, 1);
                    temp.add(newl);
                }
            }

            System.out.println(temp);
            System.out.println();
        }

        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        for(ArrayList<Integer> nums : temp){
            sb = new StringBuilder();
            for(Integer num : nums)
                if(num == 0) sb.append('(');
                else sb.append(')');
            result.add(sb.toString());
        }
        return result;
    }

    //the solutions1 backtrack
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        helper(result, n, n, "");
        return result;
    }
    private void helper(List<String> result, int left, int right, String s){
        if(right < left) return;
        if(left == 0 && right == 0){
            result.add(s);
            return;
        }
        if(0 < left) helper(result, left-1, right, s+"(");
        if(0 <right) helper(result, left, right-1, s+")");
    }

}
