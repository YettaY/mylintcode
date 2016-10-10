package leetcode.Easy;

import java.util.List;

/**
 * Created by yanglu on 16/10/4.
 */
public class Valid_Word_Abbreviation {
    public static boolean validWordAbbreviation(String word, String abbr) {
        //Solution 1:
      //  return dfs(word, abbr, "", 0, 0);

        //Solution 2:
        //return dfs1(word, abbr, new StringBuilder(), 0, 0);

        //Solution 3:
        int i=0, j=0;
        while(i<word.length() && j<abbr.length()){
            if(word.charAt(i)==abbr.charAt(j)){
                i++;j++;
                continue;
            }
            if(abbr.charAt(j)<='0' || abbr.charAt(j)>'9')
                return false;
            int start=j;
            while(j<abbr.length() && abbr.charAt(j)>='0' && abbr.charAt(j)<='9')
                j++;
            i+=Integer.valueOf(abbr.substring(start, j));
        }
        return i==word.length() && j==abbr.length();
    }
    public static boolean dfs(String w,String abbr, String s, int id, int cnt){
        if(id==w.length()){
            if(cnt>0)
                s+=cnt;
            if(s.equals(abbr))
                return true;
            return false;
        }
        else {
            boolean ans= dfs( w, abbr, s, id + 1, cnt + 1) || dfs( w, abbr, s+(cnt>0?cnt:"")+w.charAt(id), id + 1, 0);
            return ans;
        }
    }
    public static boolean dfs1(String w, String abbr, StringBuilder sb, int id, int cnt){
        int len=sb.length();
        if(id==w.length()){
            if(cnt>0)
                sb.append(cnt);
            if(sb.toString().equals(abbr))
                return true;
            sb.setLength(len);
            return false;
        }

        boolean ans1=dfs1(w, abbr, sb, id + 1, cnt + 1);
        if(cnt>0)
            sb.append(cnt);
        boolean ans2=dfs1(w, abbr, sb.append(w.charAt(id)), id + 1, 0);
        sb.setLength(len);
        return ans1 || ans2;
    }

    public static void main (String[] args){
        System.out.println(validWordAbbreviation("internationalization", "i12iz4n"));
    }
}
