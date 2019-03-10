package leetcode.bfs;
/*
841. Keys and Rooms
Medium

There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.

Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.

Initially, all the rooms start locked (except for room 0).

You can walk back and forth between rooms freely.

Return true if and only if you can enter every room.
 */
import java.util.*;
public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms.size() == 0) return true;
        Set<Integer> visited = new HashSet<Integer>();

        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(0);

        while(!q.isEmpty()){
            int curr = q.poll();
            //System.out.println(curr);
            visited.add(curr);
            for(int next : rooms.get(curr)){
                if(visited.contains(next)) continue; //当时用visited[]做标记的时候
                                                     //忽略了在q里面，但还没有visited的顶点
                                                     //这样会在queue重复加入顶点，count不准
                q.offer(next);
            }
        }
        return visited.size() == rooms.size();
    }
}
