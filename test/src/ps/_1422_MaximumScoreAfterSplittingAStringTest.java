package ps;

import junit.framework.TestCase;

public class _1422_MaximumScoreAfterSplittingAStringTest extends TestCase {

    _1422_MaximumScoreAfterSplittingAString solution;
    public void setUp() throws Exception {
        solution = new _1422_MaximumScoreAfterSplittingAString();
    }

    public void testMaxScore1() {
        String str = "011101";
        int rst = solution.maxScore(str);
        assertEquals(5, rst); // "0" + "11101" = 1 + 4 = 5
    }

    public void testMaxScore2() {
        String str = "00111";
        int rst = solution.maxScore(str);
        assertEquals(5, rst); // "00" + "111" = 2 + 3 = 5
    }

    public void testMaxScore3() {
        String str = "1111";
        int rst = solution.maxScore(str);
        assertEquals(3, rst); // "1" + "111" = 0 + 3 = 5
    }
}