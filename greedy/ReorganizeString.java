package leetcode.greedy;
/*
767. Reorganize String
Medium

Given a string S, check if the letters can be rearranged so that two characters
that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"

 */
import java.util.*;

public class ReorganizeString {
    //solution
    //用 PriorityQueue<int[]> 可以实现这种间隔问题，第一位是标记，第二位记录频率，在PriorityQueue中
    // 每次都排序
    //TreeMap，要remove

    public String reorganizeString(String S) {
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        for(int i = 0; i < S.length(); i++)
            freq.put(S.charAt(i), freq.getOrDefault(S.charAt(i), 0) + 1);

        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> (b[1] - a[1]));
        for(char c : freq.keySet()){
            int[] curr = new int[]{c, freq.get(c)};
            q.offer(curr);
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int[] first = q.poll();
            if(sb.length() == 0 || sb.charAt(sb.length()-1) != first[0]){
                sb.append((char)first[0]);
                if(first[1] > 1){
                    first[1]--;
                    q.offer(first);
                }
            }else{
                if(q.isEmpty()) return "";
                int[] second = q.poll();
                sb.append((char)second[0]);
                if(second[1] > 1){
                    second[1]--;
                    q.offer(second);
                }
                q.offer(first);  //取2放进string builder 后，记得把刚才取出来的1放回去
            }
        }
        return sb.toString();
    }
}
