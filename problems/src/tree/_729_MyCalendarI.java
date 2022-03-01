package tree;

//https://leetcode.com/problems/my-calendar-i/

public class _729_MyCalendarI {

    public static class MyCalendar {
        public static class Node {
            int begin;
            int end;

            Node left;
            Node right;

            public Node(int begin, int end) {
                this.begin = begin;
                this.end = end;
                left = null;
                right = null;
            }

            public boolean add(int L, int R) {
                if (L >= end) {
                    if (right == null) {
                        right = new Node(L, R);
                        return true;
                    } else {
                        return right.add(L, R);
                    }
                } else if (R <= begin) {
                    if (left == null) {
                        left = new Node(L, R);
                        return true;
                    } else {
                        return left.add(L, R);
                    }
                } else {
                    return false;
                }
            }
        }

        Node root = null;

        public MyCalendar() {
        }

        public boolean book(int start, int end) {
            if (root == null) {
                root = new Node(start, end);
                return true;
            } else {
                return root.add(start, end);
            }
        }
    }
}
