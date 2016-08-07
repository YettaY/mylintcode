package leetcode.Hard;
import java.util.*;

/**
 * Created by yanglu on 16/8/6.
 * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

 Each 0 marks an empty land which you can pass by freely.
 Each 1 marks a building which you cannot pass through.
 Each 2 marks an obstacle which you cannot pass through.
 For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):

 1 - 0 - 2 - 0 - 1
 |   |   |   |   |
 0 - 0 - 0 - 0 - 0
 |   |   |   |   |
 0 - 0 - 1 - 0 - 0
 The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.

 dist: distances from land to all buildings
 0 9 0 9 0
 9 8 7 8 9
 10 9 0 9 10

 grid: has changed to be
 -1 3 -2 3 -1
 3 3 3 3 3
 3 3 -1 3 3
 */
public class Shortest_Distance_from_All_Buildings {
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

    public static int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        // Initialize building list and accessibility matrix `grid`
        List<Tuple> buildings = new ArrayList<>();
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1)
                    buildings.add(new Tuple(i, j, 0));
                grid[i][j] = -grid[i][j];
            }
        // BFS from every building
        for (int k = 0; k < buildings.size(); ++k)
            bfs(buildings.get(k), k, dist, grid, m, n);
        // Find the minimum distance
        int ans = -1;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (grid[i][j] == buildings.size() && (ans < 0 || dist[i][j] < ans))
                    ans = dist[i][j];
        return ans;
    }

    public static void bfs(Tuple root, int k, int[][] dist, int[][] grid, int m, int n) {
        Queue<Tuple> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            Tuple b = q.poll();
            dist[b.y][b.x] += b.dist;
            for (int i = 0; i < 4; ++i) {
                int x = b.x + dx[i], y = b.y + dy[i];
                if (y >= 0 && x >= 0 && y < m && x < n && grid[y][x] == k) {
                    grid[y][x] = k + 1;
                    q.add(new Tuple(y, x, b.dist + 1));
                }
            }

            System.out.println("--------grid--------");
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    System.out.print(grid[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("-------------dist-------");
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    System.out.print(dist[i][j]+" ");
                }
                System.out.println();
            }

        }
    }
    static class Tuple {
        public int y;
        public int x;
        public int dist;

        public Tuple(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }
    public static void main(String[] args){
        int[][] g={{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        shortestDistance(g);
    }
}
