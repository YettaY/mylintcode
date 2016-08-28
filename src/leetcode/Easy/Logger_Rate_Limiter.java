package leetcode.Easy;
import java.util.*;
/**
 * Created by yanglu on 16/8/8.
 * Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.

 Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.

 It is possible that several messages arrive roughly at the same time.

 Example:

 Logger logger = new Logger();

 // logging string "foo" at timestamp 1
 logger.shouldPrintMessage(1, "foo"); returns true;

 // logging string "bar" at timestamp 2
 logger.shouldPrintMessage(2,"bar"); returns true;

 // logging string "foo" at timestamp 3
 logger.shouldPrintMessage(3,"foo"); returns false;

 // logging string "bar" at timestamp 8
 logger.shouldPrintMessage(8,"bar"); returns false;

 // logging string "foo" at timestamp 10
 logger.shouldPrintMessage(10,"foo"); returns false;

 // logging string "foo" at timestamp 11
 logger.shouldPrintMessage(11,"foo"); returns true;

 */
public class Logger_Rate_Limiter {
    class Logger {
        //Solution 1:

//        private Map<String, Integer> map;
//
//        /** Initialize your data structure here. */
//        public Logger() {
//            map = new HashMap<>();
//        }
//
//        /** Returns true if the message should be printed in the given timestamp, otherwise returns false. The timestamp is in seconds granularity. */
//        public boolean shouldPrintMessage(int timestamp, String message) {
//            if (map.containsKey(message) && (timestamp - map.get(message)) < 10)
//                return false;
//
//            map.put(message, timestamp);
//            return true;
//        }


        //Solution 2:
        /*A typical (accepted) solution is to keep a hash map of String that maps to the recent time stamp.
         But this way, it needs to keep the record of the entire messages, even when the message is rare.

         Alternatively, I keep a heap to get rid of the old message and set of String to keep the recent messages only.
         This approach would make sense when the number of logs within 10 minutes time window is not too large and when we have lots of different messages.*/

        Queue<Tuple> q;
        Set<String> dict;

        public Logger() {
            q = new ArrayDeque<>();
            dict = new HashSet<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            while (!q.isEmpty() && q.peek().t <= timestamp - 10) {
                Tuple next = q.poll();
                dict.remove(next.msg);
            }
            if (!dict.contains(message)) {
                q.offer(new Tuple(timestamp, message));
                dict.add(message);
                return true;
            }
            return false;
        }
        private class Tuple {
            int t;
            String msg;
            public Tuple(int t, String msg) {
                this.t = t;
                this.msg = msg;
            }
        }


    }
}
