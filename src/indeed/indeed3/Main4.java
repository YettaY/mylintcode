package indeed.indeed3;

import java.util.*;

class Pair<L,R> {
    private L l;
    private R r;
    public Pair(L l, R r){
        this.l = l;
        this.r = r;
    }

    public R getther(){
        return r;
    }

}

public class Main4 {
    public static void main(String[] args) {
        Main4 s = new Main4();
        System.out.println(s.fun());
    }
    public long fun() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();
        int[] arr = new int[n+1];
        for (int i = 0; i <= n; i++)
            arr[i] = in.nextInt();
        Stack<Pair<Character, Integer>> s = new Stack<Pair<Character, Integer>>();
        int[] minb = new int[n+1], mina = new int[n+1];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            minb[i] = min;
        }
        min = Integer.MAX_VALUE;
        for (int i = n; i >= 0; i--) {
            if (arr[i] < min) {
                min = arr[i];
            }
            mina[i] = min;
        }
        long r = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '(') {
                s.push(new Pair<Character, Integer>('(', i));
            } else {
                if (s.isEmpty()) {
                    r += minb[i];
                } else {
                    s.pop();
                }
            }
        }
        while (!s.isEmpty())
            r += mina[s.pop().getther() + 1];
        return r;
    }
}