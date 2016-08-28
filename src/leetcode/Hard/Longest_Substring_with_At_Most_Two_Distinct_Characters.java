package leetcode.Hard;
import java.util.*;
/**
 * Created by yanglu on 16/8/7.
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

 For example, Given s = “eceba”,

 T is "ece" which its length is 3.
 */
public class Longest_Substring_with_At_Most_Two_Distinct_Characters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
//        Map<Character, Integer> map=new HashMap<>();
//        int j=0,max=0;
//        for(int i=0;i<s.length();i++){
//            while(j<s.length()){
//                if(map.containsKey(s.charAt(j)))
//                    map.put(s.charAt(j),map.get(s.charAt(j))+1);
//                else{
//                    if(map.size()==2)
//                        break;
//                    map.put(s.charAt(j),1);
//                }
//                j++;
//            }
//            max=Math.max(max,j-i);
//            if(map.containsKey(s.charAt(i))){
//                if(map.get(s.charAt(i))==1)
//                    map.remove(s.charAt(i));
//                else
//                    map.put(s.charAt(i),map.get(s.charAt(i))-1);
//            }
//        }
//        return max;


        //Solution2:sliding window
        int maxLen = 0;
        int l = 0, r = 0, cnt = 0;                     // cnt is number of unique chars between l and r
        int[] chars = new int[128];                    // chars is hash map for each char's freq
        while (r < s.length()) {
            if (chars[s.charAt(r)] == 0) {             // adjust l position if next char is not in current char set
                cnt++;
                while (l <= r && cnt > 2) {
                    chars[s.charAt(l)]--;
                    if (chars[s.charAt(l)] == 0) {     // break loop if left char is unique in hash map
                        cnt--;
                    }
                    l++;
                }
            }
            chars[s.charAt(r)]++;
            r++;
            maxLen = Math.max(maxLen, r - l);
        }

        return maxLen;
    }
}
