package leetcode.Hard;
import java.util.*;

/**
 * Created by yanglu on 16/8/7.
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example:

 Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
 Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

 0 0 0
 0 0 0
 0 0 0
 Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

 1 0 0
 0 0 0   Number of islands = 1
 0 0 0
 Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

 1 1 0
 0 0 0   Number of islands = 1
 0 0 0
 Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

 1 1 0
 0 0 1   Number of islands = 2
 0 0 0
 Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

 1 1 0
 0 0 1   Number of islands = 3
 0 1 0
 We return the result as an array: [1, 1, 2, 3]

 The basic idea is the Union-Find approach. We assign a root number for each island, and use an array to record this number.
 For each input, we check its four neighbor cells.
 If the neighbor cell is an island, then we retrieve the root number of this island.
 If two neighbor cells belong to two different islands, then we union them and therefore the total number of islands will become one less.
 */
public class Number_of_Islands_II {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> r=new ArrayList<>();
        int[] root=new int[m*n];        // one island = one tree
        Arrays.fill(root,-1);
        int[][] d={{1,0},{-1,0},{0,1},{0,-1}};
        int cnt=0;                      // number of islands
        for(int[] p:positions){
            root[p[0]*n+p[1]]=p[0]*n+p[1];  // assume new point is isolated island
            cnt++;                           // add new island
            for(int i=0;i<d.length;i++){
                int x=p[0]+d[i][0], y=p[1]+d[i][1];
                if(x>=0 && x<m && y>=0 && y<n && root[x*n+y]!=-1){
                    int rn=find(x*n+y,root);
                    if(rn!=p[0]*n+p[1]){     // if neighbor is in another island
                        root[rn]=p[0]*n+p[1];    // union two islands
                        cnt--;                   // current tree root = joined tree root
                    }
                }
            }
            r.add(cnt);
        }
        return r;
     }
     public int find(int t, int[] root ){
         while(t!=root[t]){
             root[t]=root[root[t]];
             t=root[t];
         }
         return t;
     }

}
