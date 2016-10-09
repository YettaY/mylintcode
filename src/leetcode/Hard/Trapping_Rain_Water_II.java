package leetcode.Hard;
import java.util.*;
/**
 * Created by yanglu on 16/9/27.
 */
public class Trapping_Rain_Water_II {
    class node{
        int x,y,h;
        public node(int x, int y, int h){
            this.x=x;
            this.y=y;
            this.h=h;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        if(heightMap==null || heightMap.length==0)
            return 0;
        Queue<node> q=new PriorityQueue<node>(new Comparator<node>() {
            @Override
            public int compare(node o1, node o2) {
                return o1.h-o2.h;
            }
        });
        int n=heightMap.length, m=heightMap[0].length;
        boolean[][] v=new boolean[n][m];
        for(int i=0;i<m;i++){
            v[0][i]=true;
            v[n-1][i]=true;
            q.offer(new node(0, i, heightMap[0][i]));
            q.offer(new node(n-1, i, heightMap[n-1][i]));
        }
        for(int i=0;i<n;i++){
            v[i][0]=true;
            v[i][m-1]=true;
            q.offer(new node(i, 0, heightMap[i][0]));
            q.offer(new node(i, m-1, heightMap[i][m-1]));
        }
        int r=0;
        int[][] d={{1,0}, {-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            node cur=q.poll();
            for(int i=0;i<d.length;i++){
                int x=cur.x+d[i][0], y=cur.y+d[i][1];
                if(x>=0 && x<n && y>=0 && y<m && !v[x][y]){
                    v[x][y]=true;
                    r+=Math.max(0, cur.h-heightMap[x][y]);
                    q.offer(new node(x,y,Math.max(heightMap[x][y], cur.h)));
                }
            }
        }
        return r;
    }
}
