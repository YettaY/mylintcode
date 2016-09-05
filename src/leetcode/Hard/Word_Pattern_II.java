package leetcode.Hard;
import java.util.*;
import java.util.stream.Collector;

/**
 * Created by Administrator on 2016/9/1.
 * 1. dfs
 * 2.The idea might not be so different, but I tried to optimize the solution as much as I could. In concrete:

 Instead of using HashMap, I use a String array to store the character --> String mapping
 Instead of trying all combinations, I only try necessary/possible ones.
 I'd like to explain the second point a little bit more: Suppose we are successful in mapping the first i characters in pattern, and we are now at the j location of str. If i+1's character in pattern is not already mapped, then we would want to try all possible substrings in str, that is, the substring could be of length 1 (j's character), or length 2 (j and j+1), etc. Normally we would try up to the end of str, but this is really not necessary, because we have to spare enough space future characters in pattern. If this is not clear enough, let's take the following as an example:

 pattern = "abca"
 str = "xxxyyzzxxx"
 Suppose we have successfully matched a to xxx and b to yy, and now we are at the third character of pattern, i.e., character c. We have not mapped c to anything, so we could try any of the following:

 z
 zz
 zzx
 zzxx
 zzxxx
 But do we really need to try them all? The answer is NO. Because we have already mapped a and b, and under this constraint, we have to save enough space for the fourth character of pattern, i.e., a. In other words, we can at most try z and zz, otherwise we are doomed to return false when we reach the fourth character a. This is what endPoint is about in the code.
 */
public class Word_Pattern_II {
    //Solution 1:
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map=new HashMap<>();
        return find(map, pattern, 0, str, 0);
    }
    public boolean find(Map<Character, String> map, String p, int i, String s, int j){
        if(i==p.length() && j==s.length())
            return true;
        if(i==p.length() || j==s.length())
            return false;
        char c=p.charAt(i);
        if (map.containsKey(c)) {
            String t=map.get(c);
            if(j+t.length()>s.length() || !s.substring(j,j+t.length()).equals(t))
                return false;
            return find(map,p,i+1,s,j+t.length());
        }
        else{
            for(int k=j;k<s.length();k++){
                String next=s.substring(j,k+1);
                if(map.containsValue(next))
                    continue;
                map.put(c,next);
                if(find(map,p,i+1,s,k+1))
                    return true;
                map.remove(c);
            }
        }
        return false;
    }

    //Solution 2:
//    public boolean wordPatternMatch(String pattern, String str) {
//        Map<Character, String> map=new HashMap<>();
//        return find(map, pattern, 0,pattern.length()-1, str, 0, str.length()-1);
//    }
//    public boolean find(Map<Character, String> map, String p, int ps, int pe, String s, int ss, int se){
//        if(ps==pe+1 && ss==se+1)
//            return true;
//        if((ps>pe && ss<=se) || (ps<=pe && ss>se))
//            return false;
//        char c=p.charAt(ps);
//        if(map.containsKey(c)){
//            String t=map.get(c);
//            if(ss+t.length()>s.length() || !s.substring(ss,ss+t.length()).equals(t))
//                return false;
//            return find(map,p,ps+1,pe,s,ss+t.length(),se);
//        }
//        else{
//            int end=se;
//            for(int i=pe;i>ps;i--)
//                end -= map.containsKey(p.charAt(i)) ? map.get(p.charAt(i)).length() : 1 ;
//            for(int i=ss;i<=end;i++){
//                String next=s.substring(ss, i+1);
//                if (map.containsValue(next))
//                    continue;
//                map.put(c, next);
//                if(find(map,p,ps+1,pe,s,i+1,se))
//                    return true;
//                map.remove(c);
//            }
//        }
//        return false;
//    }
}
