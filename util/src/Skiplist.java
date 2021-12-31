import java.util.StringJoiner;

public class Skiplist {
    private static class Node {
        int val;
        int level;
        Node[] next;
        Node back = null;

        int cnt;
        public Node(int val,int level) {
            this.val = val;
            this.level = level;
            this.cnt = 1;
            next = new Node[level + 1];
        }
    }

    private static final int MAX_LEVEL = 16;
    private Node head;
    private int levelCnt;
    private int nodeCnt;

    // duplicates may exist in the Skiplist
    public Skiplist() {
        head = new Node(-1, MAX_LEVEL);
        nodeCnt = 0;
        levelCnt = 1;
    }

    public boolean search(int target) {
        if (isEmpty()) {
            return false;
        }
        Node temp = head;
        // search from levelCnt to level 0 (not from MAX_LEVEL!)
        // stop at the PREVIOUS position before the target node
        for (int i = levelCnt; i >= 0; i--) {
            while (temp.next[i] != null && temp.next[i].val < target) {
                // move at the same level (from left to right)
                temp = temp.next[i];
            }
        }

        if (temp.next[0] != null && temp.next[0].val == target) {
            return true;
        } else {
            return false;
        }
    }

    public void add(int num) {
        int level = randomLevel();
        // update.next[i] stores the previous positions at each level
        Node temp = head;
        for (int i = level; i >= 0; i--) {
            while (temp.next[i] != null && temp.next[i].val < num) {
                temp = temp.next[i];
            }
        }

        if (temp.next[0] != null && temp.next[0].val == num) {
            // num already exists, increase cnt
            temp.next[0].cnt++;
        } else {
            levelCnt = Math.max(level, levelCnt);
            nodeCnt ++;
            // insert the new node
            Node previous = temp;
            Node node = new Node(num,level);
            node.back = previous;
            for (int i = 0; i <= level; i++) {
                Node f = previous;
                // when while ends, f is ether head or f.level >= i
                while (f.back != null && f.level < i) {
                    f = f.back;
                }

                // set backward on level-0
                if (i==0 && f.next[i]!=null) {
                    f.next[i].back = node;
                }

                // f -> node -> f.next[i]
                node.next[i] = f.next[i];
                f.next[i] = node;
            }
        }
    }

    public boolean erase(int num) {
        if (isEmpty()) {
            return false;
        }

        // update.next[i] stores the previous positions at each level
        Node temp = head;
        for (int i = levelCnt; i >= 0; i--) {
            while (temp.next[i] != null && temp.next[i].val < num) {
                temp = temp.next[i];
            }
        }

        if (temp.next[0] != null && temp.next[0].val == num) {
            nodeCnt --;
            Node node = temp.next[0];
            if (node.cnt > 1) {
                node.cnt--;
            } else {
                Node previous = temp;
                for (int i = 0; i <= node.level; i++) {
                    Node f = previous;
                    // when while ends, f is ether head or f.level >= i
                    while (f.back != null && f.level < i) {
                        f = f.back;
                    }

                    if (i == 0 && f.next[i].next[i] != null) {
                        f.next[i].next[i].back = f;
                    }
                    // previous -> previous.next[i] -> previous.next[i].next[i]
                    // CHANGE TO
                    // previous -> previous.next[i].next[i]
                    f.next[i] = f.next[i].next[i];
                }
            }
            return true;
        } else {
            // num not exists
            return false;
        }
    }

    public int randomLevel() {
        int level = 0;
        while (true) {
            int ran = (int) (Math.random()*100);
            if (ran % 2 == 0) {
                level++;
            } else {
                break;
            }
        }
        return Math.min(level, MAX_LEVEL);
    }

    public boolean isEmpty() {
        return head.next[0].next == null;
    }
    public void print() {
        System.out.println("Node Cnt:" + nodeCnt + ", Level Cnt:" + levelCnt);
        // print each level
        for (int i = levelCnt; i >= 0; i--) {
            Node temp = head.next[i];

            StringBuilder line = new StringBuilder();
            int cnt = 0;
            while (temp!=null) {
                line.append("\t").append(temp.val);
                temp = temp.next[i];
                cnt ++;
            }
            for (int j = 0; j < nodeCnt-cnt; j++) {
                line.insert(0, '\t');
            }
            line.insert(0, 'H');
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();
        skiplist.print();
        skiplist.add(3);
        skiplist.print();
        skiplist.add(2);
        skiplist.print();
        skiplist.add(1);
        skiplist.print();
        boolean s1 = skiplist.search(0); // return False
        skiplist.add(4);
        skiplist.print();
        boolean s2 = skiplist.search(1); // return True
        boolean e1 = skiplist.erase(0);  // return False, 0 is not in skiplist.
        skiplist.print();
        boolean e2 = skiplist.erase(1);  // return True
        skiplist.print();
        boolean s3 = skiplist.search(1); // return False, 1 has already been erased.
        skiplist.print();
    }
}
