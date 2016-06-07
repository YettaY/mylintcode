/**
 * Created by Administrator on 2016/6/5.
 */
import java.util.*;
public class s426 {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Write your code here
        ArrayList<String> r = new ArrayList<>();
        if (s == null || s.length() == 0)
            return r;
        dfs(r,new ArrayList<String>(),s,0);
        return r;
    }
    public void dfs(ArrayList<String> r, ArrayList<String> cur,String s,int id){
        if (cur.size()==4){
            if (id==s.length()){
                StringBuilder sb=new StringBuilder();
                for (String str:cur)
                    sb.append(str+".");
                r.add(sb.substring(0,sb.length()-1).toString());
            }
            return;
        }
        for (int i=id;i<s.length() &&i<=id+3;i++){
            if (i>id && s.charAt(id)=='0')
                break;
            String str=s.substring(id,i+1);
            if (Integer.valueOf(str)>255)
                continue;
            cur.add(str);
            dfs(r,cur,s,i+1);
            cur.remove(cur.size()-1);
        }
    }
}
