package greedy;

//https://leetcode.com/problems/candy/

public class _135_Candy {

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];

        // forward
        candies[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i-1]<ratings[i]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        // backward
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i]>ratings[i+1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int sum = 0;
        for (int c : candies) {
            sum += c;
        }
        return sum;
    }
}
