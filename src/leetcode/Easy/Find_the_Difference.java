package leetcode.Easy;

/**
 * Created by Administrator on 2016/9/20.
 */
public class Find_the_Difference {
    public char findTheDifference(String s, String t) {
        //Solution 1:
//        int[] n=new int[26];
//        for(char c: s.toCharArray()){
//            n[c-'a']++;
//        }
//        for(char c: t.toCharArray()){
//            if(n[c-'a']==0)
//                return c;
//            n[c-'a']--;
//        }
//        return 0;

        //Solution 2:
        char c=t.charAt(t.length()-1);
        for(int i=0;i<s.length();i++){
            c^=s.charAt(i);
            c^=t.charAt(i);
        }
        return c;
    }
}
