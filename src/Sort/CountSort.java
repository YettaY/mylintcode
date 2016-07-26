package Sort;
//计数排序
public class CountSort {
	public static int[] countSort(int[] a, int range/*数组元素的范围*/){
        int count[] = new int[range];
        for (int i = 0; i < a.length; i++) {
            count[a[i]]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i-1];
        }
        int sortArr[] = new int[a.length];
        for (int i = 0; i < sortArr.length; i++) {
            count[a[i]]--;
            sortArr[count[a[i]]] = a[i];
        }
        return sortArr;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,34,66,90,99,34,56,2,3,47,66,99};
        
        int[] sortArr = countSort(a,100);
        for (int i = 0; i < sortArr.length; i++) {
            System.out.print(sortArr[i]+" ");
        }
	}

}
