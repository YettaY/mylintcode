package TreeArray;

public class NumArray {
	public int[] nums;
	public int[] c;
    public NumArray(int[] nums) {
        this.nums=nums;
        c=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
        	int j=i+1;
        	while(j<=nums.length){
        		c[j]+=nums[i];
        		j+=(j&(-j));
        	}
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={1,2,3,4,5,6,7,8};
		NumArray n=new NumArray(nums);
		
	}

}
