package leetcode.Medium;

/**
 * Created by yanglu on 16/9/7.
 Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

 The input string does not contain leading or trailing spaces and the words are always separated by a single space.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 Could you do it in-place without allocating extra space?
 */
public class Reverse_Words_in_a_String_II {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);
        int start=0;
        for(int i=0;i<s.length;i++){
            if(s[i]==' '){
                reverse(s, start, i-1);
                start=i+1;
            }
        }
        reverse(s, start, s.length-1);
    }
    public void reverse(char[] s, int start, int end){
        while(start<end){
            char c=s[start];
            s[start]=s[end];
            s[end]=c;
            start++;
            end--;
        }
    }
}
