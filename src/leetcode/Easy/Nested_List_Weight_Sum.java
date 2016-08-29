package leetcode.Easy;
import java.util.*;

/**
 * Created by yanglu on 16/8/27.
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
public class Nested_List_Weight_Sum {
    //Solution 1: dfs
//    int sum=0;
//    public void getsum(List<NestedInteger> nestedList, int depth) {
//        for(NestedInteger n: nestedList){
//            if(n!=null){
//                if (n.isInteger())
//                    sum += n.getInteger() * depth;
//                else
//                    getsum(n.getList(), depth+1);
//            }
//        }
//    }
//    public int depthSum(List<NestedInteger> nestedList) {
//        if(nestedList==null || nestedList.size()==0)
//            return 0;
//        getsum(nestedList, 1);
//        return sum;
//    }

    // Solution 2: bfs
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList==null || nestedList.size()==0)
            return 0;
        int sum=0, level=1;
        while(nestedList.size()>0){
            List<NestedInteger> next=new ArrayList<>();
            for(NestedInteger n: nestedList){
                if(n.isInteger())
                  sum += n.getInteger() * level;
                else
                    next.addAll(n.getList());
            }
            level++;
            nestedList=next;
        }
        return sum;
    }
}
