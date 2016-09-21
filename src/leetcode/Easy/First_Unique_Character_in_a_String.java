package leetcode.Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/19.
 */
public class First_Unique_Character_in_a_String {
    public int firstUniqChar(String s) {
        if(s==null || s.length()==0)
            return -1;
        //Solution 1: 数组记录字母出现的次数
//        int[] n=new int[256];
//        for(char c:s.toCharArray())
//            n[c]++;
//        for(int i=0;i<s.length();i++) {
//            if(n[s.charAt(i)]==1)
//                return i;
//        }
//        return -1;

        //Solution 2：数组记录字母的位置
        int[] n=new int[256];
        int i=1, all=0;
        for(char c:s.toCharArray()) {
            if(n[c]==0)
                n[c]=i;
            else if(n[c]>0){
                n[c]=-1;
                if(++all == 26)  //所有字母至少都出现2次
                    return -1;
            }
            i++;
        }
        int r=s.length()+1;
        for(int id : n) {
            if(id > 0)
                r=Math.min(r, id);
        }
        return r==s.length()+1 ? -1 : r-1;
    }
}
