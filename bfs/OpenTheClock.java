package leetcode.bfs;
/*
752. Open the Lock
Medium

You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2',
'3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we
can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes,
the wheels of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, return the minimum
total number of turns required to open the lock, or -1 if it is impossible.

Example 1:

Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
Explanation:
A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202"
-> "0202".
Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102"
 */
import java.util.*;
public class OpenTheClock {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet<String>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<String>();

        Queue<String> q = new LinkedList<String>();
        int step = 0;

        q.offer("0000");
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                String curr = q.poll();
                System.out.println(curr);
                System.out.println(deadendSet.contains(curr));
                if(deadendSet.contains(curr)) continue; //必须先判断，处理，再遍历，入队，跟dfs一样
                                                        //否则第一个会被忽略
                if(visited.contains(curr)) continue;       //这里也有visited的概念，被visited的，要做标记。
                visited.add(curr);
                if(curr.equals(target)) return step;
                for(int i = 0; i < 4; i++){
                    char c = curr.charAt(i);
                    String next = curr.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + curr.substring(i+1, 4);
                    q.offer(next);
                    next = curr.substring(0, i) + (c == '0' ? 9 : c - '0' - 1) + curr.substring(i+1, 4);
                    q.offer(next);
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args){
        OpenTheClock t = new OpenTheClock();
        //["0201","0101","0102","1212","2002"]
        //"0202"
        String[] deadends = new String[]{"0201","0101","0102","1212","2002"};
        String target = "0202";
        t.openLock(deadends, target);
    }
}
