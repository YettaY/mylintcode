package leetcode.Easy;
import java.util.*;
/**
 * Created by yanglu on 16/8/8.
 * Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

 "abc" -> "bcd" -> ... -> "xyz"
 Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

 For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 A solution is:

 [
 ["abc","bcd","xyz"],
 ["az","ba"],
 ["acef"],
 ["a","z"]
 ]
 The basic idea is to set a key for each group: the sum of the difference between the adjacent chars in one string.
 Then we can easily group the strings belonging to the same shifting sequence with the same key. The code is as the following:
 */
public class Group_Shifted_Strings {
    public static List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = null;
        Map<String,List<String>> map = new HashMap<>();

        for(String string: strings){
            int shift = string.charAt(0) - 'a';
            StringBuilder key = new StringBuilder();

            for(int i=0;i<string.length();i++){
                key.append((char)(string.charAt(i)+26-shift)%26);
                //System.out.println(key.toString());
            }

            String k = key.toString();
            if(!map.containsKey(k)) map.put(k,new ArrayList<String>());
            map.get(k).add(string);
        }
        res = new ArrayList<>(map.values());
        return res;
    }
    public static void main(String[] args){
        String[] s={"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        groupStrings(s);
    }

}
