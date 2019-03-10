package leetcode.trie;
/*
720. Longest Word in Dictionary
Easy

Given a list of strings words representing an English Dictionary, find the longest word in
words that can be built one character at a time by other words in words. If there is more
than one possible answer, return the longest word with the smallest lexicographical order.
If there is no answer, return the empty string.

Example 1:

Input:
words = ["w","wo","wor","worl", "world"]
Output: "world"
 */
import java.util.*;

public class LongestWordInDictionary {
    //solution
    public String longestWord(String[] words) {
        if(words.length == 0) return "";
        Arrays.sort(words);
        String result = "";
        Set<String> set = new HashSet<String>();

        for(String w : words){        //已经按 lexicographical 排好， 后面必须比前面长才修改
            //入set标准是，长度1,或者set包含上一个world
            //不能把所有w放到set里，因为所有字符必须从长度1开始
            if(w.length() == 1 || set.contains(w.substring(0, w.length()-1))){
                set.add(w);
                if(w.length() > result.length()) result = w;
            }
        }
        return result;
    }
}
