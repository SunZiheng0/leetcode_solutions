package leetcode.UseString;
/*
14. Longest Common Prefix
Easy

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string ""
 */
public class LongestCommonSubString {
    public void test(){
        String s = "abcdefghcde";
        String t = "cde";
        System.out.println(s.indexOf("z"));
        System.out.println(s.lastIndexOf(t));
        System.out.println(s.substring(0,s.length()-1));
    }

    //solution prefix 前缀
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)    return "";
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0){
                pre = pre.substring(0,pre.length()-1);
                if(pre.length() == 0) return "";
            }

            i++;
        }
        return pre;
    }

    public static void main(String[] args){
        LongestCommonSubString l = new LongestCommonSubString();
        l.test();
    }
}
