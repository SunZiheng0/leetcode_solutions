package leetcode.greedy;
/*
 Given a collection of intervals, find the minimum number of intervals you need
 to remove to make the rest of the intervals non-overlapping.

Note:

    You may assume the interval's end point is always bigger than its start point.
    Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.

Example 1:

Input: [ [1,2], [2,3], [3,4], [1,3] ]

Output: 1
 */


import java.util.*;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
  }

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> (a.end - b.end));

        int count = 0;
        int end = intervals[0].end;
        for(int i = 1; i < intervals.length; i++){
            int nextStart = intervals[i].start;
            if(nextStart < end){
                count++;
            }else{
                end = intervals[i].end;
            }
        }
        return count;

    }
}
