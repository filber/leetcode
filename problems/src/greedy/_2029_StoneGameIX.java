package greedy;

// https://leetcode.com/problems/stone-game-ix/

public class _2029_StoneGameIX {
    // On each turn, the player may remove any stone from stones.
    // The player who removes a stone loses if the sum of the values of all removed stones is divisible by 3.
    // Bob will win automatically if there are no remaining stones (even if it is Alice's turn).

//    假设先手者名为 A ，后手者名为 B 。
//
//    由于只关注是否取完 和 数字和是否 %3==0，我们把这题要取的数字分为三种：
//
//            %3==0 的数字（ 0类型 ）：只要不是第一次取数，并不会对整个数字的和模产生任何影响。
//
//            %3 ==1 的数字（ 1类型 ）：一旦数字和的模已经是2，则游戏结束，只有数字和的模为1才能继续游戏。
//              除第一次，取1使得模变为2。
//
//            %3==2 的数字（ 2类型 ）：一旦数字和的模已经是1，则游戏结束，只有数字和的模为2才能继续游戏。
//              除第一次，取2使得模变为1。
//    根据以上分析：
//
//    一、若 0类型 的数字为偶数个，由于 A 先手必不可能选择这类数字，所以 0类型 的数字不会对结果产生任何影响。
//
//    (1)当 1类型 和 2类型 的数字个数都不为0。
//    则 A 只要先手选到数字更少的那一类，那么就必胜！
//    为什么必胜呢？举个例子假设有 1 1 2 2 2这样的数字，那么 A 选了1后， B 就只能跟着选1，
//    而之后 A 就只能选2。很明显 A 除了第一次选了偏少的那一堆的一个元素以外，
//    其余都是取的偏多的那一堆元素里的数，而 B 只能取偏少的那一堆元素里的数。
//    故总结出整个取数过程除了 A 第一次选择，实际上就是一个对拼消耗的过程，
//    拿着资源数量更多的 A 和拿着资源数量更少的 B 进行对拼消耗，
//    最先消耗完的肯定就是 B 了，则此时 B 就只能被迫选择 A 的那一堆使得和为3的倍数了，最终 A 获胜。
//    (2)当 1类型 或者 2类型 的数字个数为0，那么无论如何都无法逃离 A 输掉的命运。
//    如果个数不为0的数字个数大于等于3个， A 先手取数，故 A 一定是第三个取到它的， A 输，而其他情况则因为数字取完而输掉比赛。
//
//    二、若 0类型 的数字个数为奇数个，同样由于 A 不可能先手取这类数字，
//    但这次由于这类数字是奇数个，可以多出一个来用于替 B 挡灾。
//
//    具体如何使用这个来挡灾呢？ 我们先假设 1类型 和 2类型 的个数是相等的，此时我们的 A 无论以谁起手都是一样的，
//    假设以 1类型 的情况起手，按理来说，接下来 A 都是通过消耗 2类型 的个数来打消耗战，
//    但此时 B 有了额外的一个 0类型 的替身，所以 B 这一轮可以选择不跟 A ，而选择 0类型 ，
//    那么从此 A 就只能选择 1类型 去进行消耗了，于是身份便互换了，
//    假设 1类型 和 2类型 的数字数量开始是 N ，那么这身份互换后的结果就是：拿着数量为N-1的 1类型 的 A 与拿着数量更多的 2类型 的 B 进行对拼消耗，最终的结果肯定是 B 胜。
//    根据以上互换身份的原理， A 在这种情况下，只有选数量多的才能有一线生机，而且至少要比 B 多三份物资，原因在于：
//
//    发生转化的过程还是要消耗掉 1 个。
//    想要让 A 赢，除了让 B 的物资消耗完以外，A 自身还需要留下一份物资供 B 产生3的倍数。
//    此时的对拼消耗过程中 A 处于先手消耗，想要轮到 B 的回合则永远会多消耗一个物资，如 A:2 2 2,B:1 1，对拼过程中明显无法回到B就消耗完了。
//    假设此时 A 选择的这个类型有 N 个，对方的有 M 个，故只要满足$N-3>=M$ 则 A 必胜，否则还是 B 胜。
//
//    因为上面的 N 和 M 所代表的只是 1类型 和 2类型 中数量多和少的类型。故放入题中需要满足的就是 1类型 和 2类型 之间的数量差大于等于3。

    public static boolean stoneGameIX(int[] stones) {
        int[] mod = new int[3];
        for (int i : stones) {
            mod[i % 3]++;
        }

        // alice starts first and looses
        if (mod[1] == 0 && mod[2] == 0) {
            return false;
        }

        if (mod[0] % 2 == 0) {
            return mod[1] != 0 && mod[2] != 0;
        } else {
            return Math.abs(mod[1] - mod[2]) >= 3;
        }
    }

    public static void main(String[] args) {
        // false
        boolean b1 = stoneGameIX(new int[]{3, 3, 3, 3, 3, 3});

        // true
        boolean b2 = stoneGameIX(new int[]{1,2,1,2,});

        // true
        boolean b3 = stoneGameIX(new int[]{1,2,1,});
    }
}
