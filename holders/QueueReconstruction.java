package leetcode.holders;
/*
406. Queue Reconstruction by Height
Medium

Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]


 */
import java.util.*;

public class QueueReconstruction {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) return o2[0] - o1[0];
                else return o1[1] - o2[1];
            }
        });
        //for(int i = 0; i < people.length; i++)
        //    System.out.println(Arrays.toString(people[i]));
        //System.out.println();
        ArrayList<int[]> temp = new ArrayList<int[]>();
        for(int i = 0; i < people.length; i++)
            temp.add(people[i][1], people[i]);
        int[][] result = new int[people.length][2];
        for(int i = 0; i < temp.size(); i++){
            result[i] = temp.get(i);
        }
        //for(int i = 0; i < people.length; i++)
        //    System.out.println(Arrays.toString(result[i]));
        return result;
    }
    public static void main(String[] args){
        int[][] test = new int[][]{{6,1}, {5,2}, {7,0}, {7,1}, {5,0}, {4,4}};
        QueueReconstruction t = new QueueReconstruction();
        t.reconstructQueue(test);
    }

}
