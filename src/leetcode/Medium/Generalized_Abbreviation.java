package leetcode.Medium;
import java.util.*;

/**
 * Created by yanglu on 16/8/7.
 Write a function to generate the generalized abbreviations of a word.
 Example:
 Given word = "word", return the following list (order does not matter):
 ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

 For each char c[i], either abbreviate it or not.

 Abbreviate: count accumulate num of abbreviating chars, but don't append it yet.
 Not Abbreviate: append accumulated num as well as current char c[i].
 In the end append remaining num.
 Using StringBuilder can decrease 36.4% time.
 */
public class Generalized_Abbreviation {
//    public List<String> generateAbbreviations(String word) {
//        List<String> r=new ArrayList<>();
//        dfs(r,word,new StringBuilder(),0,0);
//        return r;
//    }
//    public void dfs(List<String> r, String w, StringBuilder sb, int id, int cnt){
//        int len=sb.length();
//        if(id==w.length()){
//            if(cnt>0)
//                sb.append(cnt);
//            r.add(sb.toString());
//
//        }
//        else {
//            dfs(r, w, sb, id + 1, cnt + 1);
//            if(cnt>0)
//                sb.append(cnt);
//            dfs(r, w, sb.append(w.charAt(id)), id + 1, 0);
//        }
//        sb.setLength(len);
//    }

    //Solution 2:
    public List<String> generateAbbreviations(String word) {
        List<String> r=new ArrayList<>();
        dfs(r,word,"",0,0);
        return r;
    }
    public void dfs(List<String> r, String w, String s, int id, int cnt){
        if(id==w.length()){
            if(cnt>0)
                s+=cnt;
            r.add(s);

        }
        else {
            dfs(r, w, s, id + 1, cnt + 1);
            dfs(r, w, s, id + 1, 0);
        }
    }

}
