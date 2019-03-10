package leetcode.holders;
import java.util.*;

public class UseList {
    public void test(){
        /*
        ArrayList<Integer> l2 = new ArrayList<Integer>();
        l1.add(1); l2.add(1);
        System.out.println(l1.equals(l2));
        //Integer[] arr1 = l1.toArray();
        //得到Object[]  还不如用for赋值
        l1.add(2);
        System.out.println(l1);
        //l1.remove(2); //index
        l1.remove(Integer.valueOf(2)); // object
        System.out.println(l1);
        ArrayList<int[]> l3 = new ArrayList<>();
        l3.add(new int[]{1,2,3});
        l1.clear();
        //int[] result = new int[]{1,1,1};
        //l1.toArray(result);
        l1.indexOf(3);
        l1.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        //copy:
        List<Integer> l4 = new ArrayList<Integer>(l1);

        l1.add(2);l1.add(3);
        System.out.println(l1.size());
        l1.add(2, 4);
        System.out.println(l1);
        l1.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        //index of
        l1.indexOf(1); //第一个
        l1.lastIndexOf(1); // 最后一个
        */
        Integer[] a = new Integer[]{3,4,5,6,1,2};
        List<Integer> l3 = new ArrayList<Integer>();
        l3 = Arrays.asList(a);

    }
    public static void main(String[] args){
        UseList t = new UseList();
        t.test();


    }
}
