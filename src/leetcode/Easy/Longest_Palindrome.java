package leetcode.Easy;

import java.util.*;

/**
 * Created by yanglu on 16/10/4.
 */
public class Longest_Palindrome {
    public int longestPalindrome(String s) {
        //Solution 1 : lgn
//        int[] n=new int[256];
//        int r=0;
//        boolean first=true;
//        for(char c:s.toCharArray())
//            n[c]++;
//        Arrays.sort(n);
//        for(int i=n.length-1;i>=0;i--){
//            if(first){
//                if(n[i]!=0) {
//                    first = false;
//                    r += n[i];
//                }
//            }
//            else{
//                if(n[i]%2==0)
//                    r+=n[i];
//                else {
//                    r += (n[i] - 1);
//                    if(r%2==0)
//                        r++;
//                }
//            }
//        }
//        return r;

        //Solution 2: n^2
//        Set<Character> set=new HashSet<Character>();
//        int r=0;
//        for(char c:s.toCharArray()){
//            if(set.contains(c)) {
//                set.remove(c);
//                r++;
//            }
//            else
//                set.add(c);
//        }
//        return  set.isEmpty() ? r*2 : r*2+1;


        //Solution 3: n
        boolean[] map=new boolean[128];
        int r=0;
        for(char c:s.toCharArray()){
            map[c]=!map[c];
            if(!map[c])
                r+=2;
        }
        return r<s.length() ? r+1 : r;
    }
}
