package leetcode.UseString;
/*
784. Letter Case Permutation
Easy

Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]

 */
import java.util.*;

public class LowerAndUpper {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<String>();
        String path = "";

        dfs(result, S, path, 0);
        return result;
    }
    private void dfs(List<String> result, String S, String path, int index){
        if(index == S.length()){
            result.add(path);
            return;
        }
        char c = S.charAt(index);
        if(Character.isDigit(c)){
            dfs(result, S, path+c, index+1);
        }else if(Character.isLowerCase(c)){
            dfs(result, S, path+c, index+1);
            char upperC = Character.toUpperCase(c);
            dfs(result, S, path+upperC, index+1);
        }else if(Character.isUpperCase(c)){
            dfs(result, S, path+c, index+1);
            char lowerC = Character.toLowerCase(c);
            dfs(result, S, path+lowerC, index+1);
        }
    }
}
