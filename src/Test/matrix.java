package Test;
//�Խ����������
public class matrix {
/**
��ά���� �Խ������ ��������
����������飺
{ 1, 2, 3, 4 }, 
{ 5, 6, 7, 8 },
{ 9, 10, 11, 12 }, 
{ 13, 14, 15, 16 },

slash���������
1 
5 2 
9 6 3 
13 10 7 4 
14 11 8 
15 12 
16 

backslash�����
4 
3 8 
2 7 12 
1 6 11 16 
5 10 15 
9 14 
13 

������������������Բ���ȣ���ͬһ�е�Ԫ�ظ���������ȣ���Ϊ"����"������*/
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
        for( int k = 0 ; k < col * 2 -(col-row) ; k++ ) {     //k�����ж������������col����
            int sum = k;                              //ͬһ�е�Ԫ�أ����±�����±�ĺ����
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
        for (int k = 0; k < col * 2 - (col-row); k++) {     //k�����ж������������col����
            int diff = col - k - 1;                 //ͬһ�е�Ԫ�أ����±�����±�Ĳ����
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
