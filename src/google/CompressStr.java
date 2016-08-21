package google;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by Administrator on 2016/8/4.
 */
public class CompressStr {
        public static String compress(String s) {
            if (s.length() <= 1)
                return s;

            int len = s.length();
            String compressed = s;
            int maxRepeats = len;
            for (int k = len / 2; k >= 1; k--) { // start from longer repeat.
                int i = 0, j = k; // start pointers
                while (j < len) {
                    while (j < len && s.charAt(i) != s.charAt(j)) {
                        i++;
                        j++;
                    }
                    int p = i, q = j; // end pointers
                    while (q < len && s.charAt(p) == s.charAt(q)) {
                        p++;
                        q++;
                    }

                    if (q - i >= k * 2) { // repeat found
                        int j0 = j;
                        // the loop deals with cases like 'abcabca'
                        while (i < j0 && q - i >= k * 2) {
                            int splitPoint = q - (q - i) % k;
                            String pre = compress(s.substring(0, i));
                            String in = compress(s.substring(i, j));
                            String post = compress(s.substring(splitPoint));

                            int fold = (q - i) / k;
                            // optimization objective to address pattern overlapping.
                            int num = numOfLetters(pre) + numOfLetters(in) + numOfLetters(post);
                            // due to pattern overlapping, cannot early return when the first (i.e. longest) pattern is
                            // found
                            if (num < maxRepeats) {
                                maxRepeats = num;
                                compressed = pre + fold + '[' + in + ']' + post;
                            }
                            i++; // proceed to the next same-length pattern in this region
                            j++;
                        }
                        return compressed; // same-length pattern in other regions will be addressed by the recursion
                    } else {
                        i = p;
                        j = q;
                    }
                }
            }

            return compressed;
        }

        private static int numOfLetters(String s) {
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                if (Character.isLetter(s.charAt(i))) {
                    sum++;
                }
            }
            return sum;
        }

        public static void main(String[] args) {

            System.out.println(compress("abcabcabcd")); // 3[abc]d
            System.out.println(compress("2aaam1tvmtvmac")); // 3[a]2[mtv]ac
            System.out.println(compress("aaacaaca")); //
            System.out.println(compress("bababaacaaca"));
            System.out.println(compress("aabcabca"));
        }
}
