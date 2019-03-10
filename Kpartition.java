package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
973. K Closest Points to Origin
Easy

We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 */
public class Kpartition {

    public int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][2];
        double[] distances = new double[points.length];
        //System.out.println(points.length);

        for(int i = 0; i < points.length; i++){
            distances[i] = Math.sqrt((points[i][0] * points[i][0] + points[i][1] * points[i][1]));
            System.out.println(distances[i]);
        }
        System.out.println("-----------------");

        double[] dists = new double[distances.length];
        for(int i = 0; i < distances.length; i++) dists[i] = distances[i];
        //distances 顺序被打乱
        double kDist = kDistance(dists, K, 0, distances.length - 1);
        System.out.println(kDist);
        int j = 0;
        System.out.println("-----------------");

        for(int i = 0; i < distances.length; i++){
            if(distances[i] <= kDist) result[j++] = points[i];
            System.out.println(i + " : " + distances[i]);
        }

        return result;
    }
    private double kDistance(double[] dists, int K, int lo, int hi){
        int i = partition(dists, K, lo, hi);
        if(i == K - 1) return dists[i];
        else if(i < K - 1) return kDistance(dists, K, i+1, hi);
        else return kDistance(dists, K, lo, i-1);
    }

    private int partition(double[] dists, int K, int lo, int hi){
        if(lo >= hi) return lo;
        int i = lo, j = hi+1;
        while(true){
            while(dists[++i] < dists[0]) if(i == hi) break;
            while(dists[--j] > dists[0]) if(j == lo) break;
            if(i >= j) break;
            else exchange(dists, i, j);
        }
        exchange(dists, lo, i);
        return i;
    }

    private void exchange(double[] distances, int p1 , int p2){
        double t = distances[p1];
        distances[p1] = distances[p2];
        distances[p2] = t;
    }

    public static void main(String[] args){
        int[][] points = {{1,3},{2,2},{1,1},{3,4},{1,2},{3,2}};
        int K = 4;
        int[][] result = new Kpartition().kClosest(points, K);
        for(int[] point : result){
            System.out.println(point[0] + " " + point[1]);
        }
    }

}
