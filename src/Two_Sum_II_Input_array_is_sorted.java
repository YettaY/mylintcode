/**
 * Created by Administrator on 2016/9/7.
 */
public class Two_Sum_II_Input_array_is_sorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] r=new int[2];
        int i=0, j=numbers.length-1;
        while(i<j){
            if(2*numbers[i]>target)
                break;
            int sum=numbers[i]+numbers[j];
            if(sum==target){
                r[0]=i+1;
                r[1]=j+1;
                return r;
            }
            else if(sum<target)
                i++;
            else
                j--;
        }
        return r;
    }
}
