package leetcode.holders;
import java.util.*;

public class UseMap {
    public void test(){
        HashMap<Character, Integer> m1 = new HashMap<Character, Integer>();
        m1.put('a', 1);
        HashMap<Character, Integer> m2 = new HashMap<Character, Integer>();
        m2.put('b', 1);
        m1.remove('a');
        //System.out.println(m1.get('a') == m2.get('b')); //Integer use equals no ==
        //System.out.println(m1.get('a').equals(m2.get('b')));

        Map<Integer, Character> m = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Map<Integer, Character> m3 = new TreeMap<>((a, b) -> b-a);
        m.put(3, 'a');
        m.put(2, 'b');
        m.put(1, 'c');
        m.values();
        for(int key : m.keySet()){
            System.out.println(key);
        }
        m.remove(3);
        m.put(0, 'x');
        for(int key : m.keySet()){
            System.out.println(key);
        }

    }

    private void useTreeMap(){
        Map<Integer, Integer> m = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        Map<Integer, Integer> m2 = new TreeMap<Integer, Integer>((a, b) -> (b - a));
        m.put(3,1);
        m.put(4,1);
        m.put(5,1);
        m.put(2,1);
        m.put(1,1);
        System.out.println(m);
    }

    private void mapEntry(){
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};

        Map<String, Integer> freq = new HashMap<String, Integer>();
        for(String w : words)
            freq.put(w, freq.getOrDefault(w, 0) + 1);

        for(Map.Entry<String, Integer> entry: freq.entrySet()){
            System.out.println(entry);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
        );

    }

    public static void main(String[] args){
        UseMap t = new UseMap();
        //t.test();
        //t.useTreeMap();
        t.mapEntry();
    }
}
