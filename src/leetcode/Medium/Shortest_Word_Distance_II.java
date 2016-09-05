package leetcode.Medium;
import java.util.*;
/**
 * Created by Administrator on 2016/9/5.
 This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?
 Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

 For example,
 Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Given word1 = “coding”, word2 = “practice”, return 3.
 Given word1 = "makes", word2 = "coding", return 1.

 Note:
 You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class Shortest_Word_Distance_II {
    public class WordDistance {
        Map<String, List<Integer>> map;
        public WordDistance(String[] words) {
           map=new HashMap<String, List<Integer>>();
            for(int i=0;i<words.length;i++){
                if(!map.containsKey(words[i]))
                    map.put(words[i], new ArrayList<Integer>());
                map.get(words[i]).add(i);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> w1=map.get(word1), w2=map.get(word2);
            int i=0, j=0, min=Integer.MAX_VALUE;
            while(i<w1.size() && j<w2.size()){
                if(w1.get(i)<w2.get(j))
                    min=Math.min(min, w2.get(j)-w1.get(i++));
                else
                    min=Math.min(min, w1.get(i)-w2.get(j++));
            }
            return min;
        }
    }
}
