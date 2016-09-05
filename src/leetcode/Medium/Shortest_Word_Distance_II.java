package leetcode.Medium;

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
        String[] w;
        public WordDistance(String[] words) {
            this.w=words;
        }

        public int shortest(String word1, String word2) {
            int p1=-1, p2=-1, min=Integer.MAX_VALUE;
            for(int i=0;i<w.length;i++){
                if(w[i].equals(word1))
                    p1=i;
                if(w[i].equals(word2))
                    p2=i;
                if(p1!=-1 && p2!=-1 && min > Math.abs(p1-p2))
                    min=Math.abs(p1-p2);
            }
            return min;
        }
    }
}
