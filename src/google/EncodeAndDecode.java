package google;

/**
 * 题目
实现两个函数 encode() 和 decode() ，分别实现对字符串的变换和复原．
 变换函数 encode() 顺序考察已知字符串的字符，按以下规则逐组生成新字符串 :
 (1) 若已知字符串的当前字符不是 大于0的数字字符 ，则复制该字符于新字符串中；
 (2) 若已知字符串的当前字符是一个数字字符，且它之后没有后继字符，则简单地将它复制到新字符串中；
 (3) 若已知字符串的当前字符是一个 大于0的数字字符 ，并且还有后继字符，设该数字字符的面值为 n ，则将它的后继字符（包括后继字符是一个数字字符）重复复制 n+1 次到新字符串中；
 (4) 以上述一次变换为一组，在不同组之间另插入一个下划线 '_' 用于分隔；
 (5) 若已知字符串中包含有下划线 '_' , 则变换为  ” \ UL ”   。
 复原函数 decode() 做变换函数 encode() 的相反的工作．按照上述规则逆运算，变回原来的字符串。
 例如： encode() 函数对字符串 24ab_2t2 的变换结果为  444_aaaaa_a_b_\UL_ttt_t_2
 说明：
 题目的条件一有歧义 ，一种理解是：当前字符是一个小于等于0的数字字符；第二种理解是当前字符是一个除了1-9的任意字符。
 我是基于第二种意思理解进行的解答。
 假设字符为 String str， n = str.length();   当前字符为c = str[i]

 一、进行 encode() 判断的条件：
 c是1-9的数字, 且i<n-1   复制(k+1)次后面的一个字符
 c除1-9，且为 ” _ ”          转换为 ” \Ul ”
 其余                    复制该字符
每个字符译码结束后加一个下划线 ” _ ”
 二、进行 decode() 判断的条件：
 根据规则4，用先将str用 str .split( "_" ); 分成 n 个 String 数组 strs[].
 n = strs.lenth        k = strs[i].length()
 A、 k==1,   将该字符原样复原
 B、 k>1,   strs[i] ==  ” \Ul ” ,  转换为 ” _ ”
 strs[i] !=  ” \Ul ” ,  转换为k( k = strs[i].length()-1 )
 */
public class EncodeAndDecode {
    public String encode(String str) throws StringLenException{
        StringBuilder sb = new StringBuilder();
        if(null == str) {
            throw new StringLenException("字符串末初始化！");
        }
        int n = str.length();
        if(n <=0) {
            throw new StringLenException("字符串不能为空！");
        }
        char c = 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            // 获得当前字符
            c = str.charAt(i);
            if (c >= '1' && c <= '9' && i != n-1) {	 // c是1-9的数字, 且i<n-1   复制(k+1)次后面的一个字符
                k = c -'0' + 1;
                for(int j=0; j<k; j++) {
                    sb.append(str.charAt(i+1));
                }
            } else if (c == '_') {					 // c除1-9，且为”_” 　　        转换为”\Ul”
                sb.append("\\UL");
            }else{									 //其余 　　                                      复制该字符
                sb.append(c);
            }
            sb.append("_");
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    /**
     * 解码
     *
     * @param str
     *            要解码的字符串
     * @return 解码后的字符串
     */
    public String decode(String str) {
        StringBuilder sb = new StringBuilder();
        if(null == str) {
            throw new StringLenException("字符串末初始化！");
        }
        if(sb.length() <=0) {
            throw new StringLenException("字符串不能为空！");
        }
        String strs[] = str.split("_");
        char c = 0;
        int k = 0;
        int n = strs.length;
        if(n == 1) {
            sb.append(str);
        } else {
            for(int i=0; i<n; i++) {
                k = strs[i].length();
                c = strs[i].charAt(0);
                if(1 ==k) {				//　　k==1,  将该字符原样复原
                    sb.append(c);
                } else {				//　　k>1,
                    if(strs[i].equals("\\UL")) {//strs[i] == ”\Ul”,  转换为”_”
                        sb.append("_");
                    } else {					// strs[i] != ”\Ul”,  转换为k(k = strs[i].length()-1)
                        sb.append(k-1);
                    }
                }
            }
        }
        return sb.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String s = "24ab_2t2";
//		String s = "04ab_2t2";
//		String s = "1a0b_2t2";
//		String s = "aaab_2t2";
//		String s = "24ab_2335t2";
//		String s = "240ab_";
    /*EncodeAndDecode encode = new EncodeAndDecode();
    String s1 = encode.encode(s);
    System.out.println("encode:" + s1);
    String s2 = encode.decode(s1);
    System.out.println("decode:" + s2);
    */
    }
    public class StringLenException extends RuntimeException {

        public StringLenException() {
            super();
        }


        public StringLenException(String message) {
            super(message);
        }

    }
}
