package indeed;

import java.util.*;
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0;
        n = in.nextInt();

        int p[] = new int[n];
        for(int i = 0; i < n; i++)
            p[i] = in.nextInt();

        boolean flag[] = new boolean[n];
        int cur=0,r=0;
        while(cur != n){
            for(int i = 0; i < n; i++){
                if(!flag[i]){
                    int num = p[i];
                    int curi = i;
                    while(!flag[curi]){
                        num = p[curi];
                        cur++;
                        flag[curi] = true;
                        curi = num - 1;
                    }
                    r++;
                }
            }
        }
        System.out.println(r);
    }
}