package leetcode.Hard;

/**
 * Created by yanglu on 16/8/7.
 * he API: int read4(char *buf) reads 4 characters at a time from a file.

 The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

 By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

 Note:
 The read function may be called multiple times.

 I used buffer pointer (buffPtr) and buffer Counter (buffCnt) to store the data received in previous calls.
 In the while loop, if buffPtr reaches current buffCnt, it will be set as zero to be ready to read new data.
 */
public class Read_N_Characters_Given_Read4_II_Call_multiple_times {
//    private int buffPtr = 0;
//    private int buffCnt = 0;
//    private char[] buff = new char[4];
//    public int read(char[] buf, int n) {
//        int ptr = 0;
//        while (ptr < n) {
//            if (buffPtr == 0) {
//                buffCnt = read4(buff);
//            }
//            while (ptr < n && buffPtr < buffCnt) {
//                buf[ptr++] = buff[buffPtr++];
//            }
//            // all chars in buff used up, set pointer to 0
//            if (buffPtr == buffCnt) buffPtr = 0;
//            // read4 returns less than 4, end of file
//            if (buffCnt < 4) break;
//        }
//        return ptr;
//    }

}
