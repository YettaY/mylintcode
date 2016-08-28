package leetcode.Medium;
import java.util.*;
/**
 * Created by yanglu on 16/8/15.
 * This approach will just iterate through every char in the string (no recursion).

 If encounters '[', push current NestedInteger to stack and start a new one.
 If encounters ']', end current NestedInteger and pop a NestedInteger from stack to continue.
 If encounters ',', append a new number to curr NestedInteger, if this comma is not right after a brackets.
 Update index l and r, where l shall point to the start of a integer substring, while r shall points to the end+1 of substring.
 */
class NestedInteger {
    private List<NestedInteger> list;
    private Integer integer;

    public NestedInteger(List<NestedInteger> list){
        this.list = list;
    }

    public void add(NestedInteger nestedInteger) {
        if(this.list != null){
            this.list.add(nestedInteger);
        } else {
            this.list = new ArrayList();
            this.list.add(nestedInteger);
        }
    }

    public void setInteger(int num) {
        this.integer = num;
    }

    public NestedInteger(Integer integer){
        this.integer = integer;
    }

    public NestedInteger() {
        this.list = new ArrayList();
    }

    public boolean isInteger() {
        return integer != null;
    }

    public Integer getInteger() {
        return integer;
    }

    public List<NestedInteger> getList() {
        return list;
    }
}
public class Mini_Parser {
    public NestedInteger deserialize(String s) {
        if(s==null || s.length()==0)
            return null;
        if (s.charAt(0)!='[')
            return new NestedInteger(Integer.valueOf(s));
        Stack<NestedInteger> stack=new Stack<>();
        NestedInteger cur=null;
        int l=0;
        for(int r=0;r<s.length();r++){
            if(s.charAt(r)=='['){
                if(cur!=null)
                    stack.push(cur);
                cur=new NestedInteger();
                l=r+1;
            }
            else if(s.charAt(r)==']'){
                String num=s.substring(l,r);
                if(!num.isEmpty())
                    cur.add(new NestedInteger(Integer.valueOf(num)));
                if(!stack.isEmpty()){
                    NestedInteger t=stack.pop();
                    t.add(cur);
                    cur=t;
                }
                l=r+1;
            }
            else if(s.charAt(r)==','){
                if(s.charAt(r-1)!=']') {
                    String num = s.substring(l, r);
                    cur.add(new NestedInteger(Integer.valueOf(num)));
                }
                l=r+1;
            }
        }
        return cur;
    }
}
