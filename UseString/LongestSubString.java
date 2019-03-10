package leetcode.UseString;
/*
3. Longest Substring Without Repeating Characters
Medium

Given a string, find the length of the longest substring without repeating characters.
https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
import java.util.*;

public class LongestSubString {
    //my solution
    //分治，问题的子问题是，包含末尾的字符 maxSubString， 再递增到整个数组
    public int myLengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        Queue<Character> q = new LinkedList<Character>();
        int max = 1;
        char[] chars = s.toCharArray();
        q.add(chars[0]);
        for(int i = 1; i < chars.length; i++){
            while(q.contains(chars[i])) q.poll();
            q.add(chars[i]);
            max = Math.max(q.size(), max);
        }
        return max;
    }

    //most upvoted solution
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }

}
