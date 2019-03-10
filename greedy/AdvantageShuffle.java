package leetcode.greedy;

import java.util.*;

public class AdvantageShuffle {
    //solution
    //A and B sorted, 不用每次都遍历数组，从O(n**2) -> O(n*lgn)
    // PriorityQueue<int[]> 做到了对字典排序
    //重复的键不能用TreeMap
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (b[0] - a[0]));
        for(int i = 0; i < B.length; i++){
            int[] curr = new int[]{B[i], i};
            pq.offer(curr);
        }

        int lo = 0, hi = A.length-1;
        int[] result = new int[A.length];
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(A[hi] > curr[0]){
                result[curr[1]] = A[hi--];
            }else{
                result[curr[1]] = A[lo++];
            }
        }
        return result;
    }

    //treeMap wrong answer
    //[2,0,4,1,2]
    //[1,3,0,0,2] key 有重复值，不能用tree， 会被替代
    public int[] advantageCount1(int[] A, int[] B) {
        Arrays.sort(A);
        Map<Integer, Integer> tm = new TreeMap<Integer, Integer>((a, b) -> (b - a));
        for(int i = 0; i < B.length; i++) tm.put(B[i], i);
        int lo = 0, hi = A.length-1;
        int[] result = new int[A.length];

        for(int key : tm.keySet()){
            System.out.println(key);
            int index = tm.get(key);
            if(A[hi] > key){
                result[index] = A[hi--];
            }else{
                result[index] = A[lo++];
            }
        }
        return result;
    }

    // time limit exceeded
    public int[] advantageCount2(int[] A, int[] B) {
        if(A.length == 0) return new int[0];
        List<Integer> la = new LinkedList<Integer>();
        for(int i = 0; i < A.length; i++) la.add(A[i]);
        la.sort((o1, o2) -> (o1 - o2));

        int[] result = new int[A.length];
        for(int i = 0; i < B.length; i++){
            int j = 0;
            if(B[i] >= la.get(la.size()-1)){
                result[i] = la.get(0);
                la.remove(0);
            }else{
                while(j < la.size()-1 && la.get(j) <= B[i]) j++;
                result[i] = la.get(j);
                la.remove(j);
            }
        }
        return result;
    }
}
