package leetcode.Easy;

/**
 * Created by yanglu on 16/9/14.
 */
public class Implement_strStr {
    public static int strStr(String haystack, String needle) {
        //Solution 1:
//        if(haystack==null || needle==null || needle.length()==0)
//            return 0;
//        for(int i=0;i<haystack.length()-needle.length()+1;i++){
//            int j=0;
//            for(j=0;j<needle.length();j++){
//                if(haystack.charAt(i+j)!=needle.charAt(j))
//                    break;
//            }
//            if(j==needle.length())
//                return i;
//        }
//        return -1;

        //Solution 2:
//        if(haystack==null || needle==null || needle.length()==0)
//            return 0;
//        //求next数组next[j]=k,0<=k<j;
//        int[] next=new int[needle.length()];
//        int j=-1,i=0; next[0]=-1;
//        while(i<needle.length()-1){
//            if(j==-1||needle.charAt(j)==needle.charAt(i)){
//                i++;j++;
//                next[i]=j;
//            }
//            else
//                j=next[j];
//        }
//    	for(int p=0;p<next.length;p++)
//    		System.out.print(next[p]+" ");
//        System.out.println();
//        //KMP匹配
//        j=0;i=0;
//        while(i<haystack.length() && j<needle.length()){
//            if(j==-1||haystack.charAt(i)==needle.charAt(j)){
//                i++;j++;
//            }
//            else {
//                j = next[j];
//                System.out.println(i+" "+j);
//            }
//        }
//        if(j==needle.length())
//            return i-j;
//        return -1;
        if(haystack==null || needle==null || needle.length()==0)
            return 0;
        int[] next=new int[haystack.length()];
        next[0]=0;
        for(int i=1,k=0;i<haystack.length();i++){
            while(k>0 && haystack.charAt(i)!=haystack.charAt(k))
                k=next[k-1];
            if(haystack.charAt(i)==haystack.charAt(k))
                k++;
            next[i]=k;
        }
        int i=0,j=0,len=0;
        for(;j<needle.length();j++){
            if(i==haystack.length())
                return -1;
            else if(haystack.charAt(i)==needle.charAt(j)){
                len++;
                i++;
            }
            else if(i>0 && haystack.charAt(i)!=needle.charAt(j)){
                i +=len-next[i];
                if(i==0)
                    i++;
                len=0;
                j=0;
            }

        }
        return i-needle.length();

    }
    public static void main(String[] args){
        String s="BBC ABCDAB ABCDABCDABDE", t="ABCDABD";
        System.out.println(strStr(s,t));
    }

}
