package leetcode.Easy;

import leetcode.Medium.Mini_Parser;

/**
 * Created by Administrator on 2016/9/5.
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

 For example,
 Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Given word1 = “coding”, word2 = “practice”, return 3.
 Given word1 = "makes", word2 = "coding", return 1.

 Note:
 You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class Shortest_Word_Distance {
    public static int shortestDistance(String[] words, String word1, String word2) {
        // Solution 1:
//        int[] n1=new int[words.length], n2=new int[words.length];
//        int i1=0, i2=0;
//        for(int i=0;i<words.length;i++){
//            if(words[i].equals(word1))
//                n1[i1++]=i;
//            if(words[i].equals(word2))
//                n2[i2++]=i;
//        }
//        int min=Integer.MAX_VALUE;
//        int i=0, j=0;
//        while(i<i1 && j<i2){
//            if(n1[i]<n2[j])
//                min= Math.min(n2[j]-n1[i++], min);
//
//            else if (n1[i]>n2[j])
//                min= Math.min(n1[i]-n2[j++], min);
//
//        }
//        return min;

        //Solution 2;
        int id=-1, min=Integer.MAX_VALUE;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(word1) || words[i].equals(word2)){
                if(id != -1 && !words[id].equals(words[i]))
                    min=Math.min(i-id, min);
                id=i;
            }
        }
        return min;
    }
    public static void main(String[] args){
        //题目保证word1和word2不相等
        String[] s={"a","b","a"};
        System.out.println(shortestDistance(s,"a","b"));
    }

}
