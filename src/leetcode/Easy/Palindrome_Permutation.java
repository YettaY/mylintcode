package leetcode.Easy;
import java.util.*;

/**
 * Created by yanglu on 16/8/8.
 * Given a string, determine if a permutation of the string could form a palindrome.

 For example,
 "code" -> False, "aab" -> True, "carerac" -> True.

 The idea is to iterate over string, adding current character to set if set doesn't contain that character, or removing current character from set if set contains it.
 When the iteration is finished, just return set.size()==0 || set.size()==1.

 set.size()==0 corresponds to the situation when there are even number of any character in the string, and
 set.size()==1 corresponsds to the fact that there are even number of any character except one.

 */
public class Palindrome_Permutation {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set=new HashSet<Character>();
        for(int i=0; i<s.length(); ++i){
            if (!set.contains(s.charAt(i)))
                set.add(s.charAt(i));
            else
                set.remove(s.charAt(i));
        }
        return set.size()==0 || set.size()==1;
    }

    //Solution 2:
//    char[] A = new char[256];
//    int count=0;
//    for(int i=0; i<s.length(); i++){
//        if(A[s.charAt(i)]>0) {
//            A[s.charAt(i)]--;
//            count--;
//        } else {
//            A[s.charAt(i)]++;
//            count++;
//        }
//    }
//    return count<=1;
}
