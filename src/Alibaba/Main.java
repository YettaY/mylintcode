package Alibaba;
import java.util.*;
/**
 * Created by yanglu on 16/9/9.
 */
public class Main {
    static Map<Integer,int[]> map=new HashMap<>();
    static int handle=1;
    static boolean[] mem;
    public static boolean find( int size, int max){
        boolean f=false;
        for(int i=0;i<max;i++){
            int j=i;
            for(;j<max && j<i+size;j++){
                if(mem[j])
                    break;
            }
            if (j>=i+size){
                map.put(handle, new int[]{i, i+size-1});
                for(int k=i;k<i+size;k++)
                    mem[k]=true;
                f=true;
                break;
            }
        }
        return f;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s1=in.nextLine();
        String[] s11=s1.split(" ");
        int t=Integer.valueOf(s11[0]), max=Integer.valueOf(s11[1]);
        mem=new boolean[max];

        for(int id=0;id<t;id++){
            String s=in.nextLine();
            String[] ss=s.split(" ");
            if(ss[0].equals("new")){
                int size=Integer.valueOf(ss[1]);
                if(find(size, max))
                    System.out.println(handle++);
                else
                    System.out.println("NULL");
                //for(int i=0;i<max;i++)
                 //   System.out.println(mem[i]+" ");
            }
            else if(ss[0].equals("del")){
                int cur=Integer.valueOf(ss[1]);
                if(!map.containsKey(cur) || map.get(cur)==null)
                    System.out.println("ILLEGAL_OPERATION");
                else{
                    int start=map.get(cur)[0], end=map.get(cur)[1];
                  //  System.out.println(start+"  "+end);
                    for(int i=start;i<=end;i++)
                        mem[i]=false;

                }
            }
            else{
                int high=0, cnt=0;
                for(int i=0;i<max;i++){
                    if(mem[i]){
                        high=i;
                        cnt++;
                        mem[i]=false;
                    }
                }
                for(int i=max-1;i>=max-cnt;i--)
                    mem[i]=true;
                for(int i=0;i<max;i++)
                   System.out.println(mem[i]+" ");
            }
        }
    }
}
