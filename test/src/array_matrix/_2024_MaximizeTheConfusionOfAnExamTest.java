package array_matrix;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

public class _2024_MaximizeTheConfusionOfAnExamTest {

    _2024_MaximizeTheConfusionOfAnExam target = null;

    @Before
    public void before() throws Exception {
        target = new _2024_MaximizeTheConfusionOfAnExam();
    }

    @After
    public void after() throws Exception {
    }


    @Test
    public void testMaxConsecutiveAnswers1() throws Exception {
        int len = target.maxConsecutiveAnswers("TTFF", 2);
        assertEquals(4, len);
    }

    @Test
    public void testMaxConsecutiveAnswers2() throws Exception {
        int len = target.maxConsecutiveAnswers("TFFT", 1);
        assertEquals(3, len);
    }

    @Test
    public void testMaxConsecutiveAnswers3() throws Exception {
        int len = target.maxConsecutiveAnswers("TTFTTFTT", 1);
        assertEquals(5, len);
    }
}
