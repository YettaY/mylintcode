package leetcode.Easy;
import java.util.*;
/**
 * Created by yanglu on 16/8/4.
 An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

 a) it                      --> it    (no abbreviation)

 1
 b) d|o|g                   --> d1g

 1    1  1
 1---5----0----5--8
 c) i|nternationalizatio|n  --> i18n

 1
 1---5----0
 d) l|ocalizatio|n          --> l10n
 Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

 Example:
 Given dictionary = [ "deer", "door", "cake", "card" ]

 isUnique("dear") -> false
 isUnique("cart") -> true
 isUnique("cane") -> false
 isUnique("make") -> true
 1) [“dog”]; isUnique(“dig”);
 //False, because “dig” has the same abbreviation with “dog" and “dog” is already in the dictionary. It’s not unique.

 2) [“dog”, “dog"]; isUnique(“dog”);
 //True, because “dog” is the only word that has “d1g” abbreviation.

 3) [“dog”, “dig”]; isUnique(“dog”);
 //False, because if we have more than one word match to the same abbreviation, this abbreviation will never be unique.
 */
public class Unique_Word_Abbreviation {
    class ValidWordAbbr {
        Map<String,Set<String>> map=new HashMap<>();
        public ValidWordAbbr(String[] dictionary) {
            for(int i=0;i<dictionary.length;i++){
                String s=dictionary[i];
                if(s.length()>2)
                    s = s.charAt(0) + Integer.toString(s.length()-2) + s.charAt(s.length() - 1);
                if(map.containsKey(s))
                    map.get(s).add(dictionary[i]);
                else{
                    Set<String> set=new HashSet<String>();
                    set.add(dictionary[i]);
                    map.put(s,set);
                }

            }
        }
        public boolean isUnique(String word) {
            String s=word;
            if(s.length()>2)
                s=s.charAt(0)+Integer.toString(s.length()-2)+s.charAt(s.length()-1);
            if (!map.containsKey(s))
                return true;
            return map.get(s).contains(word) && map.get(s).size()<=1;
        }
    }
}
