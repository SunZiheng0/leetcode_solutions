package leetcode.backtracking;
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
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if(n == 0) return result;

        dfs(result, "", n, n);
        return result;
    }
    private void dfs(List<String> result, String path, int left, int right){
        if(left > right || left < 0 || right < 0) return; //这种递减的情况，基本情况一定要考虑全面
                                            //除了被result收入外，所有情况都要被返回，否则无限循环
        if(left == 0 && right == 0){                //加入result的条件
            result.add(path);
            return;
        }

        if(left == right){
            dfs(result, path+"(", left-1, right);
        }else{
            dfs(result, path+"(", left-1, right);
            dfs(result, path+")", left, right-1);
        }
    }
}
