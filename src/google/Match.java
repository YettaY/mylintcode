package google;

/**
 * 有n(n=2^k)个player，排名1到n，每次对阵会让最好的对阵最差的，每轮对阵淘汰一半的人，要求打印出对阵情况。
 * 例如有8个player，对阵情况就是(((1,8),(4,5)), ((2, 7), (3, 6)))，要求就是打出这么一个字符串。
 */
public class Match {
    public static String match(String t1, String t2){
        return  "(" + t1 + "," + t2 + ")";
    }
    public static void main(String[] args){
        int n=8;
        String[] team=new String[n];
        for(int i = 0; i < n; i++){
            team[i] = "" + (i+1);
        }
        while(n>1){
            for (int i=0;i<n/2;i++)
                team[i]=match(team[i],team[n-i-1]);
            n/=2;
        }
        System.out.println(team[0]);
    }
}
