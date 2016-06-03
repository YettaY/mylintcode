//package s442;
//import java.util.*;
///**
// * Created by yanglu on 16/5/12.
// */
//class TrieNode {
//    Map<Character,TrieNode> children;
//    boolean leaf;
//    public TrieNode() {
//        children=new HashMap<Character,TrieNode>();
//        leaf=false;
//    }
//}
//public class Trie {
//    private TrieNode root;
//
//    public Trie() {
//        root = new TrieNode();
//    }
//
//    // Inserts a word into the trie.
//    public void insert(String word) {
//        TrieNode cur=root;
//        for (int i=0;i<word.length();i++){
//            if (!cur.children.containsKey(word.charAt(i)))
//                cur.children.put(word.charAt(i),new TrieNode());
//            cur=cur.children.get(word.charAt(i));
//        }
//        cur.leaf=true;
//    }
//
//    // Returns if the word is in the trie.
//    public boolean search(String word) {
//
//    }
//
//    // Returns if there is any word in the trie
//    // that starts with the given prefix.
//    public boolean startsWith(String prefix) {
//
//    }
//}
