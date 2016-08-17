package leetcode.Medium;
import java.util.*;
/**
 * Created by yanglu on 16/8/15.
 * [1,[4,[6,[[[]]]]]]这个测试用例 只有solution1能过
 * 1.先检查最大深度，再计算。
 * 2.这个方法用了两个变量pre和total，初始化均为0，
 * 然后如果nestedList不为空开始循环，先声明队列q，遍历nestedList中的元素，
 * 如果是数字，则pre加上这个数字，如果是数组，就加入q，这样遍历完成后，第一层的数字和保存在pre中了，
 * 其余元素都存入了q中，此时我们将pre加到total中，再进入下一层计算，由于上一层的值还在pre中，
 * 所以第二层计算完将pre加入total中时，相当于第一层的数字和被加了两次
 */
public class Nested_List_Weight_Sum_II {
    public int max=0,sum=0;
    public int maxdepth(List<NestedInteger> nestedList,int depth){
        int r=0;
        for(NestedInteger n:nestedList){
            if(n!=null) {
                if(!n.isInteger())
                    r = Math.max(maxdepth(n.getList(), depth + 1), r);
                else
                    r=Math.max(r,depth+1);
            }
        }
        max=Math.max(max,r);
        return r;
    }
    public void getsum(List<NestedInteger> nestedList,int cur){
        for(NestedInteger n:nestedList){
            if(n!=null) {
                if (n.isInteger())
                    sum += n.getInteger() * (max-cur);
                else
                    getsum(n.getList(), cur + 1);
            }
        }
    }

    public int depthSumInverse(List<NestedInteger> nestedList) {
        //Solution 1:
//        if(nestedList==null || nestedList.size()==0)
//            return 0;
//        maxdepth(nestedList,0);
//        getsum(nestedList,0);
//        return sum;

        //Solution 2:
//        if(nestedList==null || nestedList.size()==0)
//            return 0;
//        Queue<NestedInteger> q=new LinkedList<>();
//        for(NestedInteger n:nestedList)
//            q.offer(n);
//        int pre=0, total=0;
//        while(!q.isEmpty()){
//            int size=q.size();
//            int t=0;
//            for(int i=0;i<size;i++){
//                NestedInteger cur=q.poll();
//                if(cur.isInteger())
//                    t += cur.getInteger();
//                List<NestedInteger> list=cur.getList();
//                if(list!=null){
//                    for(NestedInteger n:list)
//                        if(n!=null)
//                            q.offer(n);
//                }
//            }
//            pre+=t;
//            total+=pre;
//        }
//        return total;

        //Solution 3:
        int pre=0,total=0;
        while(!nestedList.isEmpty()){
            List<NestedInteger> list=new ArrayList<>();
            for(NestedInteger n:nestedList){
                if(n.isInteger())
                    pre+=n.getInteger();
                else
                    list.addAll(n.getList());
            }
            total+=pre;
            nestedList=list;
        }
        return total;
    }
}
