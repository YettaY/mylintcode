package leetcode.Medium;
import java.util.*;
/**
 * Created by Administrator on 2016/9/4.
 * Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.

 For example:

 Given s = "aabb", return ["abba", "baab"].

 Given s = "abc", return [].
 */
public class Palindrome_Permutation_II {
    public List<String> generatePalindromes(String s) {
        List<String> r=new ArrayList<>();
        int[] map=new int[256];
        int odd=0;
        for(char c:s.toCharArray()){
            map[c]++;
            odd=(map[c] & 1)==1?odd+1 : odd-1;
        }
        if(odd >1)
            return r;
        String mid="";
        int len=0;
        for(int i=0;i<map.length;i++){
            if(map[i]>0){
                if((map[i] & 1)==1) {
                    mid = "" + (char)i;
                    map[i]--;
                }
                map[i]/=2;
                len+=map[i];
            }
        }
        dfs(r, map,len,"",mid);
        return r;
    }

    private void dfs(List<String> r, int[] map, int len, String s, String mid) {
        if(s.length()==len){
            StringBuilder sb=new StringBuilder(s).reverse();
            r.add(s+mid+sb);
            return;
        }
        for(int i=0;i<256;i++){
            if(map[i]>0){
                map[i]--;
                dfs(r, map, len, s+(char)i, mid);
                map[i]++;
            }

        }
    }
}
