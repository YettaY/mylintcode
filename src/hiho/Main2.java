package hiho;
import java.util.*;

public class Main2 {
    private static ArrayList<ArrayList<Integer>> r = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        int max = cnt(a);
        if (max * 2 > a.length + 1) {
            System.out.print(-1);
            return ;
        }
        boolean[] v = new boolean[n];
        ArrayList<Integer> l = new ArrayList<>();
        Arrays.sort(a);
        dfs(a, 0, l, v);
        if (r.size() == 0) {
            System.out.print(-1);
            return;
        }
        ArrayList<Integer> ans = r.get(0);
        for (int i = 0; i < ans.size(); ++i) {
            if (i == ans.size() - 1) {
                System.out.print(ans.get(i));
            } else {
                System.out.print(ans.get(i) + " ");
            }
        }
    }
    public static int cnt(int[] a) {
        Arrays.sort(a);
        int count = 1;
        int max = 0;
        for (int i = 0; i < a.length - 1; ++i) {
            if (a[i] == a[i + 1]) {
                count++;
            } else {
                count = 1;
            }
            max = Math.max(max, count);
        }
        return max;
    }
    public static void dfs(int[] a, int lastInt, ArrayList<Integer> l, boolean[] v) {
        if (a.length == l.size() && !r.contains(l)) {
            r.add(new ArrayList<Integer>(l));
        }
        for (int i = 0; i < a.length; ++i) {
            if (r.size() != 0) {
                break;
            }
            if (!v[i] && lastInt != a[i]) {
                l.add(a[i]);
                v[i] = true;
                dfs(a, a[i], l, v);
                v[i] = false;
                l.remove(l.size() - 1);
            } else {
                continue;
            }
        }
    }
}