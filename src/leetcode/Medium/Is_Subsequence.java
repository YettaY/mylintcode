package leetcode.Medium;
import google.Array;

import java.util.*;
/**
 * Created by Administrator on 2016/9/20.
 */
public class Is_Subsequence {
    public boolean isSubsequence(String s, String t) {
        //Solution 1:
        int p1=0, p2=0;
        while(p1<s.length() && p2<t.length()){
            if(s.charAt(p1)==t.charAt(p2))
                p1++;
            p2++;
        }
        return p1==s.length();

        //Solution 2：Follow up  超时
        /*
        * constructing a hash map to store the positions for every character.
        * Then scan the incoming string one by one, for every character,
        * if there is no such character in the hash map,
        * or the number of such character is greater than the original string, or most critically,
        * the position is not behind the position of its previous character, it will return false.
        * So I need another array to record the index for every character.
        * The time complexity is just the sum of length of incoming strings. */

//        Map<Integer,List<Integer>> map=new HashMap<>();
//        for(int i=0;i<t.length();i++){
//            if(!map.containsKey(t.charAt(i)-'a'))
//                map.put(t.charAt(i)-'a', new ArrayList<Integer>());
//            map.get(t.charAt(i)-'a').add(i);
//        }
//        int pre=-1;
//        int[] id=new int[26];
//        Arrays.fill(id, -1);
//        for(int i=0;i<s.length();i++){
//            int j=s.charAt(i)-'a';
//            if(!map.containsKey(j))
//                return false;
//            id[j]++;
//            while(id[j] < map.get(j).size()){
//                if(map.get(j).get(id[j]) > pre)
//                    break;
//                id[j]++;
//            }
//            if(id[j] >= map.get(j).size())
//                return false;
//            pre=map.get(j).get(id[j]);
//        }
//        return true;
    }
}
