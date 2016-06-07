package s132;

import java.util.*;
/**
 * Created by Administrator on 2016/5/13.
 */
class TrieNode{
    Map<Character,TrieNode> children;
    boolean leaf;
    String s;
    public TrieNode(){
        children=new HashMap<Character,TrieNode>();
        leaf=false;
        s="";
    }
}
class tree{
    TrieNode root;
    public tree(){
        root=new TrieNode();
    }
    public void insert(String w){
        TrieNode cur=root;
        for(int i=0;i<w.length();i++){
            if (!cur.children.containsKey(w.charAt(i)))
                cur.children.put(w.charAt(i),new TrieNode());
            cur=cur.children.get(w.charAt(i));
        }
        cur.leaf=true;
        cur.s=w;
    }
    public boolean search(String w){
        TrieNode cur=root;
        for (int i=0;i<w.length();i++){
            if (!cur.children.containsKey(w.charAt(i)))
                return false;
            cur=cur.children.get(w.charAt(i));
        }
        return cur.leaf;
    }
}
public class Solution {
    public static ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        ArrayList<String> r=new ArrayList<>();
        if (board==null || board.length==0 || words==null || words.size()==0)
            return r;
        tree t=new tree();
        for (String w:words)
            t.insert(w);
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                dfs(board,i,j,t.root,r);
            }
        }
        return r;
    }
    public static void dfs(char[][] b,int x,int y, TrieNode root, ArrayList<String> r){
        if (root.leaf)
            if (!r.contains(root.s))
                r.add(root.s);
        if (x<0|| x>=b.length|| y<0|| y>=b[0].length)
            return;
        if (root.children.containsKey(b[x][y])) {
            char c = b[x][y];
            b[x][y] = 0;
            dfs(b, x + 1, y, root.children.get(c), r);
            dfs(b, x - 1, y, root.children.get(c), r);
            dfs(b, x, y + 1, root.children.get(c), r);
            dfs(b, x, y - 1, root.children.get(c), r);
            b[x][y] = c;
        }
    }
    public static void main (String[] args){
        char[][] b={{'d','o','a','f'},{'a','g','a','i'},{'d','c','a','n'}};
        ArrayList<String> w=new ArrayList<String>();
        String[] words={"dog","dad","dgdg","can","again"};
        for (String s:words)
            w.add(s);
        System.out.println(wordSearchII(b,w));
    }
}
