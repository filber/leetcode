package math;

// https://leetcode.com/problems/water-bottles/

public class _1518_WaterBottles {

    public static int numWaterBottles(int numBottles, int numExchange) {
        int emptyBottles = numBottles;
        int drink = numBottles;
        while (emptyBottles>=numExchange) {
          drink += emptyBottles / numExchange;
          emptyBottles = emptyBottles / numExchange + emptyBottles % numExchange;
        }
        return drink;
    }

    public static void main(String[] args) {
        int n1 = numWaterBottles(9, 3); // 13
        int n2 = numWaterBottles(15, 4); // 19
        int n3 = numWaterBottles(5, 5); // 6
        int n4 = numWaterBottles(2, 3); // 2
    }
}
