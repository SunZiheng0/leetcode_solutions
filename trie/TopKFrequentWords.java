package leetcode.trie;
/*
692. Top K Frequent Words
Medium

639

59

Favorite

Share
Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have
the same frequency, then the word with the lower alphabetical order comes first.


 */
import java.util.*;

public class TopKFrequentWords {
    //Map.Entry<String, Integer> 这个类放进 PriorityQueue 可以做到对任意key 的 freq进行排序

    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<String>();
        if(words.length == 0) return result;

        Map<String, Integer> freq = new HashMap<String, Integer>();
        for(String w : words)
            freq.put(w, freq.getOrDefault(w, 0) + 1);

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<Map.Entry<String, Integer>>(
                (a, b) -> ( a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()));

        for(Map.Entry<String, Integer> entry : freq.entrySet()) pq.offer(entry);

        while(k-- > 0){
            result.add(pq.poll().getKey());
        }
        return result;
    }
}
