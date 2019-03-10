package leetcode.UseString.slideWindow;
/*
76. Minimum Window Substring
Hard

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"

 */

import java.util.*;

public class MinimumWindowSubstring {
    //solution

    public String minWindow(String s, String t) {
        if(s.length() == 0) return "";
        if(s.length() < t.length()) return "";
        int begin = 0, end = 0, head = -1, len = Integer.MAX_VALUE;
        Map<Character, Integer> reference = new HashMap<Character, Integer>();
        for(int i = 0; i < t.length(); i++)
            reference.put(t.charAt(i), reference.getOrDefault(t.charAt(i), 0) + 1);
        //System.out.println(reference.size());
        Map<Character, Integer> window = new HashMap<Character, Integer>();

        int match = 0;
        while(end < s.length()){
            char c = s.charAt(end);
            if(reference.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c).equals(reference.get(c))){ //Integer use equals
                    match++;
                    //System.out.println(match);
                }

            }
            end++;

            while(match == reference.size()){
                char c2 = s.charAt(begin);
                if(reference.containsKey(c2)){
                    window.put(c2, window.get(c2) - 1);
                    if(window.get(c2) < reference.get(c2)) match--;
                }
                if(len > end - begin){  //end++, so len = end - begin
                    len = end - begin;
                    head = begin;
                }
                begin++;
            }
        }

        if(head == -1) return ""; //can't find
        else return s.substring(head, head+len);
    }
}
