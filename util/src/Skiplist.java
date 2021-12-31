public class Skiplist {
    private static class Node {
        int val;
        int level;
        Node[] next;
        public Node(int val,int level) {
            this.val = val;
            this.level = level;
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
        Node update = new Node(num, level);
        Node temp = head;
        for (int i = level; i >= 0; i--) {
            while (temp.next[i] != null && temp.next[i].val < num) {
                temp = temp.next[i];
            }
            update.next[i] = temp;
        }

        if (temp.next[0] != null && temp.next[0].val == num) {
            // num already exists, do nothing
        } else {
            levelCnt = Math.max(level, levelCnt);
            nodeCnt ++;
            // insert the new node
            Node node = new Node(num,level);
            for (int i = 0; i <= level; i++) {
                node.next[i] = update.next[i].next[i];
                update.next[i].next[i] = node;
            }
        }
    }

    public boolean erase(int num) {
        // update.next[i] stores the previous positions at each level
        Node update = new Node(num, levelCnt);
        Node temp = head;
        for (int i = levelCnt; i >= 0; i--) {
            while (temp.next[i] != null && temp.next[i].val < num) {
                temp = temp.next[i];
            }
            update.next[i] = temp;
        }

        if (temp.next[0] != null && temp.next[0].val == num) {
            nodeCnt --;
            Node node = temp.next[0];
            for (int i = 0; i <= node.level; i++) {
                update.next[i].next[i] = node.next[i];
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

    public void print() {
        System.out.println("Node Cnt:" + nodeCnt + ", Level Cnt:" + levelCnt);
        // print each level
        for (int i = levelCnt; i >= 0; i--) {
            Node temp = head.next[i];
            System.out.print("H");
            while (temp!=null) {
                System.out.print("\t" + temp.val);
                temp = temp.next[i];
            }
            System.out.println();
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
