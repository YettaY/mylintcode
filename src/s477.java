import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Administrator on 2016/6/6.
 */
public class s477 {
    Queue<Integer> q=new LinkedList<>();
    int r,c;
    public void surroundedRegions(char[][] board) {
        // Write your code here
        if (board==null || board[0].length==0)
            return;
        r=board.length;
        c=board[0].length;
        for (int i=0;i<r;i++){
            in(board,i,0);
            in(board,i,c-1);
        }
        for (int i=1;i<c-1;i++){
            in(board,0,i);
            in(board,r-1,i);
        }
        while(!q.isEmpty()){
            int x=q.poll();
            int i=x/c,j=x%c;
            if (board[i][j]=='O')
                board[i][j]='D';
            in(board,i+1,j);
            in(board,i-1,j);
            in(board,i,j+1);
            in(board,i,j-1);

        }
        for (int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if (board[i][j]=='O')
                    board[i][j]='X';
                else if (board[i][j]=='D')
                    board[i][j]='O';
            }
        }
    }
    public void in(char[][] b,int i,int j){
        if (i>=0&&i<r&&j>=0&&j<c&& b[i][j]=='O')
            q.offer(i*c+j);
    }
}
