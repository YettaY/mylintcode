package s473;

/**
 * Created by Administrator on 2016/5/11.
 */
import java.util.*;
class trie{
    Map<Character, trie> children;
    boolean leaf;
    public trie(){
        children=new HashMap<Character,trie>();
        leaf=false;
    }

}
public class Solution {
    // Adds a word into the data structure.
    public trie root=new trie();
    public void addWord(String word) {
        trie cur=root;
        for(int i=0;i<word.length();i++){
            if(!cur.children.containsKey(word.charAt(i)))
                cur.children.put(word.charAt(i),new trie());
            cur=cur.children.get(word.charAt(i));
        }
        cur.leaf=true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return dfs(word, root);
    }
    public boolean dfs(String w, trie tn){
        for (int i=0;i<w.length();i++){
            char c=w.charAt(i);
            if (c == '.') {
                for (trie v:tn.children.values())
                    if (dfs(w.substring(i+1), v))
                        return true;
                return false;
            }
            else{
                if (!tn.children.containsKey(w.charAt(i)))
                    return false;
                tn=tn.children.get(w.charAt(i));
            }
        }
        return tn.leaf;
    }
}
