package leetcode.Medium;
import java.util.*;
/**
 * Created by Administrator on 2016/9/19.
 *可以借助一个栈来保存当前层的路径, 层数可以利用tab字符的个数来确定, 如果当前行的层数大于栈顶元素并且非文件, 就可以让其进入栈,
 * 否则如果当前行是文件就可以比较大小, 或者如果当前行是目录但是深度小于等于栈顶元素, 就可以将栈顶元素出栈, 直到为空或者小于当前行的深度.
 */
public class Longest_Absolute_File_Path {
    public static int lengthLongestPath(String input) {
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        int max=0;
        String[] ss=input.split("\n");
//        for(String s: ss){
//            System.out.println(s+" "+s.lastIndexOf("\t"));
//        }
        for(String s:input.split("\n")){
            int level=s.lastIndexOf("\t")+1;   // number of "\t"
            while(level + 1 < stack.size())    // find parent
                stack.pop();
            int len=stack.peek()+s.length()-level+1;   // remove "/t", add"/"
            stack.push(len);
            if(s.contains("."))    // check if it is file
                max=Math.max(max, len-1);
        }
        return max;
    }
    public static void main(String[] args){
        String s="dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        System.out.println(lengthLongestPath(s));
    }
}
