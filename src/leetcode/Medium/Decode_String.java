package leetcode.Medium;
import java.util.*;
/**
 * Created by yanglu on 16/9/20.
 */
public class Decode_String {
    public String decodeString(String s) {
        Stack<Integer> count=new Stack<>();
        Stack<String> r=new Stack<>();
        r.push("");
        int i=0;
        while(i<s.length()){
            char c=s.charAt(i);
            if(c>='0' && c<='9'){
                int start=i;
                while(s.charAt(i+1)>='0' && s.charAt(i+1)<='9')
                    i++;
                count.push(Integer.parseInt(s.substring(start, i+1)));
            }
            else if(c=='[')
                r.push("");
            else if(c==']'){
                String cur=r.pop();
                StringBuilder sb=new StringBuilder();
                int n=count.pop();
                for (int j=0;j<n;j++)
                    sb.append(cur);
                r.push(r.pop()+sb);
            }
            else
                r.push(r.pop()+c);
            i++;
        }
        return r.pop();
    }
}
