import java.util.*;

/**
 * Created by Administrator on 2016/5/25.
 */
interface NestedInteger {
    public boolean isInteger();
    public Integer getInteger();
    public List<NestedInteger> getList();
}
public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack=new Stack<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i=nestedList.size()-1;i>=0;i--)
            stack.push(nestedList.get(i));
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()){
            NestedInteger cur= stack.peek();
            if (cur.isInteger())
                return true;
            stack.pop();
            for (int i=cur.getList().size()-1;i>=0;i--)
                stack.push(cur.getList().get(i));
        }
        return false;
    }

    @Override
    public void remove() {}
}