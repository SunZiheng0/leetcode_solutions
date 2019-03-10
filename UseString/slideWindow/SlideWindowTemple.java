package leetcode.UseString.slideWindow;
/*
https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007
 /Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.
 */

import java.util.*;

public class SlideWindowTemple {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> reference = new HashMap<>(); //reference map for p
        for(int i=0; i<p.length(); i++)
            reference.put(p.charAt(i), reference.getOrDefault(p.charAt(i),0)+1);

        Map<Character, Integer> map = new HashMap<>(); //map to cache the chars in sliding window
        int start=0, end=0, match=0;
        while(end<s.length())
        {
            char c1 = s.charAt(end);
            if(reference.containsKey(c1))
            {
                map.put(c1, map.getOrDefault(c1,0)+1);
                if(map.get(c1).equals(reference.get(c1))) match++;
            }
            while(match==reference.size())
            {
                if(end-start+1==p.length())
                    ans.add(start);

                char c2 = s.charAt(start);
                if(reference.containsKey(c2))
                {
                    map.put(c2, map.get(c2)-1);
                    if(map.get(c2)<reference.get(c2))   //为了证明begin所在的字符是必须的，
                                                        // 已经到了最短窗口，再移动就不满足了
                        match--;
                }
                start++;
            }
            end++;
        }
        return ans;
    }
}
