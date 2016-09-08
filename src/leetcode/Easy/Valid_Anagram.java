package leetcode.Easy;
import google.Array;

import java.util.*;
/**
 * Created by Administrator on 2016/9/5.
 */
public class Valid_Anagram {
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        char[] cs=s.toCharArray(), ct=t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        return new String(cs).equals(new String(ct));
    }
    public static void main(String[] args){
        System.out.println(isAnagram("anagram","nagaram"));
    }
}
