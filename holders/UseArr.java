package leetcode.holders;

import java.util.*;

public class UseArr {
    private void arrayAndList(){
        int[] a = new int[]{1,2,3,4};
        List<Integer> l1 = Arrays.asList(1,2,2,3,4);
    }

    private void sortListDemo(){
        ArrayList<Integer> l = new ArrayList<Integer>();
        l.size();
        l.add(3); l.add(2); l.add(1);
        l.toArray();

        Collections.sort(l);
        System.out.println(l);

        int[] nums = new int[]{1,2,3,4};
        int[] nums1 = nums.clone();  //比逐个赋值快
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args){
        UseArr t = new UseArr();
        t.sortListDemo();
        //Set<Integer> set = new HashSet<>();
        //set.add(1);
        //System.out.println(new ArrayList<Integer>(set));
    }
}
