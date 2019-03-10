package leetcode.bfs;
/*
127. Word Ladder
Medium

Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

    Only one letter can be changed at a time.
    Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

Note:

    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
    You may assume no duplicates in the word list.
    You may assume beginWord and endWord are non-empty and are not the same.

Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5
 */
import java.util.*;

public class WordLadders {
    //solution bfs
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        Set<String> reached = new HashSet<String>();
        reached.add(beginWord);
        wordDict.add(endWord);
        int distance = 1;
        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<String>();
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if (wordDict.contains(word)) {
                            toAdd.add(word);
                            wordDict.remove(word);
                        }
                    }
                }
            }
            distance++;
            if (toAdd.size() == 0) return 0;
            reached = toAdd;
        }
        return distance;
    }


    //my solution
    public int myLadderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.length() != endWord.length() || beginWord.length() == 0
                || wordList.size() == 0 || !wordList.contains(endWord)) return 0;

        int n = beginWord.length();
        List<List<String>> subWordList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            subWordList.add(new ArrayList<String>());
            for(String word : wordList){
                String subWord = word.substring(0, i) + word.substring(i+1, n);
                subWordList.get(i).add(subWord);
            }
        }
        //System.out.println(subWordList);

        Set<String> visited = new HashSet<String>();
        int step = 1;
        Queue<String> q = new LinkedList<String>();
        q.offer(beginWord);
        while(!q.isEmpty()){
            //System.out.println(q);
            int size = q.size();
            while(size-- > 0){
                String curr = q.poll();
                if(curr.equals(endWord)) return step;
                if(visited.contains(curr)) continue;
                visited.add(curr);

                for(int i = 0; i < n; i++){
                    String subcurr = curr.substring(0, i) + curr.substring(i+1, n);
                    List<String> subWords = subWordList.get(i);
                    //if(subWordList.get(i).contains(subcurr))
                    //    q.offer(wordList.get(subWordList.get(i).indexOf(subcurr)));
                    //这个写法有严重问题：当多个可能性的时候，只返回第一个index
                    if(subWords.contains(subcurr)){
                        for(int index = 0; index < subWords.size(); index++){
                            if(subWords.get(index).equals(subcurr))
                                q.offer(wordList.get(index));
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }
    public static void main(String[] args){
        WordLadders t = new WordLadders();
        //"hit"
        //"cog"
        // ["hot","dot","dog","lot","log","cog"]
        String beginWord = "hit";
        String endWord = "cog";
        String[] words = new String[]{"hot","dot","dog","lot","log","cog"};
        List<String> wordList = new ArrayList<String>(Arrays.asList(words));

        int result = t.myLadderLength(beginWord, endWord, wordList);
        System.out.println(result);
    }
}
