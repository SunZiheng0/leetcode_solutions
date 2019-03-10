package leetcode.BasicJava;
import java.util.*;

public class Sort {
    public void sort1(int[][] nums) {
        Arrays.sort(nums, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
    }

    public void sort2(int[][] nums) {
        Arrays.sort(nums, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (b[0] == a[0]) return a[1] - b[1];
                return b[0] - a[0];
            }
        });
    }

    public static void main(String[] args){
        Sort t = new Sort();

    }

}
