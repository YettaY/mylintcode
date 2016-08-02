//package leetcode.Easy;
//
///**
// * Created by Administrator on 2016/7/18.
// */
//public class Guess_Number_Higher_or_Lower {
//    public class Solution extends GuessGame {
//        public int guessNumber(int n) {
//            int l=1, h=n;
//            while(l<h){
//                int m=(l+h)/2;
//                if (guess(m)==1)
//                    l=m+1;
//                else
//                    h=m;
//            }
//            return l;
//        }
//    }
//
//    private class GuessGame {
//    }
//}
