package leetcode.Medium;
import java.util.*;
/**
 * Created by yanglu on 16/8/7.
 Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
 The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
 Note that you can only put the bomb at an empty cell.

 Example:
 For the given grid

 0 E 0 0
 E 0 W E
 0 E 0 0

 return 3. (Placing a bomb at (1,1) kills 3 enemies)
 */
public class Bomb_Enemy {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        if(grid == null || m == 0) return 0;
        int n = grid[0].length;

        int[][] max = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(grid[i][j] == '0'){
                    int count = 0;

                    //count all possible hits in its upward direction
                    for(int k = j-1; k >= 0; k--){
                        if(grid[i][k] == 'E') {
                            count++;
                        } else if(grid[i][k] == 'W') {
                            break;
                        }
                    }

                    //count all possible hits in its downward direction
                    for(int k = j+1; k < n; k++){
                        if(grid[i][k] == 'E') {
                            count++;
                        } else if(grid[i][k] == 'W') {
                            break;
                        }
                    }

                    //count all possible hits in its right direction
                    for(int k = i+1; k < m; k++){
                        if(grid[k][j] == 'E') {
                            count++;
                        } else if(grid[k][j] == 'W') {
                            break;
                        }
                    }

                    //count all possible hits in its left direction
                    for(int k = i-1; k >= 0; k--){
                        if(grid[k][j] == 'E') {
                            count++;
                        } else if(grid[k][j] == 'W') {
                            break;
                        }
                    }

                    max[i][j] = count;

                }
            }
        }

        int result = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(max[i][j] > result) result = max[i][j];
            }
        }
        return result;
    }
    //Solution2：
    public static int bombEnemy(char[][] grid)
    {
        int[][] row=new int[grid.length][grid[0].length+2],col=new int[grid.length+2][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='0')
                {
                    row[i][j+1]=row[i][j];
                    col[i+1][j]=col[i][j];
                }
                else if(grid[i][j]=='E')
                {
                    row[i][j+1]=row[i][j]+1;
                    col[i+1][j]=col[i][j]+1;
                }
                else if(grid[i][j]=='W')
                {
                    row[i][j+1]=0;
                    col[i+1][j]=0;
                }
            }
        }
        for(int i=grid.length-1;i>=0;i--)
        {
            for(int j=grid[0].length-1;j>=0;j--)
            {
                if(grid[i][j]!='W')
                {
                    row[i][j+1]=Math.max(row[i][j+2],row[i][j+1]);
                    col[i+1][j]=Math.max(col[i+2][j], col[i+1][j]);
                }
            }
        }
        int max=0;
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
                if(grid[i][j]=='0')
                    max=Math.max(max, row[i][j+1]+col[i+1][j]);
        return max;
    }
}
