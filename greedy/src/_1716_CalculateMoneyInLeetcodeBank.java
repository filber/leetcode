public class _1716_CalculateMoneyInLeetcodeBank {
    public static int totalMoney(int n) {
        int row = n / 7;
        int col = n % 7;
        int[] colIndex = {28, 1, 3, 6, 10, 15, 21};
        int preRowSum = 0;
        if (row != 0) {
            preRowSum = 28 + ((row - 1) * (row - 1) * 7 + 63 * (row - 1)) / 2;
        }
        if (col==0){
            return preRowSum;
        } else {
            int rowSum = colIndex[col] + col * row;
            return preRowSum + rowSum;
        }
    }

    public static void main(String[] args) {
        System.out.println(totalMoney(4));
        System.out.println(totalMoney(10));
        System.out.println(totalMoney(20));
        System.out.println(totalMoney(175));
    }
}
