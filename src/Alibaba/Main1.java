package Alibaba;

/**
 * Created by yanglu on 16/9/11.
 * Hulu葫芦娃笔试题，'#'可以走，横着可以走；竖着有梯子，长度不能超过梯子；可以跳跃'#-#',但只有s次，s最大是2
 * 从左下角走，求最多能走过多少个'#',输入第一行是表示有几个测试用例，接下来一行n,m,len,s表示行，列，梯子高，跳数，输出：12
 1
 4 5 3 2
 -####
 ##--#
 ---#-
 ###-#
 */
import java.util.*;
public class Main1 {


    static HashMap<Integer, Integer> sum;//记录块号和该块的'#'数
    static int count;//记录块数
    static int[][] marked;//用不同的数字,标记每一块
    static int[][] matrix;//邻接矩阵,记录各块之间的可跳跃情况
    static int max;//最大和
    static int s;//跳跃次数

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String line1 = in.nextLine();
        String[] str = line1.split("\n");
        int N = Integer.valueOf(str[0]);
        for(int number = 1; number <= N; number++){
            String line = in.nextLine();
            String[] str2 = line.split(" ");
            int m = Integer.valueOf(str2[0]);
            int n = Integer.valueOf(str2[1]);
            int l = Integer.valueOf(str2[2]);
            s = Integer.valueOf(str2[3]);
            char[][] grid = new char[m][n];
            for(int i = 0 ; i < m ; i++){
                String temp = in.nextLine();
                for(int j = 0; j < temp.length(); j++){
                    grid[i][j] = temp.charAt(j);
                }
            }

            // 初始化标记矩阵
            marked = new int[m][n];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n ; j++){
                    marked[i][j] = -1;
                }
            }

            // 从左下角开始,通过[走路和爬梯子]形成的第一个block
            count = 0;
            sum = new HashMap<>();
            dfs(grid, m-1, 0, l);

            // 形成剩下的block
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++)
                {
                    if(grid[i][j] == '#'){
                        count++;
                        dfs(grid, i, j, l);
                    }
                }
            }


            int blockSize = sum.size();
            if(blockSize == 1){
                System.out.println("Test Case " + number + ": " + sum.get(0));
            }else{
                if(s == 0){
                    System.out.println("Test Case " + number + ": " + sum.get(0));
                }else{
                    // 初始化block之间的跳跃矩阵matrix
                    matrix = new int[blockSize][blockSize];
                    for(int i = 0; i < m ; i++){
                        for(int j = 0; j < n; j++){
                            if(marked[i][j] != -1){ // '-'
                                // 获取当前块可以跳转的块号
                                List<Integer> canJumpBlockNum = getCanJumpBlockNum(marked, i, j);
                                if(canJumpBlockNum != null){
                                    for(int k = 0; k < canJumpBlockNum.size(); k++){
                                        matrix[marked[i][j]][canJumpBlockNum.get(k)] = 1;
                                    }
                                }
                            }
                        }
                    }

                    // 从第一块开始, 深度优先搜素, 找出s步的最长路径
                    max = 0;
                    dfs2(0, s, 0);
                    System.out.println("Test Case " + number + ": " + max);
                }
            }
        }
    }

    private static void dfs(char[][] grid, int i, int j, int l){
        int m = grid.length;
        int n = grid[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '#'){
            return;
        }


        if(grid[i][j] == '#'){
            if(sum.containsKey(count)){
                sum.put(count, sum.get(count) + 1);
            }else{
                sum.put(count, 1);
            }
            grid[i][j] = 'X';//标记一下
            marked[i][j] = count;
        }

        dfs(grid, i, j - 1, l);//左
        dfs(grid, i, j + 1, l);//右
        // 上和下
        for(int k = 1; k <= l; k++){
            dfs(grid, i - k, j, l);
            dfs(grid, i + k, j, l);
        }
    }


    private static List<Integer> getCanJumpBlockNum(int[][] marked, int i, int j) {
        List<Integer> result = new ArrayList<>();
        int m = marked.length;
        int n = marked[0].length;
        if ( ((j-2) >= 0) && ((j-2) < n) && marked[i][j-2] != -1 && marked[i][j-2] != marked[i][j]) {//左
            result.add(marked[i][j-2]);
        }

        if ( ((j+2) >= 0) && ((j+2) < n) && marked[i][j+2] != -1 && marked[i][j+2] != marked[i][j]) {//右
            result.add(marked[i][j+2]);
        }
        return  result;
    }

    private static void dfs2(int i, int s, int temp) {
        temp += sum.get(i);
        max = Math.max(max, temp);
        if(s == 0){
            return;
        }
        for(int j = 0; j <= count; j++){
            if(matrix[i][j] == 1 && j != 0){
                dfs2(j, s-1, temp);
            }
        }

    }
}