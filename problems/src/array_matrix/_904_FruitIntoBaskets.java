package array_matrix;

//https://leetcode.com/problems/fruit-into-baskets/

public class _904_FruitIntoBaskets {

    int first = Integer.MAX_VALUE;
    int firstCnt = 0;
    int second = Integer.MAX_VALUE;
    int secondCnt = 0;

    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        if (n < 3) {
            return n;
        }
        int len = 0;

        int l = 0, r = 0;
        while (r < n) {
            if (anyBasketEmpty() || contains(fruits[r])) {
                addFruit(fruits[r]);
                r++;
                len = Math.max(len, r - l);
            } else {
                removeFruit(fruits[l]);
                l++;
            }
        }

        return len;
    }

    private boolean anyBasketEmpty() {
        return first == Integer.MAX_VALUE || second == Integer.MAX_VALUE;
    }

    private boolean contains(int fruit) {
        return first == fruit || second == fruit;
    }

    private void addFruit(int fruit) {
        if (contains(fruit)) {
            if (first == fruit) {
                firstCnt++;
            } else {
                secondCnt++;
            }
        } else {
            if (first == Integer.MAX_VALUE) {
                first = fruit;
                firstCnt = 1;
            } else {
                second = fruit;
                secondCnt = 1;
            }
        }
    }

    private void removeFruit(int fruit) {
        if (first == fruit) {
            firstCnt--;
            if (firstCnt == 0) {
                first = Integer.MAX_VALUE;
            }
        } else {
            secondCnt--;
            if (secondCnt == 0) {
                second = Integer.MAX_VALUE;
            }
        }
    }
}
