package leetcode.Hard;
import java.util.*;
/**
 * Created by yanglu on 16/10/4.
 */
public class Minimum_Unique_Word_Abbreviation {
    public static String minAbbreviation(String target, String[] dictionary) {
        List<String> r=new ArrayList<>();
        dfs(r, target, new StringBuilder(), 0, 0);
        Collections.sort(r, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        if(dictionary==null || dictionary.length==0)
            return r.get(0);
        Set<String> set=new TreeSet<>(r);
        for(String d:dictionary){
            if(d.length()==target.length())
                dfsfilter(set, d, new StringBuilder(), 0, 0);
        }
        for(String s:r){
            if(set.contains(s))
                return s;
        }
        return "";
    }
    public static void dfs(List<String> r, String w, StringBuilder sb, int id, int cnt){
        int len=sb.length();
        if(id==w.length()){
            if(cnt>0)
                sb.append(cnt);
            r.add(sb.toString());
            sb.setLength(len);
            return;
        }
        dfs(r, w, sb, id + 1, cnt + 1);
        if(cnt>0)
            sb.append(cnt);
        dfs(r, w, sb.append(w.charAt(id)), id + 1, 0);
        sb.setLength(len);
    }
    public static void dfsfilter(Set<String> r, String w, StringBuilder sb, int id, int cnt){
        int len=sb.length();
        if(id==w.length()){
            if(cnt>0)
                sb.append(cnt);
            if(r.contains(sb))
                r.remove(sb);
        }
        if(sb.length()<=r.iterator().next().length())
            dfsfilter(r, w, sb, id + 1, cnt + 1);
        if(cnt>0)
            sb.append(cnt);
        if(sb.length()<=r.iterator().next().length())
            dfsfilter(r, w, sb.append(w.charAt(id)), id + 1, 0);
        sb.setLength(len);

    }
    public static void main(String[] args){
        String[] dic={};
        System.out.println(minAbbreviation("usaandchinaarefriends", dic));
    }
}
