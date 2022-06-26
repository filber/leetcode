package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _1423_MaximumPointsYouCanObtainFromCardsTest {

    _1423_MaximumPointsYouCanObtainFromCards target = null;

    @Before
    public void before() throws Exception {
        target = new _1423_MaximumPointsYouCanObtainFromCards();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMaxScore1() throws Exception {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        int score = target.maxScore(cardPoints, k);
        assertEquals(12, score);
    }

    @Test
    public void testMaxScore2() throws Exception {
        int[] cardPoints = {2, 2, 2};
        int k = 2;
        int score = target.maxScore(cardPoints, k);
        assertEquals(4, score);
    }

    @Test
    public void testMaxScore3() throws Exception {
        int[] cardPoints = {9, 7, 7, 9, 7, 7, 9};
        int k = 7;
        int score = target.maxScore(cardPoints, k);
        assertEquals(55, score);
    }

}
