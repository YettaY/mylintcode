package Alibaba;

/**
 * Created by yanglu on 16/9/22.
 */
import java.util.*;

public class Main4 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int val=in.nextInt();
        int N=in.nextInt();
        Deque<Integer> q=new LinkedList<>();
        while(0!=val/N){
            q.addFirst(val%N);
            val/=N;
        }
        q.addFirst(val%N);
        StringBuilder sb=new StringBuilder();
        while(!q.isEmpty()) {
           // System.out.println(q.poll()+" ");
            if(q.peek()>=0 && q.peek()<=9)
                sb.append(q.poll());
            else
                sb.append((char)(q.poll()-10+'A'));
        }
        System.out.println(sb.toString());
    }


}