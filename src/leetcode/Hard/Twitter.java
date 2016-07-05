package leetcode.Hard;
import java.util.*;

/**
 * Created by Administrator on 2016/7/5.
 */
class Tweet {
    public int user_id;
    public int tweet_id;
    public Tweet(int user_id, int tweet_id) {
        this.user_id=user_id;
        this.tweet_id=tweet_id;
    }
}
public class Twitter {
    /** Initialize your data structure here. */
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
    private Map<Integer,Set<Integer>> friends;
    private Map<Integer,List<Node>> users_tweets;
    private int order;

    public Twitter() {
        this.friends=new HashMap<Integer,Set<Integer>>();
        this.users_tweets=new HashMap<Integer,List<Node>>();
        this.order=0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet =new Tweet(userId,tweetId);
        if (!users_tweets.containsKey(userId))
            users_tweets.put(userId, new ArrayList<Node>());
        order+=1;
        users_tweets.get(userId).add(new Node(order,tweet));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Node> tmp=new ArrayList<>();
        if (users_tweets.containsKey(userId))
            tmp.addAll(getLastTen(users_tweets.get(userId)));
        if (friends.containsKey(userId)){
            for(int user:friends.get(userId)){
                if (users_tweets.containsKey(user))
                    tmp.addAll(getLastTen(users_tweets.get(user)));
            }
        }
        Collections.sort(tmp,new SortByOrder());
        Set<Integer> set=new HashSet<>();
        List<Integer> r=new ArrayList<Integer>();
        tmp=getFistTen(tmp);
        for (Node node:tmp)
            set.add(node.tweet.tweet_id);
        r.addAll(set);
        return r;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!friends.containsKey(followerId))
            friends.put(followerId,new HashSet<Integer>());
        friends.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (friends.containsKey(followerId))
            friends.get(followerId).remove(followeeId);
    }
}
