package google;

/**
 * Created by Administrator on 2016/9/7.
 The API: int read4(char *buf) reads 4 characters at a time from a file.

 The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

 By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

 Note:
 The read function will only be called once for each test case.
 */
public class Read_N_Characters_Given_Read4 {
    public int read(char[] buf, int n) {
        //Solution  1:
//        boolean isend=false;
//        int p=0;
//        char[] tmp=new char[4];
//        while(!isend && p<n){
//            int c=read4(tmp);
//            isend = c<4;
//            c=Math.min(n-p, c);
//            for(int i=0;i<len;i++)
//                buf[p++]=tmp[i];
//        }
//        return p;

        // Solution 2:
        int p=0, c=0;
        char[] tmp=new char[4];
        while((c=read4(tmp))>0 && p<n){
            for(int i=0;i<c && p<n;i++)
                buf[p++]=tmp[i];
        }
        return p;
    }

    private int read4(char[] tmp) {
        return 4;
    }
}
