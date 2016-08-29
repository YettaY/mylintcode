package leetcode.Easy;

/**
 * Created by Administrator on 2016/8/28.
 */
public class Power_of_Three {
    public boolean isPowerOfThree(int n) {
        // 1162261467=3^19. 3^20 is bigger than int.
        return n > 0 && 1162261467 % n == 0;
    }
}
