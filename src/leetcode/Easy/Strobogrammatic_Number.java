package leetcode.Easy;
import java.util.*;

/**
 * Created by yanglu on 16/8/6.
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Write a function to determine if a number is strobogrammatic. The number is represented as a string.

 For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */
public class Strobogrammatic_Number {
    public boolean isStrobogrammatic(String num) {
//        if(num==null || num.length()==0)
//            return true;
//        Map<Character,Character> map=new HashMap<>();
//        map.put('0','0');
//        map.put('1','1');
//        map.put('6','9');
//        map.put('8','8');
//        map.put('9','6');
//        StringBuilder sb=new StringBuilder();
//        for(int i=num.length()-1;i>=0;i--){
//            if(map.containsKey(num.charAt(i)))
//                sb.append(map.get(num.charAt(i)));
//            else
//                sb.append("#");
//        }
//        return num.equals(sb.toString());

        //Solution 2:
        for (int i=0, j=num.length()-1; i <= j; i++, j--)
            if (!"00 11 88 696".contains(num.charAt(i) + "" + num.charAt(j)))
                return false;
        return true;

        //Solution 3:
//        if(num==null || num.length()==0)
//            return true;
//        Map<Character,Character> map=new HashMap<>();
//        map.put('0','0');
//        map.put('1','1');
//        map.put('6','9');
//        map.put('8','8');
//        map.put('9','6');
//        int l = 0, r = num.length() - 1;
//        while (l <= r) {
//            if (!map.containsKey(num.charAt(l)) || !map.containsKey(num.charAt(r)))
//                return false;
//            if (map.get(num.charAt(l)) != num.charAt(r))
//                return false;
//            l++;r--;
//        }
//        return true;

    }
}
