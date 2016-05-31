/**
 * Created by Administrator on 2016/5/25.
 */
public class s524 {
    /**
     * @param originalStr the string we want to append to with spaces
     * @param size the target length of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size) {
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<size-originalStr.length();i++)
            sb.append(" ");
        sb.append(originalStr);
        return sb.toString();
    }

    /**
     * @param originalStr the string we want to append to
     * @param size the target length of the string
     * @param padChar the character to pad to the left side of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size, char padChar) {
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<size-originalStr.length();i++)
            sb.append(padChar);
        sb.append(originalStr);
        return sb.toString();
    }
}
