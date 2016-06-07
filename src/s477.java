import java.util.*;

/**
 * Created by Administrator on 2016/6/6.
 */
public class s477 {
    Queue<Integer> q=new LinkedList<>();
    int r,c;
    public void surroundedRegions(char[][] board) {
        // Write your code here
        if (board==null || board.length==0)
            return;
        r=board.length;
        c=board[0].length;
        for (int i=0;i<r;i++){
            for (int j=0;j<c;j++){
                if (board[i][j]=='0') {
                    in(board, i, j);
                    board[i][j]='D';
                }
            }
        }

    }
    public void in(char[][] b,int x,int y){
        if (x>=0 && x<b.length && y>=0 && y<b[0].length && b[x][y]=='0')
            q.offer(x%c+y);
    }
}
