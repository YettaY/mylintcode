package leetcode.Hard;
import java.util.*;

/**
 * Created by Administrator on 2016/7/5.
 */

public class Twitter {
    /** Initialize your data structure here. */
    class Tweet {
        int tweet_id;
        int timestamp;
        public Tweet(int tid, int time) {
            this.tweet_id=tid;
            this.timestamp=time;
        }
    }

    private Map<Integer,Set<Integer>> followees;
    private Map<Integer,List<Tweet>> tweets;
    private int order;


    public Twitter() {
        this.followees=new HashMap<Integer,Set<Integer>>();
        this.tweets=new HashMap<Integer,List<Tweet>>();
        this.order=0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<Tweet>());
            follow(userId,userId);//follow itself
        }
        tweets.get(userId).add(0,new Tweet(tweetId, order++));//add new tweet on the first place
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        //min heap that the earliest tweet is on the top
        PriorityQueue<Tweet> q=new PriorityQueue<Tweet>(1, new Comparator<Tweet>(){
            public int compare(Tweet o1, Tweet o2) {
                return o1.timestamp-o2.timestamp;
            }
        });

        Set<Integer> friends = followees.get(userId);
        if (friends!=null){
            for(int fid:friends){
                List<Tweet> ftweets=tweets.get(fid);
                if (ftweets!=null) {
                    for (Tweet t:ftweets){
                        if (q.size() < 10)
                            q.add(t);
                        else{
                            if(t.timestamp <=q.peek().timestamp)
                                break;
                            q.add(t);
                            q.poll();//remove the oldest tweet
                        }
                    }
                }
            }
        }
        List<Integer> r=new ArrayList<>();
        while(!q.isEmpty())
            r.add(0, q.poll().tweet_id);
        return r;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!followees.containsKey(followerId))
            followees.put(followerId,new HashSet<Integer>());
        followees.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!followees.containsKey(followeeId) || followeeId==followerId)
            return;
        if (followees.containsKey(followerId))
            followees.get(followerId).remove(followeeId);
    }
}
