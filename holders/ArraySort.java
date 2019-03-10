package leetcode.holders;

import java.util.*;

public class ArraySort {
    public void sort(int[][] a){
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        Arrays.sort(a, (o1, o2) -> (o1[1] - o2[1]));

        ArrayList<Integer> l1 = new ArrayList<Integer>();
        l1.add(3); l1.add(1); l1.add(2);
        l1.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        l1.sort((o1, o2) -> (o1 - o2));
    }
}
