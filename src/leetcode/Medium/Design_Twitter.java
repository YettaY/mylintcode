package leetcode.Medium;
import java.util.*;
/**
 * Created by Administrator on 2016/8/22.
 */
public class Design_Twitter {
    public class Twitter {
        class tweet{
            int tid,time;
            public tweet(int tid, int time){
                this.tid=tid;
                this.time=time;
            }
        }
        Map<Integer, Set<Integer>> friends;
        Map<Integer, List<tweet>> tweets;
        int order;
        /** Initialize your data structure here. */
        public Twitter() {
            friends=new HashMap<Integer,Set<Integer>>();
            tweets=new HashMap<Integer, List<tweet>>();
            order=0;
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            if(!tweets.containsKey(userId)){
                tweets.put(userId,new ArrayList<tweet>());
                follow(userId,userId);
            }
            tweets.get(userId).add(0,new tweet(tweetId,order++));
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            Queue<tweet> q=new PriorityQueue<tweet>(10,new Comparator<tweet>(){
                public int compare(tweet a, tweet b){
                    return a.time-b.time;
                }
            });

            Set<Integer> f=friends.get(userId);
            if(f!=null){
                for(int fid:f){
                    List<tweet> t=tweets.get(fid);
                    if(t!=null){
                        for(tweet tw:t){
                            if(q.size()<10)
                                q.offer(tw);
                            else{
                                if(tw.time <= q.peek().time)
                                    break;
                                q.offer(tw);
                                q.poll();
                            }
                        }
                    }
                }
            }
            List<Integer> r=new ArrayList<Integer>();
            while(!q.isEmpty())
                r.add(0,q.poll().tid);
            return r;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if(!friends.containsKey(followerId))
                friends.put(followerId,new HashSet<Integer>());
            friends.get(followerId).add(followeeId);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if(followerId==followeeId || !friends.containsKey(followeeId))
                return;
            if(friends.containsKey(followerId))
                friends.get(followerId).remove(followeeId);
        }
    }
}
