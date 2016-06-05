import java.util.*;

/**
 * Created by Administrator on 2016/6/5.
 */
public class s488 {
    public boolean isHappy(int n) {
        // Write your code here
        if (n<=0)
            return false;
        if (n==1)
            return true;
        Set<Integer> set=new HashSet<>();
        int sum=0;

        while(true){
            sum+=(n%10)*(n%10);
            n/=10;
            if(n==0){
                if (sum==1)
                    return true;
                if (sum>=Integer.MAX_VALUE || set.contains(sum))
                    break;
                set.add(sum);
                n=sum;
                sum=0;
            }
        }
        return false;
    }
}
