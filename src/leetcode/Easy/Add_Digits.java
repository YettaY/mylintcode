package leetcode.Easy;

/**
 * Created by Administrator on 2016/9/4.
 */
public class Add_Digits {
    public int addDigits(int num) {
        //Solution 1:
//        while(num>=10){
//            num=num/10+num%10;
//        }
//        return num;

        //Solution 2: 10为一个周期
        /*
        input: 0 1 2 3 4 ...
        output: 0 1 2 3 4 5 6 7 8 9 1 2 3 4 5 6 7 8 9 1 2 3 ....*/

        return 1+(num-1)%9;
    }
}
