package youdao;

import java.util.*;

public class Main1
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int id=0;id<t;id++){
            int n=in.nextInt();
            Map<Integer,Integer> map=new HashMap<>();
            for(int i=1;i<=n;i++) {
                map.put(i, i);
            }
            int c=1;
            for(Integer i=2;i<=n;i+=2){
                if(map.get(i)!=c){
                    int v=map.get(i);
                    for(int key:map.keySet()){
                        if(map.get(key)==c)
                            map.put(key,v);
                    }
                    map.put(i,c);
                }
                c++;
            }
            int i=0;
            for(int key:map.keySet()){
                if(i==map.size()-1)
                    System.out.println(map.get(key));
                else
                    System.out.print(map.get(key)+" ");
                i++;
            }
        }
    }
}