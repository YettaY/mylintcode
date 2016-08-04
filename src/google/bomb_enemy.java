package google;

/**
 * Solution1: Since a wall blocks one bomb in its direction, we can just count all possible enemies one can hit in all four directions
 * and store the count for each empty call in a matrix called max,then return the max in this max matrix.
 *Solution2：Have two DP Arrays, one for Columns, and one for Rows.
 ie. dpRows[i,j] = number of X's that can be burst in the current row,
 and dpCols[i, j] = number of X's that can be burst in the current column.
 You need two n^2 iterations, one from Top left to bottom right, and one from bottom right to top left, updating both dpRows and dpColums.
 Whenever you encounter 'Y', a wall, dpRows[i, j] becomes 0;
 The result will be the maximum of dpRows[i,j] + dpCols[i,j] at the end.
 The below code should be done from TopLeft to BottomRight
 */
public class bomb_enemy {
    //Solution 1
    public static int maxKilledEnemies(char[][] grid) {
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
                        if(grid[i][k] == 'X') {
                            count++;
                        } else if(grid[i][k] == 'Y') {
                            break;
                        }
                    }

                    //count all possible hits in its downward direction
                    for(int k = j+1; k < n; k++){
                        if(grid[i][k] == 'X') {
                            count++;
                        } else if(grid[i][k] == 'Y') {
                            break;
                        }
                    }

                    //count all possible hits in its right direction
                    for(int k = i+1; k < m; k++){
                        if(grid[k][j] == 'X') {
                            count++;
                        } else if(grid[k][j] == 'Y') {
                            break;
                        }
                    }

                    //count all possible hits in its left direction
                    for(int k = i-1; k >= 0; k--){
                        if(grid[k][j] == 'X') {
                            count++;
                        } else if(grid[k][j] == 'Y') {
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
                else if(grid[i][j]=='X')
                {
                    row[i][j+1]=row[i][j]+1;
                    col[i+1][j]=col[i][j]+1;
                }
                else if(grid[i][j]=='Y')
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
                if(grid[i][j]!='Y')
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
    public static void main(String[] args){
        /*You have one bomb and you want to kill as many as possible enemies with it. The bomb will kill all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
        Given such a grid, return the maximum enemies you can kill with one bomb.
        Note that you can only put the bomb at empty cell.
                In the example, if you put a bomb at (1,1) you will kill 3 enemies which is the best you can get. You can not kill the guy behind the wall at (1,3).*/
        char[][] m={{'0', 'X', 'X'},
                {'X', '0', '0'},
                {'0', 'Y', 'X'}};
        System.out.println(bombEnemy(m));
        System.out.println(maxKilledEnemies(m));
    }
}
