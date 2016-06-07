/**
 * Created by Administrator on 2016/6/3.
 */
import java.util.*;
class Tweet {
     public int id;
     public int user_id;
     public String text;
     public static Tweet create(int user_id, String tweet_text) {
         // This will create a new tweet object,
         // and auto fill id
         return null;
     }
}
public class MiniTwitter {
    class Node{
        public int order;
        public Tweet tweet;
        public Node(int o,Tweet t){
            this.order=o;
            this.tweet=t;
        }
    }
    class SortByOrder implements Comparator{
        public int compare(Object o1, Object o2) {
            Node n1=(Node)o1, n2=(Node)o2;
            return n2.order-n1.order;
        }
    }

    private Map<Integer,Set<Integer>> friends;
    private Map<Integer,List<Node>> users_tweets;
    private int order;

    public List<Node> getLastTen(List<Node> tmp){
        int last=10;
        if (tmp.size()<10)
            last=tmp.size();
        return tmp.subList(tmp.size()-last,tmp.size());

    }
    public List<Node> getFistTen(List<Node> tmp){
        int first=10;
        if (tmp.size()<10)
            first=tmp.size();
        return tmp.subList(0,first);

    }
    public MiniTwitter() {
        // initialize your data structure here.
        this.friends=new HashMap<Integer,Set<Integer>>();
        this.users_tweets=new HashMap<Integer,List<Node>>();
        this.order=0;
    }

    // @param user_id an integer
    // @param tweet a string
    // return a tweet
    public Tweet postTweet(int user_id, String tweet_text) {
        //  Write your code here
        Tweet tweet =Tweet.create(user_id,tweet_text);
        if (!users_tweets.containsKey(user_id))
            users_tweets.put(user_id, new ArrayList<Node>());
        order+=1;
        users_tweets.get(user_id).add(new Node(order,tweet));
        return tweet;
    }

    // @param user_id an integer
    // return a list of 10 new feeds recently
    // and sort by timeline
    public List<Tweet> getNewsFeed(int user_id) {
        // Write your code here
        List<Node> tmp=new ArrayList<>();
        if (users_tweets.containsKey(user_id))
            tmp.addAll(getLastTen(users_tweets.get(user_id)));
        if (friends.containsKey(user_id)){
            for(int user:friends.get(user_id)){
                if (users_tweets.containsKey(user))
                    tmp.addAll(getLastTen(users_tweets.get(user)));
            }
        }
        Collections.sort(tmp,new SortByOrder());
        List<Tweet> r=new ArrayList<Tweet>();
        tmp=getFistTen(tmp);
        for (Node node:tmp)
            r.add(node.tweet);
        return r;
    }

    // @param user_id an integer
    // return a list of 10 new posts recently
    // and sort by timeline
    public List<Tweet>  getTimeline(int user_id) {
        // Write your code here
        List<Node> tmp=new ArrayList<Node>();
        if (users_tweets.containsKey(user_id))
            tmp.addAll(getLastTen(users_tweets.get(user_id)));
        Collections.sort(tmp,new SortByOrder());
        List<Tweet> r=new ArrayList<>();
        tmp=getFistTen(tmp);
        for (Node node:tmp)
            r.add(node.tweet);
        return r;
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id follows to_user_id
    public void follow(int from_user_id, int to_user_id) {
        // Write your code here
        if (!friends.containsKey(from_user_id))
            friends.put(from_user_id,new HashSet<Integer>());
        friends.get(from_user_id).add(to_user_id);
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id unfollows to_user_id
    public void unfollow(int from_user_id, int to_user_id) {
        // Write your code here
        if (friends.containsKey(from_user_id))
            friends.get(from_user_id).remove(to_user_id);
    }
}