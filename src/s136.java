/**
 * Created by Administrator on 2016/6/6.
 */
import java.util.*;
public class s136 {
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> r=new ArrayList<>();
        if (s==null || s.length()==0)
            return r;
        dfs(r,new ArrayList<String>(),s,0);
        return r;
    }

    private void dfs(List<List<String>> r, ArrayList<String> cur, String s, int id) {
        if (id==s.length()){
            r.add(new ArrayList<>(cur));
            return ;
        }
        for (int i=id;i<s.length();i++){
            String s1=s.substring(id,i+1);
            if (!isvalid(s1))
                continue;
            cur.add(s1);
            dfs(r,cur,s,i+1);
            cur.remove(cur.size()-1);
        }
    }

    private boolean isvalid(String s) {
        int i=0,j=s.length()-1;
        while(i<j){
            if (s.charAt(i)!=s.charAt(j))
                return false;
            i++;j--;
        }
        return true;
    }

}
