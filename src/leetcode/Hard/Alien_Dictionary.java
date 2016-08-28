package leetcode.Hard;
import google.Array;

import java.util.*;

/**
 * Created by yanglu on 16/8/7.
 here is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.
 For example,
 Given the following words in dictionary,
 [
 "wrt",
 "wrf",
 "er",
 "ett",
 "rftt"
 ]
 The correct order is: "wertf".

 This problem is very basic. There are only two steps:

 1. Build Graph
 Init indegree[26] for number of links pointing to w[i], adj[26] for neighbors of w[i].
 For each first seeing character w[i] with indegree initially-1, mark it as indegree = 0.
 For each adjacent words w1 and w2, if w1[i] != w2[i], insert w1[i] -> w2[i] into graph. Increase indegree[w2[i]] by 1.

 2. Topological Sort
 Start from queue filled with indegree = 0 characters (lexicographically earliest).
 poll queue, append these 0 indegree guys, and reduce indegree of their neighbors by 1.
 If neighbors reduced to indegree = 0, add them back to queue.
 Peel level by level until queue is empty.
 */
public class Alien_Dictionary {
    public String alienOrder(String[] words) {
        List<Set<Integer>> adj=new ArrayList<>();
        int[] degree=new int[26];
        buildgraph(words,adj,degree);
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<degree.length;i++){
            if(degree[i]==0)
                q.offer(i);
        }
        StringBuilder sb=new StringBuilder();
        while(!q.isEmpty()){
            int i= q.poll();
            sb.append((char)(i+'a'));
            for(int j:adj.get(i)){
                if((--degree[j])==0)
                    q.offer(j);
            }
        }
        for (int d:degree)
            if (d>0)
                return "";
        return sb.toString();
    }
    public void buildgraph(String[] w, List<Set<Integer>> adj, int[] degree){
        for(int i=0;i<26;i++)
            adj.add(new HashSet<>());
        Arrays.fill(degree,-1);
        for(int i=0;i<w.length;i++){
            for(char c:w[i].toCharArray())
                if(degree[c-'a']<0)
                    degree[c-'a']=0;
            if(i>0){
                String w1=w[i-1],w2=w[i];
                int len=Math.min(w1.length(), w2.length());
                for(int j=0;j<len;j++){
                    int c1=w1.charAt(j)-'a', c2=w2.charAt(j)-'a';
                    if(c1!=c2){
                        if(!adj.get(c1).contains(c2)){
                            adj.get(c1).add(c2);
                            degree[c2]++;
                            break;
                        }
                    }
                }
            }
        }
    }


}
