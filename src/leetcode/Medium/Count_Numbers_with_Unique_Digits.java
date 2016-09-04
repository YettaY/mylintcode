package leetcode.Medium;

/**
 * This is a digit combination problem. Can be solved in at most 10 loops.
 When n == 0, return 1. I got this answer from the test case.
 When n == 1, _ can put 10 digit in the only position. [0, ... , 10]. Answer is 10.
 When n == 2, _ _ first digit has 9 choices [1, ..., 9], second one has 9 choices excluding the already chosen one. So totally 9 * 9 = 81. answer should be 10 + 81 = 91
 When n == 3, _ _ _ total choice is 9 * 9 * 8 = 684. answer is 10 + 81 + 648 = 739
 When n == 4, _ _ _ _ total choice is 9 * 9 * 8 * 7.
 ...
 When n == 10, _ _ _ _ _ _ _ _ _ _ total choice is 9 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1
 When n == 11, _ _ _ _ _ _ _ _ _ _ _ total choice is 9 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1 * 0 = 0
 */
public class Count_Numbers_with_Unique_Digits {
    public int countNumbersWithUniqueDigits(int n) {
        //Solution 1:
//        if(n==0)
//            return 1;
//        int base=9, ans=10;
//        for (int i=2;i<=n && i<=10;i++){
//            base *= (9-i+2);
//            ans+=base;
//        }
//        return ans;

        //Solution 2:
        /*The idea is to append one digit at a time recursively (only append digits that has not been appended before).
        Number zero is a special case, because we don't want to deal with the leading zero, so it is counted separately at the beginning of the program.
        The running time for this program is O(10!) worst case, or O(n!) if n < 10.*/
        return dfs(new boolean[10], n, 0);
    }
    public int dfs(boolean[] v,int n,int d){
        if (d==n)
            return 1;
        int r=1;
        for (int i=(d==0)?1:0;i<=9;i++){
            if (!v[i]){
                v[i]=true;
                r+=dfs(v,n,d+1);
                v[i]=false;
            }
        }
        return r;
    }
}
