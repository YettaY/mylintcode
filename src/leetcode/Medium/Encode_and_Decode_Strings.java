package leetcode.Medium;
import java.util.*;
/**
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
 Machine 1 (sender) has the function:
 string encode(vector<string> strs) {
 // ... your code
 return encoded_string;
 }
 Machine 2 (receiver) has the function:
 vector<string> decode(string s) {
 //... your code
 return strs;
 }

 So Machine 1 does:
 string encoded_string = encode(strs);
 and Machine 2 does:
 vector<string> strs2 = decode(encoded_string);
 strs2 in Machine 2 should be the same as strs in Machine 1.=> Implement the encode and decode methods.
 Note:
 The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized enough to work on any possible characters.
 Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
 Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
 Solution
 For each string in the List<String>, we can calculate the length of it. and add before the string. But it may meet some problem if the string like 123abc, so we can add # after the length and then add the str after the #
 {“abc”，“123”，“d"} -> 3#abc3#1231#d
 */
public class Encode_and_Decode_Strings {
    // Encodes a list of strings to a single string.
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {
        List<String> res = new LinkedList<String>();
        if (null == s || s.length() == 0) {
            return res;
        }
        int start = 0;
        int end = 0;
        while (end < s.length()) {
            if (s.charAt(end) == '#') {
                int length = Integer.valueOf(s.substring(start, end));
                res.add(s.substring(end + 1, end + 1 + length));
                start = end + 1 + length;
                end = start;
            }
            end++;
        }
        return res;
    }

    public static void main(String[] args) {
        EncodeandDecodeStrings encodeandDecodeStrings = new EncodeandDecodeStrings();
        List<String> list = new LinkedList<String>();
        // ["63/Rc","h","BmI3FS~J9#vmk","7uBZ?7*/","24h+X","O "]
        list.add("63/Rc");
        list.add("h");
        list.add("BmI3FS~J9#vmk");
        list.add("7uBZ?7*/");
        list.add("24h+X");
        list.add("0 ");
        String s = encodeandDecodeStrings.encode(list);
        System.out.println(s);
        System.out.println(encodeandDecodeStrings.decode(s));
    }
}
