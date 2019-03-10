package leetcode.greedy;
/*
452. Minimum Number of Arrows to Burst Balloons
Medium

There are a number of spherical balloons spread in two-dimensional space.
For each balloon, provided input is the start and end coordinates of the horizontal diameter.
Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end
of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.

An arrow can be shot up exactly vertically from different points along the x-axis.
A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend.
There is no limit to the number of arrows that can be shot. An arrow once shot keeps t
ravelling up infinitely. The problem is to find the minimum number of arrows that must
be shot to burst all balloons.
 */
import java.util.*;

public class MinimumNumberOfArrowsToBurstBalloons {
    //straight solution
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        boolean[] visited = new boolean[points.length];
        int count = 0;
        for(int i = 0; i < points.length; i++){
            if(visited[i]) continue;
            int end = points[i][1];
            visited[i] = true;
            for(int j = i+1; j < points.length; j++){
                if(visited[j]) continue;
                if(points[j][0] <= end) visited[j] = true;
            }
            count++;
        }
        return count;
    }

    // better solution
    public int findMinArrowShots2(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int arrowPos = points[0][1];
        int arrowCnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0]) {
                continue;
            }
            arrowCnt++;
            arrowPos = points[i][1];
        }
        return arrowCnt;
    }
}
