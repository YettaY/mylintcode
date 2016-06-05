/**
 * Created by Administrator on 2016/6/5.
 */
import java.util.*;
public class s427 {
    public ArrayList<String> generateParenthesis(int n) {
        // Write your code here
        ArrayList<String> r=new ArrayList<>();
        dfs(r,"",n,n);
        return r;
    }
    public void dfs(ArrayList<String> r,String s, int left,int right){
        if (left>right)
            return ;
        if (left==0 && right==0){
            r.add(s);
            return ;
        }
        if (left>0)
            dfs(r,s+"(",left-1,right);
        if (right>0)
            dfs(r,s+")",left,right-1);
    }
}
