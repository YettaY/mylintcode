package leetcode.Easy;
import java.util.*;

/**
 * Created by yanglu on 16/8/11.
 */
public class Ransom_Note {
    public boolean canConstruct(String ransomNote, String magazine) {
        //Solution 1:
//        int[] arr = new int[26];
//        for (int i = 0; i < magazine.length(); i++) {
//            arr[magazine.charAt(i) - 'a']++;
//        }
//        for (int i = 0; i < ransomNote.length(); i++) {
//            if(--arr[ransomNote.charAt(i)-'a'] < 0) {
//                return false;
//            }
//        }
//        return true;

        // Solution2:
        Map<Character, Integer> map=new HashMap<>();
        for(char c:magazine.toCharArray()){
            if (!map.containsKey(c))
                map.put(c,0);
            map.put(c, map.get(c)+1);
        }
        for (char c:ransomNote.toCharArray()){
            if (!map.containsKey(c) || map.get(c)-1<0)
                return false;
            map.put(c,map.get(c)-1);
        }
        return true;
    }
}
