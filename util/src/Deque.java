public class Deque {
    private int[] val;
    int h = 0;
    int t = 0;
    int n;
    public Deque(int n) {
        this.n = n + 1;
        val = new int[this.n];
    }

    public boolean isEmpty() {
        return h==t;
    }

    public void addFirst(int num) {
        val[h] = num;
        h = (h - 1 + n) % n;
    }

    public int pollFirst() {
        h = (h + 1) % n;
        return val[h];
    }

    public int getFirst() {
        return val[(h + 1) % n];
    }

    public void addLast(int num) {
        t = (t + 1) % n;
        val[t] = num;
    }

    public int pollLast() {
        int res = val[t];
        t = (t - 1 + n) % n;
        return res;
    }

    public int getLast() {
        return val[t];
    }
    
}
