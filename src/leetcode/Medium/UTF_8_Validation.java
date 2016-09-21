package leetcode.Medium;

/**
 * Created by Administrator on 2016/9/20.
 *  0xxxxxxx, 1 byte, 128(10000000)
 *  110xxxxx, 2 bytes, 224(11100000), 192(11000000)
 *  1110xxxx, 3 bytes, 240(11110000), 224(11100000)
 *  11110xxx, 4 bytes, 248(11111000), 240(11110000)

 n >= 240 means at least 11110000 (next 3 number will at least 128) (bitCount = 3)
 224> n > 192 means at least 11000000 (next 1 number will at least 128) (bitCount = 2)
 240> n >= 224 mens at least 111000000 (next 2 number will at least 128) (bitCount = 1)

 if(any bitCount < 0)
 */
public class UTF_8_Validation {
    public boolean validUtf8(int[] data) {
        int head=0;
        for(int n:data){
            if(n>=192){
                if(head!=0)
                    return false;
                else if(n>=240)
                    head=3;
                else if(n>=224)
                    head=2;
                else
                    head=1;
            }
            else if(n>=128){
                head--;
                if(head<0)
                    return false;
            }
            else if(head>0)
                return false;
        }
        return head==0;
    }
}
