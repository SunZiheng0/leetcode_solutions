package leetcode.holders;
import java.util.*;
/*
771. Jewels and Stones
 */
//Set 用 HashSet
//初始化用 循环+add

public class UseSet {
    private void pastTest(){
        Set<Character> set = new HashSet<Character>();
        set.clear();
        set.add('a');
        set.contains('a');
        set.remove('a');
        set.size();
        String s = "abcde";
        char[] chars = s.toCharArray();

        Set<Integer> set1 = new TreeSet<>();
    }

    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<Character>();
        for(char c : J.toCharArray()) set.add(c);
        int count = 0;
        for(char c : S.toCharArray())
            if(set.contains(c)) count++;
        return count;
    }

    public void test(){
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(1);
        l1.add(2);

        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(2);
        l2.add(1);

        Set<List<Integer>> result = new HashSet<List<Integer>>();
        result.add(l1);
        result.add(l2);

        for(List<Integer> l : result){
            System.out.println(l);
        }
        //return set to arrayList
        new ArrayList<List<Integer>>(result);

    }
    public static void main(String[] args){
        UseSet t = new UseSet();
        t.test();
    }
}
