//package util;
//
///**
// * Created by Administrator on 2016/7/7.
// */
//public class Pair<A, B> {
//    private final A first;
//    private final B second;
//
//    public Pair(A first, B second) {
//        this.first = first;
//        this.second = second;
//    }
//
//    public int hashCode() {
//        int hashFirst = this.first != null?this.first.hashCode():0;
//        int hashSecond = this.second != null?this.second.hashCode():0;
//        return (hashFirst + hashSecond) * hashSecond + hashFirst;
//    }
//
//    public boolean equals(Object other) {
//        if(other instanceof Pair) {
//            Pair otherPair = (Pair)other;
//            if((this.first == null && otherPair.first == null || this.first != null && this.first.equals(otherPair.first)) && (this.second == null && otherPair.second == null || this.second != null && this.second.equals(otherPair.second))) {
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    public String toString() {
//        return "(" + this.first + ", " + this.second + ")";
//    }
//
//    public A getFirst() {
//        return this.first;
//    }
//
//    public B getSecond() {
//        return this.second;
//    }
//}
