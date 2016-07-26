package Test;
//对角线输出矩阵
public class matrix {
/**
二维数组 对角线输出 两个方向
例如对于数组：
{ 1, 2, 3, 4 }, 
{ 5, 6, 7, 8 },
{ 9, 10, 11, 12 }, 
{ 13, 14, 15, 16 },

slash方向输出：
1 
5 2 
9 6 3 
13 10 7 4 
14 11 8 
15 12 
16 

backslash输出：
4 
3 8 
2 7 12 
1 6 11 16 
5 10 15 
9 14 
13 

数组的行数和列数可以不相等，但同一行的元素个数必须相等，称为"矩阵"更合适*/
    public static void main(String[] args) {
        // row != col:
        int[][] arr = new int[][] { 
                { 1, 2, 3 }, 
                { 5, 6, 7},
                { 9, 10, 11 }, 
                { 13, 14, 15 },
                { 17, 18, 19}
        };
        
//        int[][] arr = new int[][] { 
//                { 1, 2, 3, 4 }, 
//                { 5, 6, 7, 8 },
//                { 9, 10, 11, 12 }, 
//                { 13, 14, 15, 16 }, 
//        };

        slash(arr);
        System.out.println("======");
        backslash(arr);
        
        
    }
    
    public static void slash(int[][] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("arr cannot be null");
        }
        int col = arr[0].length,row = arr.length;
        for( int k = 0 ; k < col * 2 -(col-row) ; k++ ) {     //k代表有多少行输出，由col决定
            int sum = k;                              //同一行的元素，行下标和列下标的和相等
            for( int j = 0 ; j < col ; j++ ) {                 
                int i = sum - j;
                if(isValidIndex(i, row) && isValidIndex(j, col)) {
                    System.out.print( arr[i][j] + " " );
                }
            }
            System.out.println();
        }
    }
    
    public static void backslash(int[][] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("arr cannot be null");
        }
        int col = arr[0].length,row = arr.length;
        for (int k = 0; k < col * 2 - (col-row); k++) {     //k代表有多少行输出，由col决定
            int diff = col - k - 1;                 //同一行的元素，行下标和列下标的差相等
            for (int j = 0; j < col; j++) {
                int i = j - diff;
                if (isValidIndex(i, row) && isValidIndex(j, col)) {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static boolean isValidIndex(int i, int n) {
        return i >= 0 && i < n;
    }
}
