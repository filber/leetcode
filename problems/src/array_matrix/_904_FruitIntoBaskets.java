package array_matrix;

//https://leetcode.com/problems/fruit-into-baskets/

public class _904_FruitIntoBaskets {

    int fruit1;
    int fruit2;
    int fruit1Cnt;
    int fruit2Cnt;

    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        if (n < 3) {
            return n;
        }

        int l = 0, r = 1;
        while (r < n && fruits[r] == fruits[0]) {
            r++;
        }
        if (r == n) {
            return n;
        }

        fruit1 = fruits[l];
        fruit2 = fruits[r];
        fruit1Cnt = r - l;
        fruit2Cnt = 1;
        int len = r - l + 1;
        r++;

        while (r < n) {
            int fruit = fruits[r];
            if (fruit == fruit1 || fruit == fruit2) {
                addFruit(fruit);
                len = Math.max(len, r - l + 1);
                r++;
            } else {
                removeFruit(fruits[l]);
                if (fruit1Cnt == 0) {
                    fruit1 = fruit;
                } else if (fruit2Cnt == 0) {
                    fruit2 = fruit;
                }
                l++;
            }
        }

        return len;
    }

    private void removeFruit(int fruit) {
        if (fruit == fruit1) {
            fruit1Cnt--;
        } else {
            fruit2Cnt--;
        }
    }

    private void addFruit(int fruit) {
        if (fruit == fruit1) {
            fruit1Cnt++;
        } else {
            fruit2Cnt++;
        }
    }
}
