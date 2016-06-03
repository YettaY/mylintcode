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
            return n1.order-n2.order;
        }
    }

    private Map<Integer,Set<Integer>> friends;
    private Map<Integer,List<Node>> users_tweets;
    private int order;

    public List<Node> getLastTen(List<Node> tmp){
        int last=10;

    }
    public MiniTwitter() {
        // initialize your data structure here.
    }

    // @param user_id an integer
    // @param tweet a string
    // return a tweet
    public Tweet postTweet(int user_id, String tweet_text) {
        //  Write your code here
    }

    // @param user_id an integer
    // return a list of 10 new feeds recently
    // and sort by timeline
    public List<Tweet> getNewsFeed(int user_id) {
        // Write your code here
    }

    // @param user_id an integer
    // return a list of 10 new posts recently
    // and sort by timeline
    public List<Tweet>  getTimeline(int user_id) {
        // Write your code here
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id follows to_user_id
    public void follow(int from_user_id, int to_user_id) {
        // Write your code here
    }

    // @param from_user_id an integer
    // @param to_user_id an integer
    // from user_id unfollows to_user_id
    public void unfollow(int from_user_id, int to_user_id) {
        // Write your code here
    }
}
