package indeed.indeed2;

import java.util.*;

public class Main4 {
    public static int rtn = 0;
    public static boolean fun(int map[][], int row, int col, int cmp){
        int cnt = 0;
        int colend = cmp == 1 ? col : 5;
        int rowend = cmp == 1 ? row : 5;
        for(int j = 0; j <= colend; j++){
            if(map[row][j] == cmp)
                cnt ++;
        }
        if(cnt > 3)
            return false;

        cnt = 0;
        for(int i = 0; i <= rowend; i++){
            if(map[i][col] == cmp)
                cnt ++;
        }
        if(cnt > 3)
            return false;

        return true;
    }

    public static boolean isvalid(int matrix[][]){
        for(int i = 0; i < 6; i++){
            int cnt = 0;
            for(int j = 0; j < 6; j++){
                if(matrix[i][j] == 0)
                    cnt ++;
            }
            if(cnt > 3)
                return false;
        }
        for(int j = 0; j < 6; j++){
            int cnt = 0;
            for(int i = 0; i < 6; i++){
                if(matrix[i][j] == 0)
                    cnt ++;
            }
            if(cnt > 3)
                return false;
        }
        return true;
    }
    public static void dfs(int index, int map[][]){
        if(index == 36){
            rtn++;
            return;
        }
        int row = index / 6, col = index % 6;
        if(map[row][col] == 0){
            dfs(index + 1, map);
        }else{
            map[row][col] = 0;
            if(fun(map, row, col, 0))
                dfs(index + 1, map);

            map[row][col] = 1;
            if(fun(map, row, col, 1))
                dfs(index + 1, map);
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int map[][] = new int[6][6];
        for(int i = 0; i < 6; i++){
            String s = in.next();
            for(int j = 0; j < 6; j++){
                map[i][j] = s.charAt(j) == 'o' ? 0 : 1;
            }
        }
        if(!isvalid(map)){
            System.out.println(0);
            return;
        }
        dfs(0, map);
        System.out.println(rtn);
    }


}