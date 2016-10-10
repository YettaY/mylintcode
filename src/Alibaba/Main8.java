package Alibaba;

/**
 * Created by yanglu on 16/9/28.
 */
import java.util.*;

public class Main8 {
    public static List<List<Integer>> getsquare(List<List<List<Integer>>> cube, int dimension){
        List<List<Integer>> r=new ArrayList<List<Integer>>();
        int ln=cube.size();
        List<Integer> line=new ArrayList<Integer>();
        for(int i=0;i<ln;i++)
            line.add(0);
        for(int i=0;i<ln;i++)
            r.add(line);
        for(int i=0;i<ln;i++){
            for(int j=0;j<ln;j++){
                for(int k=0;k<ln;k++){
                    if(dimension==1)
                        r.get(j).set(k, r.get(j).get(k)+cube.get(i).get(j).get(k));
                    else if(dimension==2)
                        r.get(i).set(k, r.get(i).get(k)+cube.get(i).get(j).get(k));
                    else if(dimension==3)
                        r.get(i).set(j, r.get(i).get(j)+cube.get(i).get(j).get(k));
                }
            }
        }
        return r;
    }
    public static List<Integer> getline(List<List<Integer>> square, int dimension){
        int ln=square.size();
        List<Integer> r=new ArrayList<>();
        for(int i=0;i<ln;i++)
            r.add(0);
        for(int i=0;i<ln;i++){
            for(int j=0;j<ln;j++){
                if(dimension==1)
                    r.set(j, r.get(j)+square.get(i).get(j));
                else
                    r.set(i, r.get(i)+square.get(i).get(j));
            }
        }
        return r;
    }
    public static void dfs(List<Integer> nums, int id, List<Integer> subset, int n, List<List<Integer>> r){
        for(int i=id;i<nums.size();i++){
            subset.add(nums.get(i));
            if(subset.size()==n)
                r.add(subset);
            else
                dfs(nums, i+1, subset, n, r);
            subset.remove(subset.size()-1);
        }
    }
    public static List<List<Integer>> subset(List<Integer> nums, int n){
        List<List<Integer>> r=new ArrayList<List<Integer>>();
        if(nums.size()==0)
            return r;
        List<Integer> subset=new ArrayList<>();
        dfs(nums, 0, subset, n, r);
        return r;
    }
    public static List<Integer> getlocation(List<Integer> bigline, List<List<Integer>> smallline, int p){
        int sn=smallline.size(), bn=bigline.size();
        List<Integer> subset=new ArrayList<>();
        for(int i=0;i<sn;i++){
            for(int j=0;j<bn;j++)
                subset.add(j);
        }
        List<List<Integer>> ids=subset(subset, smallline.size());
        for(int k=0;k<ids.size();k++){
            List<Integer> id=ids.get(k), smallsum=new ArrayList<>();
            for(int t=0;t<bn;t++)
                smallsum.add(0);
            for(int i=0;i<sn;i++){
                for (int j=0;j<smallline.get(i).size();j++){
                    smallsum.set(id.get(i)+j, smallsum.get(id.get(i)+j)+smallline.get(i).get(j));
                }
            }
            int i=0;
            for(i=0;i<bn;i++){
                if(smallsum.get(i)%p!=0)
                    break;
            }
            if(i==bn)
                return id;
        }
        return new ArrayList<>();
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int m=in.nextInt(), n=in.nextInt(), p=in.nextInt();
        List<List<List<Integer>>> bigcube=new ArrayList<List<List<Integer>>>();
        for(int i=0;i<m;i++){
            List<List<Integer>> x=new ArrayList<List<Integer>>();
            for(int j=0;j<m;j++){
                List<Integer> y=new ArrayList<>();
                for(int k=0;k<m;k++)
                    y.add(in.nextInt());
                x.add(y);
            }
            bigcube.add(x);
        }
        List<Integer> l=new ArrayList<>();
        List<List<List<List<Integer>>>> scs=new ArrayList<List<List<List<Integer>>>>();

        for(int i=0;i<n;i++){
            int curl=in.nextInt();
            l.add(curl);
            List<List<List<Integer>>> smallcube=new ArrayList<List<List<Integer>>>();
            for(int a=0;a<curl;a++){
                List<List<Integer>> x=new ArrayList<List<Integer>>();
                for(int b=0;b<curl;b++){
                    List<Integer> y=new ArrayList<>();
                    for(int c=0;c<curl;c++)
                        y.add(in.nextInt());
                    x.add(y);
                }
                smallcube.add(x);
            }
            scs.add(smallcube);
        }
        List<List<Integer>> bigsquare23=getsquare(bigcube, 1);
        List<Integer> bigline3=getline(bigsquare23, 1);
        List<Integer> bigline2=getline(bigsquare23, 2);
        List<List<Integer>> bigsquare12=getsquare(bigcube, 3);
        List<Integer> bigline1=getline(bigsquare12, 2);

        List<List<Integer>> smallline1=new ArrayList<List<Integer>>(), smallline2=new ArrayList<List<Integer>>(),smallline3=new ArrayList<List<Integer>>();
        for(int i=0;i<l.size();i++){
            List<List<Integer>> smallsquare12=getsquare(scs.get(i),3);
            List<Integer> sl1=getline(smallsquare12, 2);
            List<Integer> sl2=getline(smallsquare12, 1);
            List<List<Integer>> smallsquare23=getsquare(scs.get(i),1);
            List<Integer> sl3=getline(smallsquare12, 1);
            smallline1.add(sl1);
            smallline2.add(sl2);
            smallline3.add(sl3);
        }
        List<Integer> loc1=getlocation(bigline1, smallline1, p),loc2=getlocation(bigline2, smallline2, p),loc3=getlocation(bigline3, smallline3, p);
        for(int i=0;i<l.size();i++)
            System.out.println(loc1.get(i)+" "+loc2.get(i)+" "+loc3.get(i));
    }


}